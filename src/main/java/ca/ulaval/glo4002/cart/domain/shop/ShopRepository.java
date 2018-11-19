package ca.ulaval.glo4002.cart.domain.shop;

import java.util.List;

public interface ShopRepository {
    List<ShopItem> listShopItems();

    void persistShop(List<ShopItem> items);
}
