package github.devokado.ecommerce.catalog.domain.product;

import java.util.UUID;

public class ProductId {
    private final UUID id;

    public ProductId(UUID id) {
        this.id = id;
    }

    public UUID value(){
        return this.id;
    }
}
