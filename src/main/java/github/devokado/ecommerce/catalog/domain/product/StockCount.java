package github.devokado.ecommerce.catalog.domain.product;

import java.util.Objects;

public class StockCount {
    private final Integer value;

    public StockCount(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }

    public StockCount subtract(StockCount anStockCount) {
        return new StockCount(this.value - anStockCount.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockCount that = (StockCount) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
