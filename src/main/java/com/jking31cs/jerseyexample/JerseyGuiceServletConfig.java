package com.jking31cs.jerseyexample;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

/**
 * This handles creating a Guice Injector that includes all of our binding options and providers in any modules we wish
 * to consider.  In this case, we're adding the servlet module and the example module that binds our store objects.
 */
public class JerseyGuiceServletConfig extends GuiceServletContextListener {

    private static Injector injector;

    @Override
    protected Injector getInjector() {
        return injector;
    }

    public static Injector getOrCreateInjector() {

        if (injector == null) {
            injector = Guice.createInjector(
                new JerseyExampleServletModule(),
                new JerseyExampleGuiceModule()
            );
        }
        return injector;
    }
}
