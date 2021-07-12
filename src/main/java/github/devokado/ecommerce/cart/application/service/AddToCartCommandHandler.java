package github.devokado.ecommerce.cart.application.service;


import github.devokado.ecommerce.cart.application.command.AddToCartCommand;
import github.devokado.ecommerce.cart.domain.cart.Cart;
import github.devokado.ecommerce.cart.domain.cart.CartRepository;
import github.devokado.ecommerce.cart.domain.cart.ItemCount;
import github.devokado.ecommerce.common.application.message.CommandHandler;
import github.devokado.ecommerce.common.application.message.Result;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddToCartCommandHandler implements CommandHandler<AddToCartCommand> {

    private final CartRepository cartRepository;

    public AddToCartCommandHandler(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Result handle(AddToCartCommand command) {

        Cart cart = cartRepository
                .CartOfId(UUID.fromString(command.getUserId()))
                .orElse(new Cart(UUID.fromString(command.getUserId())));

        cart.addItem(UUID.fromString(command.getItemId()), new ItemCount(command.getCount()));

        cartRepository.save(cart);

        return new Result();
    }
}
