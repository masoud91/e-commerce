package github.devokado.ecommerce.catalog.application.query.dto;

import github.devokado.ecommerce.catalog.domain.product.Product;

public class ProductDTO {

    String id;
    String name;
    Double price;
    Integer stock_count;

    public ProductDTO(String id, String name, Double price, Integer stock_count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock_count = stock_count;
    }

    public static ProductDTO fromDomain(Product aDomain) {
        return new ProductDTO(
                aDomain.id().toString(),
                aDomain.name().value(),
                aDomain.price().amount(),
                aDomain.stockCount().value()
        );
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock_count() {
        return stock_count;
    }
}
