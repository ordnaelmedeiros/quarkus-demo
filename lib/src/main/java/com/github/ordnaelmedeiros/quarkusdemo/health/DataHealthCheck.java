package com.github.ordnaelmedeiros.quarkusdemo.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Health
@ApplicationScoped
public class DataHealthCheck implements HealthCheck {

	@Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("Health check with data")
                .up()
                .withData("foo", "fooValue")
                .withData("bar", "barValue")
                .build();
    }
	
}
