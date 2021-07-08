package github.devokado.ecommerce.catalog.application.service;

import github.devokado.ecommerce.catalog.application.query.GetProductQuery;
import github.devokado.ecommerce.catalog.application.query.dto.ProductDTO;
import github.devokado.ecommerce.catalog.domain.product.Product;
import github.devokado.ecommerce.catalog.domain.product.ProductId;
import github.devokado.ecommerce.catalog.domain.product.ProductRepository;
import github.devokado.ecommerce.common.application.message.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.UUID;

@Service
public class GetProductQueryHandler implements QueryHandler<GetProductQuery, ProductDTO> {

    private final ProductRepository productRepository;

    public GetProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @TransactionalEventListener
    public ProductDTO Handle(GetProductQuery query) {
        Product product =
                productRepository.productOfId(
                        new ProductId(UUID.fromString(query.getId()))
                ).orElseThrow(RuntimeException::new);

        return ProductDTO.fromDomain(product);
    }
}
