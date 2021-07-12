package github.devokado.ecommerce.catalog.domain.product;

import github.devokado.ecommerce.EcommerceApplication;
import github.devokado.ecommerce.common.domain.DomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductAdded implements DomainEvent {

    String id;
    String name;
    Double price;
    Integer stockCount;

    private static final Logger LOGGER = LoggerFactory.getLogger(EcommerceApplication.class);

    public ProductAdded(Product product) {
        LOGGER.info("ProductAdded raised {}", product.toString());
        this.id = product.id.value().toString();
        this.name = product.name.value();
        this.price = product.price.amount();
        this.stockCount = product.stockCount.value();
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Double price() {
        return price;
    }

    public Integer stockCount() {
        return stockCount;
    }

    @Override
    public String toString() {
        return "ProductAdded{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockCount=" + stockCount +
                '}';
    }
}
