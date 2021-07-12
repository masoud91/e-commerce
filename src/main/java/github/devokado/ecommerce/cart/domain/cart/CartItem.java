package github.devokado.ecommerce.cart.domain.cart;


import github.devokado.ecommerce.common.domain.BaseValueObject;

import java.util.UUID;

public class CartItem extends BaseValueObject {
    private final UUID itemId;
    private final ItemCount count;

    public CartItem(UUID itemId, ItemCount count) {
        this.itemId = itemId;
        this.count = count;
    }

    public UUID itemId() {
        return itemId;
    }

    public ItemCount count() {
        return count;
    }
}
