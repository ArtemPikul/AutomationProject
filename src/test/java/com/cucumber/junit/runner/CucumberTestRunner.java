package com.cucumber.junit.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports"},
        glue = "com.cucumber.junit",
        features = "classpath:com/cucumber/junit/features"
)
public class CucumberTestRunner {
}
