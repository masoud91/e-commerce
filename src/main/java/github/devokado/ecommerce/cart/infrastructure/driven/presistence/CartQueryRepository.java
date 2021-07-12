package github.devokado.ecommerce.cart.infrastructure.driven.presistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CartQueryRepository extends JpaRepository<CartEntity, Long>, JpaSpecificationExecutor<CartEntity> {
}
