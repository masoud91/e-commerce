package github.devokado.ecommerce.catalog.application.service;

import github.devokado.ecommerce.common.domain.DomainEventListener;
import github.devokado.ecommerce.catalog.domain.product.ProductStockCountUpdated;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductStockCountUpdatedListener implements DomainEventListener<ProductStockCountUpdated> {

    @EventListener
    @Override
    public void handle(ProductStockCountUpdated event) {
        System.out.println("ProductStockCountUpdated event received: ");
        System.out.println("Delta: " + event.getDelta().toString());
    }
}
