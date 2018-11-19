package ca.ulaval.glo4002.cart.domain.cart;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;

public class RegularCartItemFactory implements CartItemFactory {

    public static final int REGULAR_QUANTITY = 1;

    @Override
    public CartItem createItem(ShopItem item) {
        return new CartItem(item.getName(), REGULAR_QUANTITY, item.getPriceWithShipping());
    }
}
