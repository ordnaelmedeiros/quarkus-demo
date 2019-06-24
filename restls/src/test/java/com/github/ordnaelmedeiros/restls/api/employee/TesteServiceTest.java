package com.github.ordnaelmedeiros.restls.api.employee;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TesteServiceTest {

	@Test
	public void testHelloEndpoint() {
		/*
		given()
			.when()
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON)
			.pathParam("name", "leandro")
			.post("/api/test/{name}")
			.then()
				.statusCode(200)
				.body(is("1"));
		*/
	}

}
