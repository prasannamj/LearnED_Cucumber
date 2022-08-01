package testRunner;

import org.junit.runner.RunWith;
//import cucumber.api.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
		(
		features=".//Features/login.feature",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
				"junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports.html"}
//		tags = "sanity"
		)
public class TestRun {

}
