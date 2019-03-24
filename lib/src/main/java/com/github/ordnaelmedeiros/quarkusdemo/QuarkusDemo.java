package com.github.ordnaelmedeiros.quarkusdemo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@ApplicationScoped
@ApplicationPath("/api")

@SwaggerDefinition(
		info = @Info (
	        title = "Example Service",
	        description = "A simple example here",
	        version = "1.0.0",
	        contact = @Contact (
	            name = "Leandro Medeiros",
	            email = "lll@gmail.com",
	            url = "www.google.com"
	        )
	    ),
	    host = "localhost",
	    basePath = "/api",
	    schemes = {SwaggerDefinition.Scheme.HTTP}
		
		/*,
	    securityDefinition=@SecurityDefinition(
	    		
	    		basicAuthDefinitions=@BasicAuthDefinition(
	    			key="basic",
	    			description="Autenticacao"
				)
				
	    		oAuth2Definitions=@OAuth2Definition(
	    				authorizationUrl="/api/oauth/login",
	    				tokenUrl="/api/oauth/login",
	    				flow = OAuth2Definition.Flow.PASSWORD,
	    				key = "oauth",
	    				description="Obs.: type: 'Query parameters'"
				)
				
		)
		*/
)

public class QuarkusDemo extends Application {

	private static final Logger LOGGER = LoggerFactory.getLogger("ListenerBean");
	
	void onStart(@Observes StartupEvent ev) {
		LOGGER.info("The application is starting...");
	}

	void onStop(@Observes ShutdownEvent ev) {
		LOGGER.info("The application is stopping...");
	}
	
}
