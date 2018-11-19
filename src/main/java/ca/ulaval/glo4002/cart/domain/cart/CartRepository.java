package ca.ulaval.glo4002.cart.domain.cart;

import java.util.List;

public interface CartRepository {
    List<Cart> listCarts();

    void persistCarts(List<Cart> carts);
}
