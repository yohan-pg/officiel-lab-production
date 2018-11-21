package ca.ulaval.glo4002.cart.interfaces.rest.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class CORSFilter implements ContainerResponseFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CORSFilter.class);

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        LOGGER.debug("Adding CORS headers");
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        response.getHeaders().add("Access-Control-Allow-Credentials", "true");
        response.getHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}