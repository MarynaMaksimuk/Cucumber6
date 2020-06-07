package com.hrms.pages;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.commonMethods;


	public class LoginPageElements extends commonMethods {

		@FindBy(id="txtUsername")
		public static WebElement username;

		@FindBy(name="txtPassword")
		public static WebElement password;

		@FindBy(css="input#btnLogin")
		public static WebElement loginBtn;

		@FindBy(xpath="//div[@id='divLogo']/img")
		public WebElement logo;

		public LoginPageElements() {
			PageFactory.initElements(BaseClass.driver, this);
		}
		public static void login(String uid, String pwd) {
			sendText(password, pwd);
			sendText(username, uid);
			click(loginBtn);
		}
	}


