package github.devokado.ecommerce.catalog.presentation.dto;


import github.devokado.ecommerce.catalog.domain.product.ProductName;
import github.devokado.ecommerce.catalog.domain.product.StockCount;
import github.devokado.ecommerce.common.domain.Money;

public class NewProductDTO {
    ProductName name;
    Money price;
    StockCount stock_count;

    public NewProductDTO(){
    }

    public NewProductDTO(ProductName name, Money price, StockCount stock_count) {
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
}
