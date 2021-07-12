package github.devokado.ecommerce.cart.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartDTO {
    String userId;
    String itemId;
    Integer count;
}
