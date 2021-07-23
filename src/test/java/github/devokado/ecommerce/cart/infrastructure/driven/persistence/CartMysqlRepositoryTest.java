package github.devokado.ecommerce.cart.infrastructure.driven.persistence;

import github.devokado.ecommerce.cart.infrastructure.driven.presistence.CartEntity;
import github.devokado.ecommerce.cart.infrastructure.driven.presistence.CartItemEntity;
import github.devokado.ecommerce.cart.infrastructure.driven.presistence.CartJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CartMysqlRepositoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartMysqlRepositoryTest.class);

    @Autowired
    private CartJpaRepository cartJpaRepository;

    @Test
    void shouldSaveCart() {

        UUID id = UUID.randomUUID();

        CartEntity cartEntity = new CartEntity();
        cartEntity.setId(id);

        CartItemEntity cartItemEntityOne = new CartItemEntity();
        cartItemEntityOne.setCart(cartEntity);
        cartItemEntityOne.setItemId(UUID.randomUUID());
        cartItemEntityOne.setCount(1);

        CartItemEntity cartItemEntityTwo = new CartItemEntity();
        cartItemEntityTwo.setCart(cartEntity);
        cartItemEntityTwo.setItemId(UUID.randomUUID());
        cartItemEntityTwo.setCount(2);

        Set<CartItemEntity> itemsSet = new HashSet<>();
        itemsSet.add(cartItemEntityOne);
        itemsSet.add(cartItemEntityTwo);

        cartEntity.setCartItems(itemsSet);

        cartJpaRepository.save(cartEntity);

        CartEntity cartEntityFetched = cartJpaRepository.findById(id).orElseThrow();

        assertThat(cartEntityFetched.getId()).isEqualTo(id);
        assertThat(cartEntityFetched.getCartItems().size()).isEqualTo(2);
    }

}
