package qa.com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "qa\\com\\feature",
		glue = "qa\\com\\stepsdefn",
		plugin = { "pretty" , "html:test-output"},
		monochrome = true,
		strict = true,
		tags="@ProductDetails"
		)

public class Runner {

}
