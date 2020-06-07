package com.hrms.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;


public class DashBoardPageElements {

	@FindBy(id="welcome")
	public WebElement welcome;
	
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']/b")
	public WebElement PIM;
	
	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
	public WebElement addEmployee;
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement EmployeeList;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	public WebElement empListPage;

	public DashBoardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}


