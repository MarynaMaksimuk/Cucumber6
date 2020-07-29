package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TokenGenerationSteps {
	/**
	 * token
	 */
	public static String token;
	/**
	 * BaseURL
	 */
	String baseURI=RestAssured.baseURI="http://18.232.148.34/syntaxapi/api";
	
	@Given("a JWT is generated")
	public void a_JWT_is_generated() {
		
	   RequestSpecification generateTokenRequest = given().header("Content-Type", "application/json").body("{\r\n" + 
	    		"  \"email\": \"test999@gmail.com\",\r\n" + 
	    		"  \"password\": \"test999\"\r\n" + 
	    		"}");
	   
	   Response generateTokenResponse = generateTokenRequest.when().post("/generateToken.php");
	 //  generateTokenResponse.prettyPrint();
	   /**
	    * Retrieving token from Response body and concatenating with "Bearer"
	    */
	   token = "Bearer "+ generateTokenResponse.jsonPath().getString("token");
	   /**
	    * optional to print token
	    */
	   System.out.println(token);
	}
}
