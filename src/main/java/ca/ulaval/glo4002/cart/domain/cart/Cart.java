package ca.ulaval.glo4002.cart.domain.cart;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElementWrapper;

@Entity
public class Cart {

    @Id
	public String ownerEmail;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @XmlElementWrapper(name = "items")
	private List<CartItem> items = new ArrayList<>();

	private Cart() {
		// JAXB
	}

	public Cart(String email) {
		this.ownerEmail = email;
	}

	public void addItem(CartItem item) {
		this.items.add(item);
	}

    public List<CartItem> listItems() {
        return items;
    }
}
