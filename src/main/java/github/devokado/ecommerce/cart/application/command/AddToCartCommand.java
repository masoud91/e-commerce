package github.devokado.ecommerce.cart.application.command;

import github.devokado.ecommerce.common.application.message.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class AddToCartCommand implements Command {
    String userId;
    String itemId;
    Integer count;
}
