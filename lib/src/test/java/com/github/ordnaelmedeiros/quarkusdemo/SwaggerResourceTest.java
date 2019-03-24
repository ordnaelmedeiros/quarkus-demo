package com.github.ordnaelmedeiros.quarkusdemo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

@QuarkusTest
public class SwaggerResourceTest {

	@Test
	public void testHelloEndpoint() {

		Response response = given().when().get("/api/swagger.json");
		
		response.then()
			.statusCode(200)
			.body(containsString("swagger"))
			.body(containsString("/user/hello"))
			.body(containsString("A simple example here"))
			;
		
		//String conteudo = response.asString();
		// System.out.println(conteudo);
		
	}

}