package kitchenpos.product.application;

import kitchenpos.product.domain.ProductDao;
import kitchenpos.product.domain.Product;
import kitchenpos.product.exception.InputProductDataErrorCode;
import kitchenpos.product.exception.InputProductDataException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private final ProductDao productDao;

    public ProductService(final ProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional
    public Product create(final Product product) {
        final BigDecimal price = product.getPrice();

        if (Objects.isNull(price) || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new InputProductDataException(InputProductDataErrorCode.IT_CAN_NOT_INPUT_PRICE_LESS_THAN_ZERO);
        }

        return productDao.save(product);
    }

    public List<Product> list() {
        return productDao.findAll();
    }
}
