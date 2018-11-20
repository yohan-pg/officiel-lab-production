package ca.ulaval.glo4002.cart.context;

public class ApplicationContext {

    public static final String STORE_PARAMETER = "store";
    public static final String PROMO_PARAMETER = "promo";
    public static final String MODE_PARAMETER = "mode";

    public void apply() {
        if (hasParameterValue(STORE_PARAMETER, "xml")) {
            new XmlPersistenceContext().apply();
        } else if (hasParameterValue(STORE_PARAMETER, "hibernate")) {
            new HibernatePersistenceContext().apply();
        } else if (hasParameterValue(STORE_PARAMETER, "memory")) {
            new InMemoryPersistenceContext().apply();
        } else {
            throw new RuntimeException(
                    "No story parameter provided. Requires -D" + STORE_PARAMETER + "=xml|memory|hibernate");
        }

        if (hasParameterValue(PROMO_PARAMETER, "true")) {
            new PromoContext().apply();
        } else {
            new NoPromoContext().apply();
        }

        if (hasParameterValue(MODE_PARAMETER, "demo")) {
            new DemoPrefillContext().apply();
        }
    }

    private boolean hasParameterValue(String parameter, String value) {
        String property = System.getProperty(parameter);
        return property != null && property.equalsIgnoreCase(value);
    }
}
