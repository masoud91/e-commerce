package github.devokado.ecommerce.cart.infrastructure.driven.persistence;

import github.devokado.ecommerce.EcommerceApplication;
import github.devokado.ecommerce.cart.infrastructure.driven.presistence.CartEntity;
import github.devokado.ecommerce.cart.infrastructure.driven.presistence.CartItemEntity;
import github.devokado.ecommerce.cart.infrastructure.driven.presistence.CartJpaRepository;
import github.devokado.ecommerce.cart.infrastructure.driven.presistence.CartMysqlRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CartMysqlRepositoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(EcommerceApplication.class);

    @Autowired
    private CartJpaRepository cartJpaRepository;

//    CartMysqlRepository cartMysqlRepository;
//
//    @Before
//    public void setup(){
//        this.cartMysqlRepository = new CartMysqlRepository(this.cartJpaRepository);
//    }

    @Test
    public void shouldSaveCart(){

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

        CartEntity cartEntityFetched =  cartJpaRepository.findById(id).get();

        assertThat(cartEntityFetched.getId()).isEqualTo(id);
        assertThat(cartEntityFetched.getCartItems().size()).isEqualTo(2);
    }

}
