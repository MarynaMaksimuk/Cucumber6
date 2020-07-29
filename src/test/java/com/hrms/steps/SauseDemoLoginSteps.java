package com.hrms.steps;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauseDemoLoginSteps {
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	 BaseClass.driver.get(ConfigsReader.getPropery("url"));
	}

	@When("user enter invalid username")
	public void user_enter_invalid_username() {
	    
	}

	@When("user enter invalid password")
	public void user_enter_invalid_password() {
	  
	}

	@When("click on login button")
	public void click_on_login_button() {
	  
	}

	@Then("user should see the error message")
	public void user_should_see_the_error_message() {
	    
	}
	
	@When("user enter invalid username as {string}")
	public void user_enter_invalid_username_as(String userName) {
	  System.out.println(userName);
	}

	@When("user enter invalid password as {string}")
	public void user_enter_invalid_password_as(String password) {
	   System.out.println(password); 
	}

}
