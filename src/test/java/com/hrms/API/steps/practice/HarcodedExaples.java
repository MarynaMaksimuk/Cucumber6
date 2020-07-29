package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.junit.Test;


public class HarcodedExaples {

	/*
	 * Rest Assured
	 * 
	 * given - prepare your request when - making call to end point then -
	 * validating
	 */
	
	static String BaseURI = RestAssured.baseURI = "18.232.148.34/syntaxapi/api";
	static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjk1NjEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMjc2MSwidXNlcklkIjoiNjY4In0.0s5HpySafxpLENWt5x8G62AUkB0TzgtB2nF-YOgd1Yo";
	static String employeeID;

	
	public void sampleTest() {

		RequestSpecification GetOneEmployeeRequest = given().header("Content-Type", "application/json").header("Authorization", token).queryParam("employee_id","15390A");
		
		
		Response getOneEmployeeResponse = GetOneEmployeeRequest.when().get("/getOneEmployee.php");
		/**
		 * 2 ways  to print response
		 */
		getOneEmployeeResponse.prettyPrint();
		// String response = GetOneEmployeeRespose.body().asString();
		
		getOneEmployeeResponse.then().assertThat().statusCode(200);
		
	}

	@Test
	public void POSTCreatedEmployee() {
		BaseURI = RestAssured.baseURI = "18.232.148.34/syntaxapi/api";
		RequestSpecification createEployeeRequest = given().header("Content-Type", "application/json").header("Authorization", token).body("{\r\n" + 
				"  \"emp_firstname\": \"Michael\",\r\n" + 
				"  \"emp_lastname\": \"O'Neil\",\r\n" + 
				"  \"emp_middle_name\": \"F\",\r\n" + 
				"  \"emp_gender\": \"M\",\r\n" + 
				"  \"emp_birthday\": \"1980-07-11\",\r\n" + 
				"  \"emp_status\": \"Employee\",\r\n" + 
				"  \"emp_job_title\": \"IT Analyst\"\r\n" + 
				"}");
		
		Response response = createEployeeRequest.when().get("/createEmployee.php");
		
		employeeID = response.jsonPath().getString("Emloyee[0].employee_id");
		System.out.println(employeeID);
		
		
		
		
		response.prettyPrint();
	}
	
	}
