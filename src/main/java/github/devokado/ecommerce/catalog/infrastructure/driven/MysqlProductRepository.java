package github.devokado.ecommerce.catalog.infrastructure.driven;

import github.devokado.ecommerce.catalog.domain.product.Product;
import github.devokado.ecommerce.catalog.domain.product.ProductId;
import github.devokado.ecommerce.catalog.domain.product.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class MysqlProductRepository implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    public MysqlProductRepository(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public void save(Product aProduct) {
        productJpaRepository.save(ProductEntity.from(aProduct));
    }

    @Override
    public Optional<Product> productOfId(Long anId) {
        return productJpaRepository.findById(anId).map(ProductEntity::toDomain);
    }

    @Override
    public ProductId nextId() {
        return new ProductId(UUID.randomUUID());
    }
}
