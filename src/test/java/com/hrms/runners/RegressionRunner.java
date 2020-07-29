package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(
	features="src\\test\\resources\\features\\AddEmployee.feature",
	glue="com/hrms/steps",
	dryRun=false,
	
	monochrome=true, 
   tags= "@regression",
	strict=true
     ,plugin= {
		   "pretty",// it prints gherkin steps in console
		   "html:target/cucmberDefaultReports" //creates basic html report in specified location
		   
 }
	
	
)
public class RegressionRunner {
	 
}
