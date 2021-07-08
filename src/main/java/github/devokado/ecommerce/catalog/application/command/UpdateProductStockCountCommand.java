package github.devokado.ecommerce.catalog.application.command;


import github.devokado.ecommerce.catalog.domain.product.StockCount;
import github.devokado.ecommerce.common.application.message.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdateProductStockCountCommand implements Command {
    String id;
    StockCount stock_count;
}
