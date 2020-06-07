package com.hrms.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
	   System.out.println("Test started "+ result.getName());
	  }
	@Override
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test passed "+result.getName());
	  }
	 public void onTestFailure(ITestResult result) {
		    System.out.println("Testcase failed "+ result.getName());
		  }
}
