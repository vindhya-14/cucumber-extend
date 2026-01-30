package com.mphasis.training.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.mphasis.training",
        plugin = {"pretty"},
        monochrome = true
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
