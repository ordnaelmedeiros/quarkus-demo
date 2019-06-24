package com.github.ordnaelmedeiros.restls.api.employee;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;

@Api("Teste")
@Path("/test")
public class TesteService {
	
	@HeaderParam("banco")
	public String bancoDeDados;
	
	@Inject
	TesteResource resource;
	
	
	@POST
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Long post(@PathParam("name") String name) {
		return resource.create(bancoDeDados, name);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Teste get(@PathParam("id") Long id) {
		return resource.read(bancoDeDados, id);
	}
	
	@GET
	@Path("/todos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Teste> get() {
		return resource.all(bancoDeDados);
	}
	
}

