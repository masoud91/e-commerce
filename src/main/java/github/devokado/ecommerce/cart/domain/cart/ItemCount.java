package github.devokado.ecommerce.cart.domain.cart;

public class ItemCount {
    private final Integer value;

    public ItemCount(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }
}
