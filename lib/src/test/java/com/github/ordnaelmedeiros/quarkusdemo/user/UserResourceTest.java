package com.github.ordnaelmedeiros.quarkusdemo.user;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UserResourceTest {

	private final String URL_BASE = "/api/user";
	
    @Test
    public void test010Hello() {
        given()
          .when().get(URL_BASE+"/hello")
          .then()
             .statusCode(200)
             .body(equalTo("hello"));
        
    }
    
    @Test
    public void testCRUD() {
    	
    	given().when()
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.get(URL_BASE+"/1")
			.then()
				.statusCode(204);
    	
    	given().when()
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.body("{\"acessname\":\"leandro\", \"password\":\"123\"}")
    		.post(URL_BASE)
    			.then()
    			.statusCode(200)
    			.body(equalTo("1"));
        	
    	given().when()
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.get(URL_BASE+"/1")
			.then()
				.statusCode(200)
				.body("id", equalTo(1))
				.body("acessname", equalTo("leandro"))
				.body("password", equalTo("123"));
    	
    	given().when()
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.body("{\"id\":\"1\", \"acessname\":\"leandro\", \"password\":\"123456\"}")
    		.put(URL_BASE+"/1")
    			.then()
    			.statusCode(204);
    	
    	given().when()
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.get(URL_BASE+"/1")
			.then()
				.statusCode(200)
				.body("id", equalTo(1))
				.body("acessname", equalTo("leandro"))
				.body("password", equalTo("123456"));
    	
    	given().when()
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.delete(URL_BASE+"/1")
				.then()
				.statusCode(204);
    	
    	given().when()
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.get(URL_BASE+"/1")
			.then()
				.statusCode(204);
    	
    }
	
    
    
}
