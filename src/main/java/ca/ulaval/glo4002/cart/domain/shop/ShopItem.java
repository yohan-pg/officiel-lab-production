package ca.ulaval.glo4002.cart.domain.shop;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlSeeAlso({StandardShopItem.class, PrimeShopItem.class})
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ShopItem {

    @XmlElement
    @JsonProperty
    @Id
    protected String itemSku;

    public String getSku() {
        return itemSku;
    }

    public boolean hasSku(String sku) {
        return this.itemSku.equals(sku);
    }

    public abstract String getName();

    public abstract boolean isAvailable();

    public abstract int getPriceWithShipping();
}
