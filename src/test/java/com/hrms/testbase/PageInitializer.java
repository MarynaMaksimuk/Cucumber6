package com.hrms.testbase;

import com.hrms.pages.DashBoardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.viewEmployeeListPageElements;

public class PageInitializer extends BaseClass{
	
	public static LoginPageElements login;
	public static DashBoardPageElements dashboard;
	//public static sauseDemoLoginpage sauseDemoPage;
	public static viewEmployeeListPageElements viewEmp;
	
	
	public static void initialize() {
		login=new LoginPageElements();
		dashboard=new DashBoardPageElements();
		//sauseDemoPage=new sauseDemoLoginpage();
		viewEmp=new viewEmployeeListPageElements();
		
		
		
	}

}
