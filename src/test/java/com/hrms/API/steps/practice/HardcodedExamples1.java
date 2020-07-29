package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.matcher.RestAssuredMatchers.*;

import org.junit.Assert;
import org.junit.Test;

import com.hrmsAPI.utils.PayloadConstants;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HardcodedExamples1 {
	/**
	 * Rest Assured
	 *
	 * given - prepare your request when - you are making the call to the endpoint
	 * then - validating
	 *
	 * @param args
	 */
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU2OTA1MjksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTczMzcyOSwidXNlcklkIjoiNjY4In0.G1r5dz_RNw9R0kTk-r-13yz_Hr8f2goNbB1i75nlhfw";
	public static String employeeID;

	public void sampleTestNotes() {
		/**
		 * BaseURI for all calls
		 */
		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
		/**
		 * JWT required for all calls - expires every 12 hours
		 */
		//String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU2OTA1MjksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTczMzcyOSwidXNlcklkIjoiNjY4In0.G1r5dz_RNw9R0kTk-r-13yz_Hr8f2goNbB1i75nlhfw";
		/**
		 * Preparing /getOneEmployee.php request
		 */
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "16490A"); // .log().all();
		/**
		 * Storing response
		 */
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
		/**
		 * Two ways to print response prettyPrint() method converts JSON object into
		 * String and prints - no need to SOP
		 */
		getOneEmployeeResponse.prettyPrint();
		// String response = getOneEmployeeResponse.body().asString();
		// System.out.println(response);
		/**
		 * Verifying response status code is 200
		 */
		getOneEmployeeResponse.then().assertThat().statusCode(200);
	}

	@Test
	public void aPOSTcreateEmployee() {
		/**
		 * Preparing request for /createEmployee.php
		 */
		RequestSpecification createEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token)
				.body("{\r\n" + "  \"emp_firstname\": \"Michael\",\r\n" + "  \"emp_lastname\": \"O'Neil\",\r\n"
						+ "  \"emp_middle_name\": \"F\",\r\n" + "  \"emp_gender\": \"M\",\r\n"
						+ "  \"emp_birthday\": \"1980-07-11\",\r\n" + "  \"emp_status\": \"Employee\",\r\n"
						+ "  \"emp_job_title\": \"IT Analyst\"\r\n" + "}"); // .log().all();
		/**
		 * Storing response into createEmployeeResponse
		 */
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
		/**
		 * Printing response using prettyPrint() method
		 */
		createEmployeeResponse.prettyPrint();
		/**
		 * jsonPath() to view response body which lets us get the employee ID We store
		 * employee ID as a global variable so that we may we use it with our other
		 * calls
		 *
		 */
		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		/** optional to print employee ID */
		System.out.println(employeeID);
		/**
		 * Verifying response status code is 201
		 */
		createEmployeeResponse.then().assertThat().statusCode(201);
		/**
		 * Verifying message using equalTo() method - manually import static package
		 * import static org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
		/**
		 * Verifying created first name
		 */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Michael"));
		/**
		 * Verifying server using then().header()
		 */
		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
		/**
		 * Verifying Content-Type using assertThat().header()
		 */
		createEmployeeResponse.then().assertThat().header("Content-Type", "application/json");
	}

	@Test
	public void bGETcreatedEmployee() {
		/**
		 * Preparing request for /getOneEmployee.php Using log().all() to see all
		 * information being sent with request
		 */
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();
		/**
		 * Making call to retrieve created employee
		 */
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
		/**
		 * Printing response using prettyPrint()
		 */
		String response = getCreatedEmployeeResponse.prettyPrint();
		/**
		 * Storing response employeeID into empID which will be used for verification
		 * against stored global employee ID
		 */
		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		/**
		 * matching exact employeeID’s
		 */
		boolean verifyingEmpoyeeIDsMatch = empID.contentEquals(employeeID);
		System.out.println("Employee ID’s match: " + verifyingEmpoyeeIDsMatch);
		/**
		 * Asserting employee ID’s match
		 */
		Assert.assertTrue(verifyingEmpoyeeIDsMatch);

		/**
		 * Verifying status code is 200
		 */
		getCreatedEmployeeResponse.then().assertThat().statusCode(200);

		JsonPath js = new JsonPath(response);
		String EmpID = js.getString("employee[0].employee_id");
		String firstName = js.getString("employee[0].emp_firstname");
		String middleName = js.getString("employee[0].emp_middle_name");
		String lastName = js.getString("employee[0].emp_lastname");
		String birthday = js.getString("employee[0].emp_birthday");
		String gender = js.getString("employee[0].emp_gender");
		System.out.println(EmpID);
		System.out.println(firstName);
		System.out.println(middleName);
		System.out.println(lastName);
		System.out.println(birthday);
		System.out.println(gender);

		Assert.assertTrue(empID.equals(employeeID));
		Assert.assertTrue(firstName.contentEquals("Michael"));
		Assert.assertTrue(middleName.contentEquals("F"));
		Assert.assertTrue(lastName.contentEquals("O'Neil"));
		Assert.assertTrue(birthday.contentEquals("1980-07-11"));
		Assert.assertTrue(gender.contentEquals("Male"));

	}

	@Test
	public void GETallEmployees() {

		RequestSpecification GetAllEmployeesRequast = given().header("Content-Type", "application/json")
				.header("Authorization", token).log().all();

		Response GetAllEmployeesResponse = GetAllEmployeesRequast.when().get("/getAllEmployees.php");
		String AllEmployees = GetAllEmployeesResponse.prettyPrint();
		JsonPath js = new JsonPath(AllEmployees);
		int listSize = js.getInt("Employees.size()");
		System.out.println(listSize);

//		 for(int i=0;i<listSize;i++) {
//			 String AllEmployeeIDs = js.getString("Employees["+ i +"].employee_id");
//			 System.out.println(AllEmployeeIDs);
//			 
//		 }
	}
	@Test
	public void PUTupdateCreatedEmployee() {
		
		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body(PayloadConstants.updateCreatedEmployee());
		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/updateEmployee.php");
		updateCreatedEmployeeResponse.prettyPrint();
		 updateCreatedEmployeeResponse.then().assertThat().body("employee[0].emp_firstname", equalTo("Mike"));
		 updateCreatedEmployeeResponse.then().assertThat().statusCode(200);
	}
}