package ca.ulaval.glo4002.cart.interfaces.rest.cart.dto;

import java.util.List;

public class CartDto {
    public final List<CartItemDto> items;

    public CartDto(List<CartItemDto> items) {
        this.items = items;
    }
}
