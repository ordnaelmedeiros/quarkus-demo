package com.github.ordnaelmedeiros.quarkusdemo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreetingResource2Test {
	
	@Inject
	private GreetingService greetingService;
	
    @Test
    public void test01HelloEndpoint() {
        given()
          .when().get("/api/hello")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }
    
    
    @Test
    public void test02GreetingEndpoint() {
        String uuid = UUID.randomUUID().toString();
        given()
          .pathParam("name", uuid)
          .when().get("/api/hello/greeting/{name}")
          .then()
            .statusCode(200)
            .body(is("hello " + uuid));
    }
    

    @Test
    public void test03GreetingEndpoint() {
        
    	String newBase = "hello2";
    	
    	// if @ApplicationScoped in GreetingService
    	greetingService.changeBase(newBase);
    	
        String uuid = UUID.randomUUID().toString();
        given()
          .pathParam("name", uuid)
          .when().get("/api/hello/greeting/{name}")
          .then()
            .statusCode(200)
            .body(is(newBase + " " + uuid));
        
    }

}