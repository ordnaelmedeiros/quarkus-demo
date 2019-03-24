package com.github.ordnaelmedeiros.quarkusdemo.swagger;

import javax.ws.rs.Path;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;

@Path("/swagger.{type:json|yaml}")
public class SwaggerResource extends ApiListingResource {

	static {
		
		try {
			
			BeanConfig beanConfig = new BeanConfig();
	        beanConfig.setResourcePackage("com.github.ordnaelmedeiros.quarkusdemo");
	        beanConfig.setScan(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
