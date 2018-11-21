package ca.ulaval.glo4002.cart.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ServiceLocator {
    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLocator.class);

    private Map<Class<?>, Object> instances = new HashMap<>();

    public <T> void register(Class<T> contract, T service) {
        LOGGER.debug("Registering service " + contract.getCanonicalName() + " to implementation " + service.getClass()
                .getCanonicalName());

        if (instances.containsKey(contract)) {
            LOGGER.debug("Service already exists! Aborting");
            throw new ServiceAlreadyRegisteredException(contract);
        }

        instances.put(contract, service);
    }

    public <T> T resolve(Class<T> contract) {
        LOGGER.debug("Trying to resolve contract " + contract.getCanonicalName());
        T service = (T) instances.get(contract);
        LOGGER.debug("Resolved to " + (service == null ? "NOTHING!" : service.getClass().getCanonicalName()));
        return Optional.ofNullable(service).orElseThrow(() -> new UnknownServiceResolvedException(contract));
    }
}