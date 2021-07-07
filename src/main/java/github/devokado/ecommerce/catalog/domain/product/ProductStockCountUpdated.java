package github.devokado.ecommerce.catalog.domain.product;

import github.devokado.ecommerce.common.domain.DomainEvent;

public class ProductStockCountUpdated implements DomainEvent {

    Integer delta;

    public ProductStockCountUpdated(Integer delta) {
        System.out.println("ProductStockCountUpdated created");
        this.delta = delta;
    }

    public Integer getDelta() {
        return delta;
    }
}
