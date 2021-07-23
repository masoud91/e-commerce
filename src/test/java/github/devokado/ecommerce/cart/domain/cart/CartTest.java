package github.devokado.ecommerce.cart.domain.cart;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class CartTest {

    @Test
    void shouldAddItemsToCart(){
        Cart cart = new Cart(
                UUID.randomUUID()
        );

        cart.addItem(UUID.randomUUID(), new ItemCount(2));

        assertThat(cart.cartItems().size()).isEqualTo(1);
    }
}
