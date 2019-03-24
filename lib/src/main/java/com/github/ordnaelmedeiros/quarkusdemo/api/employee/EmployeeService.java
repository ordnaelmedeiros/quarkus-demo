package com.github.ordnaelmedeiros.quarkusdemo.api.employee;

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

@Api("Employee")
@Path("/employee")
@DeclareRoles({"ADMIN", "EMPLOYEE"})
public class EmployeeService {
	
	@Inject
	EmployeeResource resource;
	
	@GET
	@Path("/{id}")
	@RolesAllowed({"EMPLOYEE", "ADMIN"})
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "read", authorizations=@Authorization(value = "oauth"))
	public Employee read(@PathParam("id") Long id) {
		return resource.read(id);
	}
	
	@POST
	@RolesAllowed("EMPLOYEE")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "create", authorizations=@Authorization(value = "oauth"))
	public Long create(Employee employee) {
		return resource.create(employee);
	}
	
	@PUT
	@Path("/{id}")
	@RolesAllowed("EMPLOYEE")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "update", authorizations=@Authorization(value = "oauth"))
	public void update(@PathParam("id") Long id, Employee employee) throws Exception {
		if (!id.equals(employee.getId())) {
			throw new Exception("Not the same Employee");
		}
		resource.update(employee);
	}
	
	@DELETE
	@Path("/{id}")
	@RolesAllowed("ADMIN")
	@ApiOperation(value = "delete", authorizations=@Authorization(value = "oauth"))
	public void delete(@PathParam("id") Long id) {
		resource.delete(id);
	}
			
}

