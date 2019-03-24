package com.github.ordnaelmedeiros.quarkusdemo.api.office;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Api("Office")
@Path("/office")
//@DeclareRoles({"ADMIN", "OFFICE"})
public class OfficeService {
	
	@Inject
	OfficeResource resource;
	
	@GET
	@RolesAllowed({"ADMIN", "OFFICE"})
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "all", authorizations=@Authorization(value = "oauth"))
	public List<Office> all(@QueryParam("search") String search) {
		return resource.all(search);
	}
	
	@GET
	@Path("/{id}")
	@RolesAllowed({"ADMIN", "OFFICE"})
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "read", authorizations=@Authorization(value = "oauth"))
	public Office read(@PathParam("id") Long id) {
		return resource.read(id);
	}
	
	@GET
	@Path("/no/{id}")
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	public Office readno(@PathParam("id") Long id) {
		return resource.read(id);
	}
	
	@POST
	@RolesAllowed({"ADMIN", "OFFICE"})
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "create", authorizations=@Authorization(value = "oauth"))
	public Long create(Office entity) {
		return resource.create(entity);
	}
	
	@PUT
	@Path("/{id}")
	@RolesAllowed({"ADMIN", "OFFICE"})
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "update", authorizations=@Authorization(value = "oauth"))
	public void update(@PathParam("id") Long id, Office entity) throws Exception {
		if (!id.equals(entity.getId())) {
			throw new Exception("Not the same Office");
		}
		resource.update(entity);
	}
	
	@DELETE
	@Path("/{id}")
	@RolesAllowed({"ADMIN", "OFFICE"})
	@ApiOperation(value = "delete", authorizations=@Authorization(value = "oauth"))
	public void delete(@PathParam("id") Long id) {
		resource.delete(id);
	}
			
}

