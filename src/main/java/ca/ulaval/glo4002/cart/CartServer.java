package ca.ulaval.glo4002.cart;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import ca.ulaval.glo4002.cart.application.shop.ItemNotFoundException;
import ca.ulaval.glo4002.cart.context.ApplicationContext;
import ca.ulaval.glo4002.cart.interfaces.rest.cart.CartResource;
import ca.ulaval.glo4002.cart.interfaces.rest.filters.CORSFilter;
import ca.ulaval.glo4002.cart.interfaces.rest.filters.DoNotCopyFromTheWebFilter;
import ca.ulaval.glo4002.cart.interfaces.rest.filters.EntityManagerContextFilter;
import ca.ulaval.glo4002.cart.interfaces.rest.mappers.CannotFindCartExceptionMapper;
import ca.ulaval.glo4002.cart.interfaces.rest.mappers.PersistenceExceptionMapper;
import ca.ulaval.glo4002.cart.interfaces.rest.shop.ShopResource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class CartServer implements Runnable {
    private static final int PORT = Integer.parseInt(System.getProperty("port"));

    public static void main(String[] args) {
        new CartServer().run();
    }

    public void run() {
        configureContext();
        startServer();
    }

    private void configureContext() {
        new ApplicationContext().apply();
    }

    private void startServer() {
        Server server = new Server(PORT);
        ServletContextHandler contextHandler = new ServletContextHandler(server, "/");
        contextHandler.addFilter(EntityManagerContextFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));

        // Configuration manuelle au lieu du package scanning
        ResourceConfig packageConfig = new ResourceConfig()
                .registerInstances(createClientResource(), createCartResource())
                .registerInstances(new PersistenceExceptionMapper(), new ItemNotFoundException(),
                        new CannotFindCartExceptionMapper())
                .register(new DoNotCopyFromTheWebFilter())
                .register(new CORSFilter());

        ServletContainer container = new ServletContainer(packageConfig);
        ServletHolder servletHolder = new ServletHolder(container);

        contextHandler.addServlet(servletHolder, "/*");

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.destroy();
        }
    }

    private CartResource createCartResource() {
        return new CartResource();
    }

    private ShopResource createClientResource() {
        return new ShopResource();
    }
}