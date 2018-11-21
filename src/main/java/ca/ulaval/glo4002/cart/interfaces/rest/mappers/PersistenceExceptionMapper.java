package ca.ulaval.glo4002.cart.interfaces.rest.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import ca.ulaval.glo4002.cart.application.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistenceExceptionMapper implements ExceptionMapper<PersistenceException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceExceptionMapper.class);

    @Override
    public Response toResponse(PersistenceException exception) {
        LOGGER.debug("Persistence error occurred", exception);
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
