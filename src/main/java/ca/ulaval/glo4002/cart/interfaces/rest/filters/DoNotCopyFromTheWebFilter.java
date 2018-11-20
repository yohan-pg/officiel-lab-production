package ca.ulaval.glo4002.cart.interfaces.rest.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class DoNotCopyFromTheWebFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        if (System.getProperty("param1") != null) {
            request.abortWith(Response.status(Status.BAD_REQUEST).entity(new CopiedFromTheWebDto()).build());
        }
    }
}
