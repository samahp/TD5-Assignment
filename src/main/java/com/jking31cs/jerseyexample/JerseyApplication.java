package com.jking31cs.jerseyexample;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

/**
 * This handles setting up Jersey to handle requests and automatically converting request bodies and input parameters
 * into Java Bean objects using Jackson.  We also set up Guice in here to work with our Jersey Web Services so that we
 * can inject in any variety of services into our web services.
 */
public class JerseyApplication extends ResourceConfig {

    @Inject
    public JerseyApplication(@Context ServletContext servletContext, ServiceLocator serviceLocator) {

        //registers the Jackson stuff
        register(JacksonJaxbJsonProvider.class);
        register(ObjectMapperResolver.class);

        // Then, enable the bridge between jersey and guice.
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(JerseyGuiceServletConfig.getOrCreateInjector());
    }
}
