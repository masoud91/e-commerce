package github.devokado.ecommerce.cart.application.service;

import github.devokado.ecommerce.cart.application.query.GetCartItemsQuery;
import github.devokado.ecommerce.cart.application.query.dto.CartItemDTO;
import github.devokado.ecommerce.common.application.message.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCartItemsQueryHandler implements QueryHandler<GetCartItemsQuery, List<CartItemDTO>> {

    @Override
    public List<CartItemDTO> Handle(GetCartItemsQuery query) {
        CartItemDTO cartItemDTO =
                new CartItemDTO(
                        "randomIDForCartItem",
                        "IDForProduct",
                        "iPhone 12 Pro",
                        989.99,
                        1199.99,
                        "https://jdro.ir/images/iphone12.png",
                        3
                );
        return List.of(cartItemDTO);
    }
}
