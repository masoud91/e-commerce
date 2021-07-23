package github.devokado.ecommerce.catalog.domain.product;

import github.devokado.ecommerce.common.domain.DomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductStockCountUpdated implements DomainEvent {

    Integer delta;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductStockCountUpdated.class);

    public ProductStockCountUpdated(Integer delta) {
        LOGGER.info("ProductStockCountUpdated raised delta: {}", delta);
        this.delta = delta;
    }

    public Integer getDelta() {
        return delta;
    }

    @Override
    public String toString() {
        return "ProductStockCountUpdated{" +
                "delta=" + delta +
                '}';
    }
}
