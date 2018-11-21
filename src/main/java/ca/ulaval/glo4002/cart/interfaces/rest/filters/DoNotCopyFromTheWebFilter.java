package ca.ulaval.glo4002.cart.interfaces.rest.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class DoNotCopyFromTheWebFilter implements ContainerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(DoNotCopyFromTheWebFilter.class);

    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        if (System.getProperty("param1") != null) {
            CopiedFromTheWebDto copiedFromTheWebDto = new CopiedFromTheWebDto();
            LOGGER.debug(copiedFromTheWebDto.message);
            request.abortWith(Response.status(Status.BAD_REQUEST).entity(copiedFromTheWebDto).build());
        }
    }
}
