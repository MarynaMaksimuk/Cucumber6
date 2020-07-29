package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.*;
import org.junit.runners.MethodSorters;

public class test {
	
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjk1ODksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMjc4OSwidXNlcklkIjoiNjQ1In0.olnen9JKR7vCee9mjbm8VGFArcStRExfxDuTlR3iN0g";
	static String employeeID;

	@Test
	public void POSTCreatedEmployee() {
		RequestSpecification createEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token)
				.body("{\r\n" + 
						"  \"emp_firstname\": \"Michael\",\r\n" + 
						"  \"emp_lastname\": \"O'Neil\",\r\n" + 
						"  \"emp_middle_name\": \"F\",\r\n" + 
						"  \"emp_gender\": \"M\",\r\n" + 
						"  \"emp_birthday\": \"1980-07-11\",\r\n" + 
						"  \"emp_status\": \"Employee\",\r\n" + 
						"  \"emp_job_title\": \"IT Analyst\"\r\n" + 
						"}"); // .log().all();
		/**
		 * Storing response into createEmployeeResponse
		 */
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
		/**
		 * Printing response using prettyPrint() method
		 */
		String response = createEmployeeResponse.prettyPrint();
		String employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		System.out.println(employeeID);
		
		//createEmployeeResponse.then().assertThat().statusCode(201);

		JsonPath js = new JsonPath(response);
		String empID = js.getString("employee[0].employee_id");
		String firstName = js.getString("employee[1].emp_firstname");
		String middleName = js.getString("employee[2].emp_middle_name");
		String lastName = js.getString("employee[3].emp_lastname");
		String birthday = js.getString("employee[4].emp_birthday");
		String gender = js.getString("employee[5].emp_gender");
		System.out.println(empID);
		System.out.println(firstName);
		System.out.println(middleName);
		System.out.println(lastName);
		System.out.println(birthday);
		System.out.println(gender);

		assertTrue(empID.equals(employeeID));
	}

}
