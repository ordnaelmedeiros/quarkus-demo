package com.github.ordnaelmedeiros.restls.swagger;

import javax.ws.rs.Path;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;

@Path("/swagger.{type:json|yaml}")
public class SwaggerResource extends ApiListingResource {
	
	private static BeanConfig beanConfig;

	static {
		
		try {
			
			beanConfig = new BeanConfig();
			beanConfig.setBasePath("/api");
	        beanConfig.setResourcePackage("com.github.ordnaelmedeiros.restls");
	        beanConfig.setScan(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
