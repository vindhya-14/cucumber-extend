package com.mphasis.training.context;

import org.openqa.selenium.WebDriver;

public class TestContext {

    private WebDriver driver;
    private final ScenarioContext scenarioContext = new ScenarioContext();

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
