package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;


	public class personalDetailsPageElements extends BaseClass{
		
		@FindBy(id="personal_cmbNation")
		WebElement nationality;
		
		@FindBy(name="personal[optGender]")
		public List<WebElement> GenderRadioGroup;
		
		@FindBy(xpath = "//div[@id='pdMainContainer']/div[1]/h1")
		public WebElement lblPersonalDetails;
		
		public personalDetailsPageElements() {
			PageFactory.initElements(BaseClass.driver, this);
		}

	}


