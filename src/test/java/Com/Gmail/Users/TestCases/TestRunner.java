package Com.Gmail.Users.TestCases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = ".\\src\\test\\java\\Com\\Gmail\\Users\\Features\\TourLogin.feature", glue = {
		"Com.Gmail.Users.StepDef",
		"Com.Gmail.Users.hooks" }, tags = "@TC4", plugin = { "pretty", "html:Reports/cucumber-reports.html" })
public class TestRunner extends AbstractTestNGCucumberTests {
}