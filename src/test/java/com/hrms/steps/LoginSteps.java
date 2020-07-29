package com.hrms.steps;

import org.testng.Assert;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.commonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends commonMethods {
	@When("user entered valid admin username and valid password")
	public void user_entered_valid_admin_username_and_valid_password() {
	   sendText(LoginPageElements.username, "Admin");
	   sendText(LoginPageElements.password, "Hum@nhrm123");
	   
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	   click(LoginPageElements.loginBtn);
	}

	@Then("admin user successfully logged in")
	public void admin_user_successfully_logged_in() {
	  String expected = "Welcome Admin";
	  String actual = dashboard.welcome.getText();
	  Assert.assertEquals(actual, expected);
	}

	@When("user entered valid ess username and valid password")
	public void user_entered_valid_ess_username_and_valid_password() {
	   sendText(LoginPageElements.username, "Elvira");
	   sendText(LoginPageElements.password, "Syntax123.");
	}

	@Then("ess user successfully logged in")
	public void ess_user_successfully_logged_in() {
	     String expected ="Welcome Elvira";
	     String actual=dashboard.welcome.getText();
	     Assert.assertEquals(actual, expected);
	}

	@When("user entered valid username and invalid password")
	public void user_entered_valid_username_and_invalid_password() {
	    sendText(LoginPageElements.username, ConfigsReader.getPropery("username"));
	    sendText(LoginPageElements.password,"test123");
	}

	@Then("user sees Invalid Credentials message")
	public void user_sees_Invalid_Credentials_message() {
	    String expected="Invalid credentials";
	    String actual=dashboard.loginErrorMessage.getText();
	    Assert.assertEquals(actual, expected);
	}

}
