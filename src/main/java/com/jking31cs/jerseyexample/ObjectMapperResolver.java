package com.jking31cs.jerseyexample;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

/**
 * This handles resolving which object mapper to use when converting a request body to a Java Bean Object and
 * vice versa.  We can also register a variety of different Jackson Modules which contain the different
 * serializers/deserializers for special objects.  For this example, we include the GuavaModule to help us bind
 * objects that come from Google's Guava library.  All basic java objects convert fine, as long as there are
 * getters/setters for each variable and an empty contructor to construct with.
 */
@Provider
public class ObjectMapperResolver implements ContextResolver<ObjectMapper> {
    private final ObjectMapper objectMapper;

    public ObjectMapperResolver() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new GuavaModule());
    }


    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
}
