package github.devokado.ecommerce.cart.presentation.rest.controller;

import io.swagger.annotations.Api;
import github.devokado.ecommerce.cart.application.query.GetCartItemsQuery;
import github.devokado.ecommerce.cart.application.query.dto.CartItemDTO;
import github.devokado.ecommerce.common.application.message.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/cart")
@Api(tags="Cart")
public class CartQueryController {

    Message message;

    public CartQueryController(Message message) {
        this.message = message;
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<List<CartItemDTO>> getItems(@PathVariable String cartId) {
        GetCartItemsQuery query = new GetCartItemsQuery(cartId);
        List<CartItemDTO> cartItems = message.dispatch(query);
        return ResponseEntity.ok(cartItems);
    }

}
