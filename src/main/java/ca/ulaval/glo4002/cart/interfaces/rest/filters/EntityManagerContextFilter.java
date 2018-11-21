package ca.ulaval.glo4002.cart.interfaces.rest.filters;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.ws.rs.ext.Provider;

import ca.ulaval.glo4002.cart.application.jpa.EntityManagerFactoryProvider;
import ca.ulaval.glo4002.cart.application.jpa.EntityManagerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class EntityManagerContextFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(EntityManagerContextFilter.class);

    private EntityManagerFactory entityManagerFactory;
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        entityManagerFactory = EntityManagerFactoryProvider.getFactory();
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        EntityManager entityManager = null;
 
        try {
            LOGGER.debug("Starting a new DB connection for the request");
            entityManager = entityManagerFactory.createEntityManager();
            EntityManagerProvider.setEntityManager(entityManager);
            LOGGER.debug("Started new DB connection for the request and added it to the thread");
            chain.doFilter(request, response);
        } finally {
            if (entityManager != null) {
                LOGGER.debug("Closing DB connection");
                entityManager.close();
            } else {
                LOGGER.debug("Could not close DB connection");
            }

            LOGGER.debug("Removing DB connection from the local thread");
            EntityManagerProvider.clearEntityManager();
        }
 
    }
 
    @Override
    public void destroy() {
        entityManagerFactory.close();
    }
 
}