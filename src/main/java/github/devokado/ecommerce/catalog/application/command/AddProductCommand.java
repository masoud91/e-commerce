package github.devokado.ecommerce.catalog.application.command;

import github.devokado.ecommerce.common.application.message.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class AddProductCommand implements Command {
    String name;
    Double price;
    Integer stock_count;
}
