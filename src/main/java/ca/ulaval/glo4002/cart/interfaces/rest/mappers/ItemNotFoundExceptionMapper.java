package ca.ulaval.glo4002.cart.interfaces.rest.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import ca.ulaval.glo4002.cart.application.shop.ItemNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemNotFoundExceptionMapper implements ExceptionMapper<ItemNotFoundException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemNotFoundExceptionMapper.class);

	@Override
	public Response toResponse(ItemNotFoundException exception) {
	    LOGGER.debug("Cannot find item", exception);
		return Response.status(Status.NOT_FOUND).build();
	}

}
