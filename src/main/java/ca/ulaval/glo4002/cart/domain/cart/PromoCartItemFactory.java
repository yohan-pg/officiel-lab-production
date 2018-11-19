package ca.ulaval.glo4002.cart.domain.cart;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;

public class PromoCartItemFactory implements CartItemFactory {
    private static final int PROMO_QUANTITY = 2;

    @Override
    public CartItem createItem(ShopItem item) {
        return new CartItem(item.getName(), PROMO_QUANTITY, item.getPriceWithShipping());
    }
}
