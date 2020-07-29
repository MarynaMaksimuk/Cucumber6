package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.hrms.utils.commonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddEmployeeSteps extends commonMethods {
	@Then("user navigates to Add Employee Page")
	public void user_navigates_to_Add_Employee_Page() {
	    click(dashboard.PIM);
	    click(dashboard.addEmployee);
	    	    
	}

	@When("user enters employee {string} {string}")
	public void user_enters_employee(String firstName, String LastName) {
	    sendText(addEmp.FirstName, firstName);
	    sendText(addEmp.LastName, LastName);
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
	    click(addEmp.save);
	}

	@Then("employee successfully added")
	public void employee_successfully_added() {
	    String expected= "Jorge Cohen";
	    String actual=addEmp.verifiedName.getText();
	    Assert.assertEquals(actual, expected);
	}
	@Then("employee successfully added empl without ID")
	public void employee_successfully_added_empl_without_ID() {
	    String expected= "John Smith";
	    String actual=addEmp.verifiedName.getText();
	    Assert.assertEquals(actual, expected);
	}

	@When("user enters employee first and last name")
	public void user_enters_employee_first_and_last_name() {
	    sendText(addEmp.FirstName, "Jorge");
	    sendText(addEmp.LastName, "Cohen");
	}

	@When("user delets id number")
	public void user_delets_id_number() {
	    addEmp.empID.clear();
	}
	



	@When("user enters employee {string}, {string} and {string}")
	public void user_enters_employee_and(String fName, String mName, String lName) {
	    sendText(addEmp.FirstName, fName);
	    sendText(addEmp.middleName, mName);
	    sendText(addEmp.LastName, lName);
	}

	@Then("{string}, {string} and {string} successfully added")
	public void and_successfully_added(String fName, String mName, String lName) {
	    String expected= fName+" "+mName+" "+lName;
	    String actual=addEmp.verifiedName.getText();
	    Assert.assertEquals(actual, expected);
	}
	
	@When("user clicks on create login checkbox")
	public void user_clicks_on_create_login_checkbox() {
	    click(addEmp.checkBoxLoginDetails);
	}

	@When("user enters  login credentials")
	public void user_enters_login_credentials() {
	   sendText(addEmp.userName, "Test123987");
	   sendText(addEmp.password, "plmIJB123*&^rty");
	   sendText(addEmp.repassword, "plmIJB123*&^rty");
	}

	@Then("employee is added successfully")
	public void employee_is_added_successfully() {
	    String expected="John Smith";
	    
	    String actual= addEmp.verifiedName.getText();
	    Assert.assertEquals(actual, expected);
	}
	@When ("user enters employee details and click on save then employee is added")
	public void user_enters_employee_details_and_click_on_save_then_employee_is_added(DataTable dataTable) {
		List<Map<String, String>>addEmplList =dataTable.asMaps();
		for (Map<String, String> map:addEmplList) {
		String fname=map.get("FirstName");
		String mName=map.get("MiddleName");
		String lName=map.get("LastName");
		
		sendText(addEmp.FirstName, fname);
		sendText(addEmp.LastName, lName);
		sendText(addEmp.middleName, mName);
		
		click(addEmp.save);
		
		String expected=fname+" "+mName+" "+lName;
		String actual=addEmp.verifiedName.getText();
		Assert.assertEquals(actual, expected);
		 
		jsClick(dashboard.addEmployee);
		wait(5);
		}
	}

	@When("user enters data from Sheet1 excel then employee is added")
	public void user_enters_data_from_Sheet1_excel_then_employee_is_added() {
	    


}
	
}
