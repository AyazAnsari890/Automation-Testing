package TestRunnerr;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "C:\\Users\\Dell\\eclipse-workspace\\AutomationfaceCucumber\\src\\main\\java\\Feature\\SignUp.feature", //the path of the feature files
			glue = {"StepDefinition"}, //the path of the step definition files
			//format= {"pretty", "html:test-output"},
			dryRun = true
			)
	public class TestRunner {

	}
