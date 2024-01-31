package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features = {"src/test/resources/Features" },
        glue = {"stepdefinitions"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
