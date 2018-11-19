package ca.ulaval.glo4002.cart.interfaces.rest.cart;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ca.ulaval.glo4002.cart.application.cart.CartApplicationService;
import ca.ulaval.glo4002.cart.application.shop.ShopApplicationService;
import ca.ulaval.glo4002.cart.domain.cart.Cart;
import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import ca.ulaval.glo4002.cart.interfaces.rest.cart.dto.CartAssembler;
import ca.ulaval.glo4002.cart.interfaces.rest.cart.dto.CartDto;

@Path("/clients/{" + CartResource.EMAIL_PARAMETER + "}/cart")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CartResource {
	static final String EMAIL_PARAMETER = "email";
	private static final String SKU_PARAMETER = "sku";

    private final CartAssembler cartAssembler;

    private CartApplicationService cartService;
	private ShopApplicationService shopService;

    public CartResource() {
        this.cartService = new CartApplicationService();
        this.shopService = new ShopApplicationService();
        this.cartAssembler = new CartAssembler();
    }

    @GET
	public CartDto getCart(@PathParam(EMAIL_PARAMETER) String email) {
        Cart cart = cartService.findOrCreateCartForClient(email);
        return cartAssembler.toDto(cart);
	}

	@PUT
	@Path("/{" + SKU_PARAMETER + "}")
	public Response addItemToCart(@PathParam(EMAIL_PARAMETER) String email, @PathParam(SKU_PARAMETER) String sku) {
		// TODO this resource does too much
		ShopItem shopItem = shopService.findItemBySku(sku);
		cartService.addItemToCart(email, shopItem);
		return Response.ok().build();
	}
}