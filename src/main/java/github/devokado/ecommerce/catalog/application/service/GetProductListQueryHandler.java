package github.devokado.ecommerce.catalog.application.service;

import github.devokado.ecommerce.catalog.application.query.GetProductListQuery;
import github.devokado.ecommerce.catalog.application.query.dto.ProductDTO;
import github.devokado.ecommerce.common.application.message.QueryHandler;
import github.devokado.ecommerce.catalog.infrastructure.driven.ProductQueryRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetProductListQueryHandler implements QueryHandler<GetProductListQuery, Page<ProductDTO>> {

    private final ProductQueryRepository productQueryRepository;

    public GetProductListQueryHandler(ProductQueryRepository productQueryRepository) {
        this.productQueryRepository = productQueryRepository;
    }

    @Override
    public Page<ProductDTO> Handle(GetProductListQuery query) {
        return productQueryRepository.findAll(
                (root, criteriaQuery, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();

                    if (query.getName() != null) {
                        predicates.add(
                                criteriaBuilder.like(root.get("name"),
                                "%" + query.getName().toLowerCase() + "%")
                        );
                    }

                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                },
                query.getPageable()
        );
    }
}
