package github.devokado.ecommerce.catalog.presentation.dto;


import github.devokado.ecommerce.catalog.domain.product.StockCount;

public class NewProductStockCountDTO {
    StockCount stock_count;

    public NewProductStockCountDTO() {
    }

    public NewProductStockCountDTO(StockCount stock_count) {
        this.stock_count = stock_count;
    }

    public StockCount getStock_count() {
        return stock_count;
    }
}
