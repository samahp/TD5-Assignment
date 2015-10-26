package com.jking31cs.jerseyexample;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFilter;
// import com.jking31cs.jerseyexample.stores.TodoListStore;
import com.jking31cs.jerseyexample.stores.UserStore;

import javax.inject.Singleton;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * This Guice Module handles binding our TodoListStore, meaning that when we inject the TodoListStore into another
 * service (like our WebService), it knows where and how to create/get that object.
 *
 * We also bind the ObjectifyFilter here out of necessity.  The app will throw 500 errors if we do not.
 */
public class JerseyExampleGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserStore.class);
        // bind(TodoListStore.class);
        bind(ObjectifyFilter.class).in(Singleton.class);
    }

    /**
     * Providing the Objectify object via a Provider to ensure transaction management.
     */
    @Provides
    @Singleton
    Objectify provideObjectify() {
        return ofy();
    }
}
