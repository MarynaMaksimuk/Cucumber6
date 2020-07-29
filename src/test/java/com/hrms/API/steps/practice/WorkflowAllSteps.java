package com.hrms.API.steps.practice;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers.*;

import com.hrmsAPI.utils.PayloadConstants;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WorkflowAllSteps {
	
	String baseURI=RestAssured.baseURI="http://18.232.148.34/syntaxapi/api";
	RequestSpecification request;
	Response response;
	
	@Given("a request is prepared to create an employee")
	public void a_request_is_prepared_to_create_an_employee() {
	     request = given().header("Content-Type", "application/json").header("Authorization", TokenGenerationSteps.token).body(PayloadConstants.createEmployee());
	     response = request.when().post("/createEmployee.php");
	     
	    
	}

	@When("a POST call is made to create an employee")
	public void a_POST_call_is_made_to_create_an_employee() {
	 
	}

	@Then("the status code for creating an employee is {int}")
	public void the_status_code_for_creating_an_employee_is(Integer int1) {
	   
	}

	@Then("the employee is created")
	public void the_employee_is_created() {
	    
	}

	@Then("the employee ID is stored as a global variable to be used for other calls")
	public void the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls() {
	    
	}

@Given("a requast is prepared to retrieve the created employee")
public void a_requast_is_prepared_to_retrieve_the_created_employee() {
   // given().header("Content-Type", "application/json").header("Authorization", TokenGenerationSteps.t )
}

@When("a GET call is made to retrieve the created employee")
public void a_GET_call_is_made_to_retrieve_the_created_employee() {
    
}

@Then("the status code for retrieving the created employee is {int}")
public void the_status_code_for_retrieving_the_created_employee_is(Integer int1) {
    
}

@Then("the retrieved employee ID matches the globaly stored employee ID")
public void the_retrieved_employee_ID_matches_the_globaly_stored_employee_ID() {
   
}

@Then("the retrieved data matches the data used to create an employee")
public void the_retrieved_data_matches_the_data_used_to_create_an_employee() {
    
}

}
