package ca.ulaval.glo4002.cart.interfaces.rest.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import ca.ulaval.glo4002.cart.domain.cart.CannotFindCartException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CannotFindCartExceptionMapper implements ExceptionMapper<CannotFindCartException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CannotFindCartExceptionMapper.class);

    @Override
    public Response toResponse(CannotFindCartException exception) {
        LOGGER.debug("Cannot find cart", exception);
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
