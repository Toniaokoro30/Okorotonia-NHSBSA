package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src\\main\\resources\\features\\SearchJobs.feature",       
    glue = "stepdefinitions",                       
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)
public class TestRunner {}


