package github.devokado.ecommerce.catalog.application.command;


import github.devokado.ecommerce.catalog.domain.product.StockCount;
import github.devokado.ecommerce.common.application.message.Command;

public class UpdateProductStockCountCommand implements Command {
    Long id;
    StockCount stock_count;

    public UpdateProductStockCountCommand(Long id, StockCount stock_count) {
        this.id = id;
        this.stock_count = stock_count;
    }

    public Long getId() {
        return id;
    }

    public StockCount getStock_count() {
        return stock_count;
    }
}
