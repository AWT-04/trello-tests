package org.fundacionjala.trello.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.fundacionjala"}
)

public class Runner extends AbstractTestNGCucumberTests {
    @BeforeTest
    public void beforeAllScenaries() {
        //Do something
    }
}
