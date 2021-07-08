package github.devokado.ecommerce.catalog.application.command;


import github.devokado.ecommerce.common.application.message.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class UpdateProductStockCountCommand implements Command {
    String id;
    Integer stockCount;
}
