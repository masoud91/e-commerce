package github.devokado.ecommerce.cart.infrastructure.driven.presistence;

import github.devokado.ecommerce.cart.domain.cart.CartItem;
import github.devokado.ecommerce.cart.domain.cart.ItemCount;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude="cart")
@ToString(exclude="cart")
@Table(name = "cart_item")
public class CartItemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private CartEntity cart;

    @Type(type="uuid-char")
    private UUID itemId;

    @Column(name = "count")
    private Integer count;

    public CartItemEntity(CartEntity cart, UUID itemId, Integer count) {
        this.cart = cart;
        this.itemId = itemId;
        this.count = count;
    }

    public CartItem toDomain() {
        return new CartItem(
                this.getItemId(),
                new ItemCount(this.getCount())
        );
    }

}
