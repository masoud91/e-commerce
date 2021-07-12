package github.devokado.ecommerce.cart.domain.cart;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository {
    void save(Cart aProduct);

    Optional<Cart> CartOfId(UUID anId);

    UUID nextId();
}
