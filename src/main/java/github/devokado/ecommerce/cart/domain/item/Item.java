package github.devokado.ecommerce.cart.domain.item;

import github.devokado.ecommerce.catalog.domain.product.StockCount;
import github.devokado.ecommerce.common.domain.Money;

import java.util.UUID;

public class Item {

    UUID id;
    Money price;
    StockCount stockCount;

    public Item(UUID id, Money price, StockCount stockCount) {
        this.id = id;
        this.price = price;
        this.stockCount = stockCount;
    }

    public UUID id() {
        return id;
    }

    public Money price() {
        return price;
    }

    public StockCount stockCount() {
        return stockCount;
    }
}
