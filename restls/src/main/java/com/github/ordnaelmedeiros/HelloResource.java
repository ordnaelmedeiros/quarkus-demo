package com.github.ordnaelmedeiros;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	System.out.println("chamou hello");
        return "hello";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/teste2")
    public String hello2() {
    	System.out.println("chamou hello 2");
        return "hello 2\n";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/teste3")
    public String hello3() {
        return "hello 3";
    }
    
}