package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/dataBasePractice.feature", 
glue = "DatbasetestAutomation.java", dryRun = false, plugin = {
		"pretty", "json:target/jSon/cucumber.json" }, monochrome = true

)
public class dataBaseRuner {

}
