package testRunner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features="src/main/java/features/Launch.feature",
		glue= {"stepDefs", "utility"},
		plugin = {"pretty"},
		dryRun = false,
		strict = true,
		tags = {"@appium"},
		monochrome = true
		)
@Test
public class Runner extends AbstractTestNGCucumberTests {

}
