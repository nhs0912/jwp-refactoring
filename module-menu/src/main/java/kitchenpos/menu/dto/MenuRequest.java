package kitchenpos.menu.dto;

import kitchenpos.menu.domain.MenuProduct;
import kitchenpos.menu.exceptions.InputMenuDataErrorCode;
import kitchenpos.menu.exceptions.InputMenuDataException;
import kitchenpos.product.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRequest {

    private Long id;
    private String name;
    private BigDecimal price;
    private Long menuGroupId;
    private List<MenuProductRequest> menuProducts;

    protected MenuRequest(){

    }

    public MenuRequest(String name, BigDecimal price, Long menuGroupId, List<MenuProductRequest> menuProducts) {
        this.name = name;
        this.price = price;
        this.menuGroupId = menuGroupId;
        this.menuProducts = menuProducts;
    }

    public List<MenuProduct> toMenuProducts(List<Product> products){
        return products.stream()
                .map(product -> toMenuProduct(product))
                .collect(Collectors.toList());
    }

    public MenuProduct toMenuProduct(Product product) {
        return menuProducts.stream()
                .filter(menuProductRequest -> isSameProduct(product, menuProductRequest))
                .map(menuProductRequest -> menuProductRequest.toEntity(product))
                .findAny()
                .orElseThrow(() -> new InputMenuDataException(InputMenuDataErrorCode.THE_PRODUCT_CAN_NOT_SEARCH));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getMenuGroupId() {
        return menuGroupId;
    }

    public List<Long> getProductIds(){
       return this.menuProducts.stream()
                .map(it -> it.getProductId())
                .collect(Collectors.toList());
    }

    private boolean isSameProduct(Product product, MenuProductRequest menuProductRequest) {
        return menuProductRequest.getProductId() == product.getId();
    }
}