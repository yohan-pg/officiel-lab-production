package ca.ulaval.glo4002.cart.interfaces.rest.cart.dto;

public class CartItemDto {
    public final String name;

    public final int quantity;

    public final int totalPrice;

    public CartItemDto(String name, int quantity, int totalPrice) {
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
