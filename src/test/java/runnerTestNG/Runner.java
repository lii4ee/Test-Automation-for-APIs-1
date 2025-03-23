package runnerTestNG;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "stepDefinition"
		)


public class Runner extends AbstractTestNGCucumberTests {

}
