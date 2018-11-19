package ca.ulaval.glo4002.cart.interfaces.rest.cart.dto;

import ca.ulaval.glo4002.cart.domain.cart.Cart;
import ca.ulaval.glo4002.cart.domain.cart.CartItem;

import static java.util.stream.Collectors.toList;

public class CartAssembler {
    public CartDto toDto(Cart cart) {
        return new CartDto(cart.listItems().stream().map(this::toDto).collect(toList()));
    }

    public CartItemDto toDto(CartItem cartItem) {
        return new CartItemDto(cartItem.getName(), cartItem.getQuantity(), cartItem.getTotalPrice());
    }
}
