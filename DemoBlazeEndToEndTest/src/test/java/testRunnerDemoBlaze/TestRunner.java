package testRunnerDemoBlaze;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features={".//Features/Orders.feature"},
		glue={"stepDefinitions"},
		dryRun=false,
		monochrome=true,
		plugin= {"pretty", "html:target/cucumber"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
