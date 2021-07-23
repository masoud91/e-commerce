package github.devokado.ecommerce.catalog.domain;

import github.devokado.ecommerce.catalog.domain.product.*;
import github.devokado.ecommerce.common.domain.Money;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static github.devokado.ecommerce.common.domain.EventTester.*;

class ProductTest {

    @Test
    void shouldUpdateStockCount() {
        Product product = new Product(
                new ProductId(UUID.randomUUID()),
                new ProductName("a product name"),
                new Money(80.99),
                new StockCount(2)
        );

        product.updateStockCount(new StockCount(3));

        assertThat(product.stockCount().equals(new StockCount(3))).isTrue();
        assertThat(expectedEvents(product.events(), ProductStockCountUpdated.class)).isEqualTo(1);
    }



}
