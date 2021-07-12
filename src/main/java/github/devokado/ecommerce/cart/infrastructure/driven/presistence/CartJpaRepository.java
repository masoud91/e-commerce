package github.devokado.ecommerce.cart.infrastructure.driven.presistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartJpaRepository extends JpaRepository<CartEntity, UUID> {
}
