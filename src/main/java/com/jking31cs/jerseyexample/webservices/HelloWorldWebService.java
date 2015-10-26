package com.jking31cs.jerseyexample.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * This is a test webservice to make sure that I had everything set up correctly.
 */
@Path("api/hello-world")
@Produces("text/plain")
public class HelloWorldWebService {

    @GET
    public String hello() {
        return "Hello World.";
    }
}
