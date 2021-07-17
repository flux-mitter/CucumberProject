package Runner;

import org.junit.runner.RunWith;
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*
 * import org.testng.annotations.BeforeClass;
 * 
 * 
 * //import io.cucumber.testng.AbstractTestNGCucumberTests; import
 * io.cucumber.testng.CucumberOptions; import
 * io.cucumber.testng.TestNGCucumberRunner;
 * 
 * @CucumberOptions(features = "src/test/resources/FeatureFiles/", glue = {
 * "StepDefinations" }, plugin = {
 * "pretty","html:target/cucumber-reports/cucumber-pretty",
 * "json:target/cucumber-reports/CucumberTestReport.json" }) public class
 * RunTestNGTest {
 * 
 * private TestNGCucumberRunner testNGCucumberRunner;
 * 
 * @BeforeClass(alwaysRun=true) public void SetUpClass() { testNGCucumberRunner
 * = new TestNGCucumberRunner(this.getClass()); }
 * 
 * }
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureFiles/test.feature", 
				glue = {"StepDefinitions" },	
				//plugin = { "pretty", "html:target/test-output", "json:json_output/cucumber.html", "junit:junit_xml/cucumber.xml"},
		
		/*
		 * plugin = { "pretty","html:target/cucumber-reports/cucumberReports.html",
		 * "json:target/cucumber-reports/CucumberTestReport.json",
		 * "html:target/Destination"},
		 */
		 
						//plugin = { "pretty", "html:target/cucumber-reports/run.html" },
						//plugin = { "pretty", "html:target/run.html" },
						plugin= {"html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml"},//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
						
				monochrome = true,
				strict = true,
				dryRun = false)

public class TestRunner {

}
