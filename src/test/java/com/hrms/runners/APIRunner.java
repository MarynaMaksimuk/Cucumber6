package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/APIworkflow.feature", 
glue = "com/hrms/API/steps/practice",
dryRun = false, 
monochrome=true,
strict=true,
//tags="@workflow",
plugin = {
		"pretty", "json:target/jSon/cucumber.json" }
)

public class APIRunner {

}
