package ca.ulaval.glo4002.cart.application.shop;

import java.util.List;
import java.util.stream.Collectors;

import ca.ulaval.glo4002.cart.application.ServiceLocator;
import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;

public class ShopApplicationService {
    private final ShopRepository shopRepository;

    public ShopApplicationService() {
        this.shopRepository = ServiceLocator.INSTANCE.resolve(ShopRepository.class);
    }

    public List<ShopItem> listAvailableItems() {
        List<ShopItem> items = shopRepository.listShopItems();
        if (items.isEmpty()) {
        }

        return items.stream().filter(ShopItem::isAvailable).collect(Collectors.toList());
    }

    public ShopItem findItemBySku(String sku) {
        return listAvailableItems().stream()
                .filter(x -> x.hasSku(sku))
                .findFirst()
                .orElseThrow(ItemNotFoundException::new);
    }
}
