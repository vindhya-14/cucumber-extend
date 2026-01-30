package com.mphasis.training.hooks;

import com.mphasis.training.context.TestContext;
import com.mphasis.training.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private final TestContext testContext;

    // ✅ PicoContainer injects the SAME TestContext into Hooks + all Step classes (per scenario)
    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp() {
        DriverFactory factory = new DriverFactory();
        testContext.setDriver(factory.createChromeDriver());
    }

    @After
    public void tearDown() {
        if (testContext.getDriver() != null) {
            testContext.getDriver().quit();
        }
    }
}
