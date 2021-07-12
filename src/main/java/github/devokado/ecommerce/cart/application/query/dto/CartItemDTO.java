package github.devokado.ecommerce.cart.application.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartItemDTO {

    String id;
    String product_id;
    String product_name;
    Double product_unit_price;
    Double product_unit_price_old;
    String product_image_url;
    Integer count;

}
