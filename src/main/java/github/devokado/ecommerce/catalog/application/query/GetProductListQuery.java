package github.devokado.ecommerce.catalog.application.query;

import github.devokado.ecommerce.catalog.application.query.dto.ProductDTO;
import github.devokado.ecommerce.common.application.message.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GetProductListQuery implements Query<Page<ProductDTO>> {
    private final String name;
    private final Pageable pageable;

    public GetProductListQuery(String name, Pageable pageable) {
        this.name = name;
        this.pageable = pageable;
    }

    public String getName() {
        return name;
    }

    public Pageable getPageable() {
        return pageable;
    }
}
