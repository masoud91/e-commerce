package github.devokado.ecommerce.catalog.infrastructure.driven;

import github.devokado.ecommerce.catalog.domain.product.Product;
import github.devokado.ecommerce.catalog.domain.product.ProductId;
import github.devokado.ecommerce.catalog.domain.product.ProductName;
import github.devokado.ecommerce.catalog.domain.product.StockCount;
import github.devokado.ecommerce.common.domain.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @Type(type="uuid-char")
    private UUID id;
    private String name;
    private Double price;
    private Integer stockCount;

    public static ProductEntity from(Product aProduct) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(aProduct.id().value());
        productEntity.setName(aProduct.name().value());
        productEntity.setPrice(aProduct.price().amount());
        productEntity.setStockCount(aProduct.stockCount().value());

        return productEntity;
    }

    public Product toDomain() {
        return new Product(
                new ProductId(this.getId()),
                new ProductName(this.getName()),
                new Money(this.getPrice()),
                new StockCount(this.getStockCount())
        );
    }
}
