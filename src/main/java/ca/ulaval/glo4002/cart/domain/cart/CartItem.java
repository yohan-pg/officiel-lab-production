package ca.ulaval.glo4002.cart.domain.cart;

import javax.xml.bind.annotation.XmlElement;

public class CartItem {

	@XmlElement
	private String name;

	@XmlElement
	private int quantity;

	@XmlElement
    private int totalPrice;

    private CartItem() {
		// JAXB
	}

	public CartItem(String name, int quantity, int totalPrice) {
		this.name = name;
		this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
