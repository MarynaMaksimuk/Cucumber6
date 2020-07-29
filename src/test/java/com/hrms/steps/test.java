package com.hrms.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrms.utils.commonMethods;

public class test extends commonMethods {
	public static void main(String[] args) {
		
	
	List <WebElement> list=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
	for (WebElement x:list) {
		x.getText();
	System.out.println(x);
}}
}