package github.devokado.ecommerce.catalog.domain;

import github.devokado.ecommerce.catalog.domain.product.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void shouldUpdateStockCount() {
        Product product = new Product(
                1L,
                "a product name",
                100,
                2
        );

        product.updateStockCount(3);

        assertThat(product.stockCount()).isEqualTo(3);
        assertThat(product.events().size()).isEqualTo(1);
    }

}
