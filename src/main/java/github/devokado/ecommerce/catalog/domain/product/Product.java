package github.devokado.ecommerce.catalog.domain.product;

import github.devokado.ecommerce.common.domain.BaseAggregateRoot;
import github.devokado.ecommerce.common.domain.Money;

import java.util.HashSet;
import java.util.Set;

public class Product extends BaseAggregateRoot {

    ProductId id;
    ProductName name;
    Money price;
    StockCount stockCount;
    Set<Tag> tags = new HashSet<>();

    public Product(ProductId id, ProductName name, Money price, StockCount stockCount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockCount = stockCount;

        this.registerEvent(new ProductAdded(this));
    }

    public void updateStockCount(StockCount newStockCount) {
        StockCount delta = newStockCount.subtract(this.stockCount());
        this.stockCount = newStockCount;
        this.registerEvent(new ProductStockCountUpdated(delta.value()));
    }

    public void addTag(String tagName) {
        tags.add(new Tag(tagName));
    }

    public ProductId id() {
        return id;
    }

    public ProductName name() {
        return name;
    }

    public Money price() {
        return price;
    }

    public StockCount stockCount() {
        return stockCount;
    }

    public Set<Tag> tags() {
        return tags;
    }
}
