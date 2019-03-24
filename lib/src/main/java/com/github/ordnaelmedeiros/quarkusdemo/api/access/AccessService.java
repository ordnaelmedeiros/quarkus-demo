package com.github.ordnaelmedeiros.quarkusdemo.api.access;

import javax.annotation.security.DeclareRoles;
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
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Api("Access")
@Path("/access")
@DeclareRoles({"ADMIN"})
@RolesAllowed("ADMIN")
public class AccessService {
	
	@Inject
	AccessResource accessResource;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@ApiOperation(value = "read", authorizations=@Authorization(value = "oauth"))
	public Access read(@PathParam("id") Long id) {
		return accessResource.read(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "create", authorizations=@Authorization(value = "oauth"))
	public Long create(Access employee) {
		return accessResource.create(employee);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	@ApiOperation(value = "update", authorizations=@Authorization(value = "oauth"))
	public void update(@PathParam("id") Long id, Access employee) throws Exception {
		if (!id.equals(employee.getId())) {
			throw new Exception("Not the same Access");
		}
		accessResource.update(employee);
	}
	
	@DELETE
	@Path("/{id}")
	@ApiOperation(value = "delete", authorizations=@Authorization(value = "oauth"))
	public void delete(@PathParam("id") Long id) {
		accessResource.delete(id);
	}
			
}

