package ca.ulaval.glo4002.cart.interfaces.rest.shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShopItemDto {
    @JsonProperty
    public final String name;

    @JsonProperty
    public final String itemSku;

    public ShopItemDto(String name, String itemSku) {
        this.name = name;
        this.itemSku = itemSku;
    }
}
