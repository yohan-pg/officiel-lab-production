package ca.ulaval.glo4002.cart.domain.shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class StandardShopItem extends ShopItem {
    private static final int PRICE_PER_KG = 2;

    @XmlElement
    @JsonProperty
    @Column
    private String name;

    @XmlElement
    @JsonProperty
    @Column
    private boolean available;

    @XmlElement
    @JsonProperty
    @Column
    private int price;

    @XmlElement
    @JsonProperty
    @Column
    private int weight;

    @XmlElement
    @JsonProperty
    @Column
    private double profitMarginPercentage;

    private StandardShopItem() {
        // JAXB
    }

    public StandardShopItem(String itemSku, String name, int price, int weight, double profitMarginPercentage,
            boolean available) {
        this.itemSku = itemSku;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.profitMarginPercentage = profitMarginPercentage;
        this.available = available;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public int getPriceWithShipping() {
        return price + weight * PRICE_PER_KG;
    }
}
