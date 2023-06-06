package com.cucumber.practice.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
        "html:target/cucumber-reports/index.html",
        "json:target/cucumber-reports/json/CucumberTests.json",
        "junit:target/cucumber-reports/junit/CucumberTests.xml"
        },
        monochrome = true,
        tags = "@smoke",
        glue = "com.cucumber.practice",
        features = "classpath:com/cucumber/practice/features"
)
public class CucumberTest {
}
