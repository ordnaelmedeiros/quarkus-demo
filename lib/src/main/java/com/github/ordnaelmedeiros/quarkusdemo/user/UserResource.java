package com.github.ordnaelmedeiros.quarkusdemo.user;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

	@Inject
	UserService userService;
	
	@GET
	@Path("/hello")
	public String hello() {
		return "hello";
	}
	
	@GET
	@Path("/{id}")
	public User get(@PathParam("id") Long id) {
		return userService.get(id);
	}
	
	@POST
	public Long post(User user) {
		return userService.post(user);
	}
	
	@PUT
	@Path("/{id}")
	public void put(User user) {
		userService.put(user);
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) {
		userService.delete(id);
	}
	
}
