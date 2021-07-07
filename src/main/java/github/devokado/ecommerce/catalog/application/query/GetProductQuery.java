package github.devokado.ecommerce.catalog.application.query;

import github.devokado.ecommerce.catalog.application.query.dto.ProductDTO;
import github.devokado.ecommerce.common.application.message.Query;

public class GetProductQuery implements Query<ProductDTO> {
    private final Long id;

    public GetProductQuery(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
