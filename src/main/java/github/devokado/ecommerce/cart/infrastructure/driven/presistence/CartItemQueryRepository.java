package github.devokado.ecommerce.cart.infrastructure.driven.presistence;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemQueryRepository extends JpaRepository<CartEntity, Long> {

}
