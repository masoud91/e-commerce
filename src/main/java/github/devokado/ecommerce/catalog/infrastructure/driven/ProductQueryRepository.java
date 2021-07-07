package github.devokado.ecommerce.catalog.infrastructure.driven;


import github.devokado.ecommerce.catalog.application.query.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductQueryRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductDTO> {
}
