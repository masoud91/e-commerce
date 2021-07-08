package github.devokado.ecommerce.catalog.application.query;

import github.devokado.ecommerce.catalog.application.query.dto.ProductDTO;
import github.devokado.ecommerce.common.application.message.Query;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProductQuery implements Query<ProductDTO> {
    private final String id;
}
