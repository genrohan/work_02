package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\feature",
		glue = "stepdefn",
		plugin = { "pretty" , "html:test-output"},
		monochrome = true,
		strict = true
		)

public class Runner {

}
