package github.devokado.ecommerce.catalog.presentation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewProductStockCountDTO {
    Integer stockCount;
}
