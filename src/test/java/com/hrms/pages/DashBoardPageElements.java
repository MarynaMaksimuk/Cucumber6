package com.hrms.pages;

import java.util.List;

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
	
	@FindBy (id="spanMessage")
	public WebElement loginErrorMessage;
	
	@FindBy (xpath = "//div[@class='menu']/ul/li")
	public List<WebElement> dashList;
	
	public DashBoardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
	// public void navigateToAddEmployee() { // can i include actions here?
//	      click(pim);
//	      click(addEmployee);
	        //OR
//	        jsClick(PIM);
//	        jsClick(addEmployee);
//	        // try if u can do actions hover bluh bluh
	        // if click() is not working then use jsClick(
	



