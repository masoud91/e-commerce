package github.devokado.ecommerce.catalog.domain.product;

public class ProductName {
    private final String name;

    public ProductName(String name) {
        this.name = name;
    }

    public String value() {
        return name;
    }
}
