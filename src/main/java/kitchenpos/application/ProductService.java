package kitchenpos.application;

import java.util.stream.Collectors;
import kitchenpos.domain.Product;
import kitchenpos.dto.ProductCreateRequest;
import kitchenpos.dto.ProductDto;
import kitchenpos.repository.ProductDao;
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
    public ProductDto create(final ProductCreateRequest product) {
        Product savedProduct = productDao.save(product.toEntity());
        return ProductDto.of(savedProduct);
    }

    public List<ProductDto> list() {
        return productDao.findAll()
                .stream()
                .map(ProductDto::of)
                .collect(Collectors.toList());
    }
}