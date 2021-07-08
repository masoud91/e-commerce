package github.devokado.ecommerce.catalog.application.query.dto;

import github.devokado.ecommerce.catalog.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {

    String id;
    String name;
    Double price;
    Integer stock_count;

    public static ProductDTO fromDomain(Product aDomain) {
        return new ProductDTO(
                aDomain.id().toString(),
                aDomain.name().value(),
                aDomain.price().amount(),
                aDomain.stockCount().value()
        );
    }
}
