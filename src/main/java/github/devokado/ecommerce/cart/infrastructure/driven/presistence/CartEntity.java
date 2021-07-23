package github.devokado.ecommerce.cart.infrastructure.driven.presistence;

import github.devokado.ecommerce.cart.domain.cart.Cart;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cart")
public class CartEntity {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "cart_id")
    private UUID id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItemEntity> cartItems;

    public static CartEntity from(Cart aCart) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setId(aCart.id());

        Set<CartItemEntity> cartItemEntities = new HashSet<>();
        aCart.cartItems().forEach(x ->
                cartItemEntities.add(new CartItemEntity(cartEntity, x.itemId(), x.count().value())));

        cartEntity.setCartItems(cartItemEntities);

        return cartEntity;
    }

    public Cart toDomain() {
        return new Cart(
                this.getId(),
                this.getCartItems().stream().map(CartItemEntity::toDomain).collect(Collectors.toSet())
        );
    }
}
