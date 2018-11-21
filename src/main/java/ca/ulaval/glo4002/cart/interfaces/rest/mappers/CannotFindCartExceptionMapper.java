package ca.ulaval.glo4002.cart.interfaces.rest.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import ca.ulaval.glo4002.cart.domain.cart.CannotFindCartException;

public class CannotFindCartExceptionMapper implements ExceptionMapper<CannotFindCartException> {
    @Override
    public Response toResponse(CannotFindCartException exception) {
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
