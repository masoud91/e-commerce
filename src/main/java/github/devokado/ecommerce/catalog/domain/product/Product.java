package github.devokado.ecommerce.catalog.domain.product;

import github.devokado.ecommerce.common.domain.BaseAggregateRoot;

public class Product extends BaseAggregateRoot {

    Long id;
    String name;
    Integer price;
    Integer stockCount;

    public Product(Long id, String name, Integer price, Integer stockCount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockCount = stockCount;
    }

    public void updateStockCount(Integer newStockCount) {
        Integer delta = newStockCount - this.stockCount();
        this.stockCount = newStockCount;
        this.registerEvent(new ProductStockCountUpdated(delta));
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Integer price() {
        return price;
    }

    public Integer stockCount() {
        return stockCount;
    }
}
