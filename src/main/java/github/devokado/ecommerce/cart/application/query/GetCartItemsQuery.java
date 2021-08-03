package github.devokado.ecommerce.cart.application.query;

import github.devokado.ecommerce.cart.application.query.dto.CartItemDTO;
import github.devokado.ecommerce.common.application.message.Query;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
public class GetCartItemsQuery implements Query<List<CartItemDTO>> {
    String cartId;

    public GetCartItemsQuery(String cartId) {
        this.cartId = cartId;
    }
}
