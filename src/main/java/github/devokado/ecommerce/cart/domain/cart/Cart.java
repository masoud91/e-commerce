package github.devokado.ecommerce.cart.domain.cart;


import github.devokado.ecommerce.common.domain.BaseAggregateRoot;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Cart extends BaseAggregateRoot {

    private final UUID id;

    private Set<CartItem> cartItems = new HashSet<>();

    public Cart(UUID id) {
        this.id = id;
    }

    public Cart(UUID id, Set<CartItem> cartItems) {
        this.id = id;
        this.cartItems = cartItems;
    }

    public void addItem(UUID itemId, ItemCount count) {
        this.cartItems.add(new CartItem(itemId, count));
    }

    public UUID id(){
        return id;
    }

    public Set<CartItem> cartItems() {
        return cartItems;
    }
}


//// begin transaction
// get item count from DB and check for valid count
// add item into cart
// subtract count from item
// save cart
// save item
//// commit transaction
