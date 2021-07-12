package github.devokado.ecommerce.cart.infrastructure.driven.presistence;

import github.devokado.ecommerce.cart.domain.cart.Cart;
import github.devokado.ecommerce.cart.domain.cart.CartRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CartMysqlRepository implements CartRepository {

    private final CartJpaRepository cartJpaRepository;

    public CartMysqlRepository(CartJpaRepository cartJpaRepository) {
        this.cartJpaRepository = cartJpaRepository;
    }

    @Override
    public void save(Cart aCart) {
        cartJpaRepository.save(CartEntity.from(aCart));
    }

    @Override
    public Optional<Cart> CartOfId(UUID anId) {
        return cartJpaRepository.findById(anId).map(CartEntity::toDomain);
    }

    @Override
    public UUID nextId() {
        return UUID.randomUUID();
    }
}
