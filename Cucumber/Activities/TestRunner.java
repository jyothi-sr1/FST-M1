package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "features",
    glue = {"stepDefinitions"},
    /*tags = "@activity1",*/
    plugin = {
            "pretty",  // Pretty output on the console
            "html:target/cucumber-reports/cucumber.html",  // HTML Report
            "junit:target/cucumber-reports/cucumber.xml",  // JUnit Report
            "usage:target/cucumber-reports/cucumber-usage.json"  // Usage Report in JSON format
        },
        monochrome = true,  // Makes the console output more readable
        dryRun = false  // Set to true to validate step definitions without running tests
    )

public class TestRunner {
    //empty
}