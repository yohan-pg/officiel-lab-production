package ca.ulaval.glo4002.cart.interfaces.rest.shop;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import ca.ulaval.glo4002.cart.application.shop.ShopApplicationService;
import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import ca.ulaval.glo4002.cart.interfaces.rest.shop.dto.ShopItemDto;
import ca.ulaval.glo4002.cart.interfaces.rest.shop.dto.ShopItemDtoAssembler;

@Path("/shop")
public class ShopResource {

    private ShopApplicationService shopService;
    private ShopItemDtoAssembler shopItemDtoAssembler;

    public ShopResource() {
        this.shopService = new ShopApplicationService();
        this.shopItemDtoAssembler = new ShopItemDtoAssembler();
    }

    @GET
    @Path("/available-items")
    public List<ShopItemDto> listItems() {
        List<ShopItem> shopItems = shopService.listAvailableItems();
        return shopItemDtoAssembler.toDto(shopItems);
    }
}
