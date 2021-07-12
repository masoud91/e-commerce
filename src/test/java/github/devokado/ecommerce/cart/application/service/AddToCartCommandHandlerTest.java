package github.devokado.ecommerce.cart.application.service;

import github.devokado.ecommerce.cart.application.command.AddToCartCommand;
import github.devokado.ecommerce.cart.domain.cart.Cart;
import github.devokado.ecommerce.cart.domain.cart.CartRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
public class AddToCartCommandHandlerTest {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private AddToCartCommandHandler commandHandler;

    @Test
    @Disabled
    public void shouldAddItemToCart() {
        UUID userId = UUID.randomUUID();
        UUID itemId = UUID.randomUUID();

        AddToCartCommand command = new AddToCartCommand(
                userId.toString(),
                itemId.toString(),
                1
        );

//        doNothing().when(cartRepository).save(any(Cart.class));

        commandHandler.handle(command);

        Cart cart = cartRepository.CartOfId(userId).get();

        assertThat(cart.id().toString()).isEqualTo(command.getUserId());
    }
}
