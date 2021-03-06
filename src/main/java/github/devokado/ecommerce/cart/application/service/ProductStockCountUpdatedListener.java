package github.devokado.ecommerce.cart.application.service;

import github.devokado.ecommerce.catalog.domain.product.ProductStockCountUpdated;
import github.devokado.ecommerce.common.application.event.DomainEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductStockCountUpdatedListener implements DomainEventListener<ProductStockCountUpdated> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductStockCountUpdatedListener.class);

    @EventListener
    @Override
    public void handle(ProductStockCountUpdated productStockCountUpdated) {
        LOGGER.info("ProductStockCountUpdated event received: {}", productStockCountUpdated);
    }
}
