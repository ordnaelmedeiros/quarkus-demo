package com.github.ordnaelmedeiros.quarkusdemo;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
@ApplicationPath("/api")
public class QuarkusDemo extends Application {

	private static final Logger LOGGER = LoggerFactory.getLogger("ListenerBean");

	void onStart(@Observes StartupEvent ev) {
		LOGGER.info("The application is starting...");
	}

	void onStop(@Observes ShutdownEvent ev) {
		LOGGER.info("The application is stopping...");
	}

}
