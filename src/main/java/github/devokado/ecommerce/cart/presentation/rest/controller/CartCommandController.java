package github.devokado.ecommerce.cart.presentation.rest.controller;

import io.swagger.annotations.Api;
import github.devokado.ecommerce.cart.application.command.AddToCartCommand;
import github.devokado.ecommerce.common.application.message.Message;
import github.devokado.ecommerce.cart.presentation.dto.AddToCartDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/me/cart")
@Api(tags="Cart")
public class CartCommandController {

    Message message;

    public CartCommandController(Message message) {
        this.message = message;
    }

    @PostMapping("/add")
    ResponseEntity<?> add(@Valid @RequestBody AddToCartDTO addToCartDTO ) {
        AddToCartCommand addToCartCommand = new AddToCartCommand(
                addToCartDTO.getUserId(),
                addToCartDTO.getItemId(),
                addToCartDTO.getCount()
        );

        message.dispatch(addToCartCommand);
        return ResponseEntity.ok(addToCartDTO);
    }

}
