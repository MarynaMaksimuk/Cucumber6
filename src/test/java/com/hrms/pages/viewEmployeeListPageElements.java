package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.commonMethods;

public class viewEmployeeListPageElements {
	@FindBy (id ="empsearch_employee_name_empName")
	public WebElement empName;
	
	@FindBy (id="empsearch_id")
	public WebElement EmpID;
	
	@FindBy (id ="searchBtn")
	public WebElement searchButton;
	
	public viewEmployeeListPageElements(){
		PageFactory.initElements(commonMethods.driver, this);
}
}