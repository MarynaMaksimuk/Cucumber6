package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class SingleRunner {

	@RunWith(Cucumber.class)
	@CucumberOptions (
	features = "src/test/resources/features/sauseDemologin.feature",
	glue = "src\\test\\java\\com\\hrms\\steps\\SauseDemoLoginSteps.java", // where we can find
																							// implementation code for
																							// gherkin steps?
			// we specify just package
			dryRun = true, // if set to true it will quickly scan that all gherkin steps have
							// implementation code
//dryRun=true, //if set to true it will quickly scan that all gherkin steps have implementation code
			// if set to true no actual execution will happen
			monochrome = true
			
			)
		//	strict = true
			//tags = "@smoke"

		/*	, plugin = { "pretty", // prints gherkin steps in console
					"html:target/cucumber-default-report", // create basic html report in specified location
					"json:target/cucumber.json" })
*/
	public class SmokeRunner {

	}
}
