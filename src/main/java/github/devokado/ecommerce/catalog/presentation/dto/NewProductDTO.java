package github.devokado.ecommerce.catalog.presentation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class NewProductDTO {
    String name;
    Double price;
    Integer stockCount;
}
