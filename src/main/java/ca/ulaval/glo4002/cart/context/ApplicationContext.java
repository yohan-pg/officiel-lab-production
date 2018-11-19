package ca.ulaval.glo4002.cart.context;

public class ApplicationContext {
    public void apply() {
        if (System.getProperty("store").equalsIgnoreCase("xml")) {
            new XmlPersistenceContext().apply();
        } else {
            new InMemoryPersistenceContext().apply();
        }

        if (System.getProperty("promo").equalsIgnoreCase("true")) {
            new PromoContext().apply();
        } else {
            new NoPromoContext().apply();
        }

        if (System.getProperty("mode").equalsIgnoreCase("demo")) {
            new DemoPrefillContext().apply();
        }
    }
}
