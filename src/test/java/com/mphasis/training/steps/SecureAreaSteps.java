package com.mphasis.training.steps;

import com.mphasis.training.context.TestContext;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SecureAreaSteps {

    private final TestContext testContext;

    public SecureAreaSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("I should see the secure area success message")
    public void i_should_see_the_secure_area_success_message() {
        String flashMsg = testContext.getScenarioContext().get("flashMessage", String.class);

        Assert.assertNotNull(flashMsg, "Flash message should not be null");
        Assert.assertTrue(
                flashMsg.contains("You logged into a secure area!"),
                "Expected success message not found. Actual: " + flashMsg
        );
    }
}
