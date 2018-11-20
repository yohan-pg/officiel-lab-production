package ca.ulaval.glo4002.cart.infrastructure.persistence.hibernate;

import java.util.List;

import javax.persistence.EntityManager;

import ca.ulaval.glo4002.cart.application.jpa.EntityManagerProvider;
import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;

public class HibernateShopRepository implements ShopRepository {

    @Override
    public List<ShopItem> listShopItems() {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        return entityManager.createQuery("from ShopItem", ShopItem.class).getResultList();
    }

    @Override
    public synchronized void persistShop(List<ShopItem> newItems) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        newItems.forEach(x -> entityManager.merge(x));
        entityManager.getTransaction().commit();
    }
}
