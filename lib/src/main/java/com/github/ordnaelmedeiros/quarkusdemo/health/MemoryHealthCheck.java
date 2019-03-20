package com.github.ordnaelmedeiros.quarkusdemo.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Health
@ApplicationScoped
public class MemoryHealthCheck implements HealthCheck {

	@Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("Health check with Memory")
                .up()
                .withData("total", Runtime.getRuntime().totalMemory()/1024/1024)
                .withData("free", Runtime.getRuntime().freeMemory()/1024/1024)
                .build();
    }
	
}
