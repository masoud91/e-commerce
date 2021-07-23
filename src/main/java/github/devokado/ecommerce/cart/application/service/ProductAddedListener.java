package github.devokado.ecommerce.cart.application.service;

import github.devokado.ecommerce.cart.infrastructure.driven.presistence.ItemEntity;
import github.devokado.ecommerce.cart.infrastructure.driven.presistence.ItemJpaRepository;
import github.devokado.ecommerce.catalog.domain.product.ProductAdded;
import github.devokado.ecommerce.common.application.event.DomainEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductAddedListener implements DomainEventListener<ProductAdded> {

    private final ItemJpaRepository repository;

    public ProductAddedListener(ItemJpaRepository repository) {
        this.repository = repository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductAddedListener.class);

    @Override
    public void handle(ProductAdded productAdded) {
        LOGGER.info("ProductStockCountUpdated event received: {}", productAdded);
        ItemEntity itemEntity = new ItemEntity(
                UUID.fromString(productAdded.id()),
                productAdded.name(),
                productAdded.price(),
                productAdded.stockCount()
        );

        repository.save(itemEntity);
    }
}
