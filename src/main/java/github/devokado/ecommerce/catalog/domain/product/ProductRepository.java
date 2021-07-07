package github.devokado.ecommerce.catalog.domain.product;

import java.util.Optional;

public interface ProductRepository {
    void save(Product aProduct);

    Optional<Product> productOfId(Long anId);

    ProductId nextId();
}
