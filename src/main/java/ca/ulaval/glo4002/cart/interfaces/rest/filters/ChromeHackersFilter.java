package ca.ulaval.glo4002.cart.interfaces.rest.filters;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class ChromeHackersFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        String userAgent = request.getHeaders().getFirst("User-Agent");
        Logger.getGlobal().info("Found agent : " + userAgent);

        if (userAgent.contains("Chrome/")) {
            request.abortWith(Response.status(Status.BAD_REQUEST).entity(new HackerDetectedDto()).build());
        }
    }
}