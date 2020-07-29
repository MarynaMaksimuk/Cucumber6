package com.hrms.steps;

import com.hrms.pages.DashBoardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.testbase.PageInitializer;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.commonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchEmployeeSteps extends commonMethods{
	

	@Given("user logged in with valid login credentials")
	public void user_logged_in_with_valid_login_credentials() {
	    
	    LoginPageElements.login(ConfigsReader.getPropery("username"),ConfigsReader.getPropery("password"));
	}

	@Given("user navigated to Employee List")
	public void user_navigated_to_Employee_List() {
	 commonMethods.jsClick(PageInitializer.dashboard.PIM);
	}

	@When("user enteres valid employee id")
	public void user_enteres_valid_employee_id() {
		PageInitializer.viewEmp.EmpID.sendKeys("10079");
		
	}

	@When("clicks Search button")
	public void clicks_Search_button() {
		PageInitializer.viewEmp.searchButton.click();
		
	    
	}

	@Then("user see employee information is displayed")
	public void user_see_employee_information_is_displayed() {
	   System.out.println("employee is displayed");
	    
	}

	@When("user enteres valid employee name nad last name")
	public void user_enteres_valid_employee_name_nad_last_name() {
	    
	 
	}
	@When("user should be able to modify employee personal details")
	public void user_should_be_able_to_modify_employee_personal_details() {
	    jsClick(dashboard.PIM);
	    click(dashboard.EmployeeList);
	    
	}

}
