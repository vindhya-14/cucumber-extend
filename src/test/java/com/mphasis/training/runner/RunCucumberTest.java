package com.mphasis.training.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.mphasis.training",
        		 plugin = {
        			        "pretty",
        			        "html:target/cucumber/cucumber.html",
        			        "json:target/cucumber/cucumber.json",
        			        "rerun:@target/rerun.txt"
        			    },
        monochrome = true
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
