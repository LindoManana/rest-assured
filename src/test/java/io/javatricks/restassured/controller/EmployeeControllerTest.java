package io.javatricks.restassured.controller;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.javatricks.restassured.entities.Employee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@TestMethodOrder(OrderAnnotation.class)
class EmployeeControllerTest {
	
	@BeforeEach
	void init() {
		System.out.println("@BeforeEach - executes before each test case is ran...");

		//readExcelFile = new ReadExcelFile();
	}

	@Test
	@Order(1)
	void testCreateEmployee() {
		Employee emp = new Employee();
		emp.setFirstName("Elon");
		emp.setLastName("Musk");
		emp.setEmail("elon@tesla.com");
		emp.setPhoneNo("2793920928");
		emp.setLocation("South Africa");
		
		RestAssured.baseURI="http://localhost:8080";
		RestAssured
				   .given()
			       .contentType(ContentType.JSON)
			       .body(emp)
			       .when()
			       .post("/employees")
			       .then()
			       .statusCode(201);
	}

	@Test
	@Order(2)
	void testGetAllEmployees() {
		RestAssured.baseURI="http://localhost:8080";
		RestAssured
		   			.given()
		   			.get("/employees")
		   			.then()
		   			.statusCode(200);
	}

	@Test
	@Order(3)
	void testGetEmployeeById() {
		RestAssured.baseURI="http://localhost:8080";
		RestAssured
					.given()
					.pathParam("id", "1")
					.get("/employees/{id}")
					.then()
			        .contentType(ContentType.JSON)
			        .assertThat().body("firstName", equalTo("Elon"));
	}

	@Test
	@Order(4)
	void testUpdateEmployee() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setLocation("USA");
		
		RestAssured.baseURI="http://localhost:8080";
		RestAssured
					.given()
					.contentType(ContentType.JSON)
				    .body(emp)
					.put("/employees")
					.then()
			        .contentType(ContentType.JSON)
			        .assertThat().body("location", equalTo("USA"));
	}

	@Test
	@Order(5)
	void testDeleteEmployee() {
		RestAssured.baseURI="http://localhost:8080";
		RestAssured
					.given()
					.pathParam("id", "1")
					.delete("/employees/{id}")
					.then()
					.statusCode(200);
	}

}
