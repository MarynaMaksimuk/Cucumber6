package com.hrms.steps;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.hrms.utils.commonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class DashboardSteps extends commonMethods {
	@Then("user sees dashboard menu is displayed")
	public void user_sees_dashboard_menu_is_displayed(DataTable dashboardMenu) {
		List<String> expectedMenu= dashboardMenu.asList();
		List <String> actualMenu=new ArrayList<>();
		
		for (WebElement el:dashboard.dashList) {
			actualMenu.add(el.getText());
			Assert.assertTrue(actualMenu.equals(expectedMenu));
		}
		
	}
}
