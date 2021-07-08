package github.devokado.ecommerce.catalog.application.service;

import github.devokado.ecommerce.catalog.application.query.GetProductQuery;
import github.devokado.ecommerce.catalog.application.query.dto.ProductDTO;
import github.devokado.ecommerce.catalog.domain.product.ProductId;
import github.devokado.ecommerce.common.application.message.QueryHandler;
import github.devokado.ecommerce.catalog.domain.product.Product;
import github.devokado.ecommerce.catalog.domain.product.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Optional;
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
        Optional<Product> product = productRepository.productOfId(new ProductId(UUID.fromString(query.getId())));

        return product.map(ProductDTO::fromDomain).orElseGet(() -> ProductDTO.fromDomain(product.get()));
    }
}
