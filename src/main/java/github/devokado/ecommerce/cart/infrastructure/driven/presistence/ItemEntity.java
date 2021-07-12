package github.devokado.ecommerce.cart.infrastructure.driven.presistence;

import github.devokado.ecommerce.cart.domain.item.Item;
import github.devokado.ecommerce.catalog.domain.product.StockCount;
import github.devokado.ecommerce.common.domain.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class ItemEntity {

    @Id
    @Type(type="uuid-char")
    UUID id;
    String name;
    Double price;
    Integer stockCount;

    public Item toDomain() {
        return new Item(
                this.getId(),
                new Money(this.getPrice()),
                new StockCount(this.getStockCount())
        );
    }
}
