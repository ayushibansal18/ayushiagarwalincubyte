package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/java/cucumber",glue= "stepDefinition",plugin = {"pretty",                      // To make console output readable
        "html:target/cucumber-reports",
        "json:target/cucumber.json"},
        monochrome = true   )

public class TestRunner extends AbstractTestNGCucumberTests {

}
