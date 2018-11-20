package ca.ulaval.glo4002.cart.context;

import ca.ulaval.glo4002.cart.application.ServiceLocator;
import ca.ulaval.glo4002.cart.domain.cart.CartRepository;
import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.hibernate.HibernateCartRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.hibernate.HibernateShopRepository;

public class HibernatePersistenceContext {
    public void apply() {
        ServiceLocator.INSTANCE.register(ShopRepository.class, new HibernateShopRepository());
        ServiceLocator.INSTANCE.register(CartRepository.class, new HibernateCartRepository());
    }
}
