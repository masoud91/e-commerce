package github.devokado.ecommerce.catalog.application.command;

import github.devokado.ecommerce.catalog.domain.product.ProductName;
import github.devokado.ecommerce.catalog.domain.product.StockCount;
import github.devokado.ecommerce.common.application.message.Command;
import github.devokado.ecommerce.common.domain.Money;

public class AddProductCommand implements Command {

    ProductName name;
    Money price;
    StockCount stock_count;

    public AddProductCommand(ProductName name, Money price, StockCount stock_count) {
        this.name = name;
        this.price = price;
        this.stock_count = stock_count;
    }

    public ProductName getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public StockCount getStock_count() {
        return stock_count;
    }

    @Override
    public String toString() {
        return "AddProductCommand{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock_count=" + stock_count +
                '}';
    }
}
