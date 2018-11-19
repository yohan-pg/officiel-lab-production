package ca.ulaval.glo4002.cart.infrastructure.persistence.memory;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4002.cart.domain.cart.Cart;
import ca.ulaval.glo4002.cart.domain.cart.CartRepository;

public class InMemoryCartRepository implements CartRepository {
    private static final List<Cart> CARTS = new ArrayList<>();
    @Override
    public List<Cart> listCarts() {
        return new ArrayList<>(CARTS);
    }

    @Override
    public synchronized void persistCarts(List<Cart> newCarts) {
        CARTS.clear();
        CARTS.addAll(newCarts);
    }
}
