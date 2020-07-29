package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;


public class AddEmployeePage extends BaseClass{
	@FindBy(id="firstName")
	public WebElement FirstName;
	
	@FindBy(id="lastName")
	public WebElement LastName;
	
	@FindBy (id="middleName")
	public WebElement middleName;
	
	@FindBy (xpath = "//input[@name='chkLogin']")
	public WebElement checkBoxLoginDetails;
	
	@FindBy (id="user_name")
	public WebElement userName;
	
	@FindBy (id="user_password")
	public WebElement password;
	
	@FindBy (id="re_password")
	public WebElement repassword;
	
	@FindBy (id="btnSave")
	public WebElement save;
	
	@FindBy(id="employeeId")
	public WebElement empID;	
	
	
	
	@FindBy (xpath = "//div[@id='profile-pic']/h1")
	public WebElement verifiedName;
	
	public AddEmployeePage() {
		PageFactory.initElements(driver, this);
	}
	
}
