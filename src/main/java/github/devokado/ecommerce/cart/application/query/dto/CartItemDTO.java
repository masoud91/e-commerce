package github.devokado.ecommerce.cart.application.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartItemDTO {

    String id;
    String productId;
    String productName;
    Double productUnitPrice;
    Double productUnitPriceOld;
    String productImageUrl;
    Integer count;

}
