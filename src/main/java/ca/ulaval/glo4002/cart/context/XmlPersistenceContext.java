package ca.ulaval.glo4002.cart.context;

import ca.ulaval.glo4002.cart.application.ServiceLocator;
import ca.ulaval.glo4002.cart.domain.cart.CartRepository;
import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.xml.XmlCartRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.xml.XmlShopRepository;

public class XmlPersistenceContext {
    public void apply() {
        ServiceLocator.INSTANCE.register(ShopRepository.class, new XmlShopRepository());
        ServiceLocator.INSTANCE.register(CartRepository.class, new XmlCartRepository());
    }
}
