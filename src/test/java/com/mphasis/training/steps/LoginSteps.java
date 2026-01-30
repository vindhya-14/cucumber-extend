package com.mphasis.training.steps;

import com.mphasis.training.context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginSteps {

    private final TestContext testContext;
    private final WebDriver driver;

    // ✅ DI happens here
    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        this.driver = testContext.getDriver();
    }

    @Given("I am on the Internet login page")
    public void i_am_on_the_internet_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        // The Internet valid creds:
        // username: tomsmith
        // password: SuperSecretPassword!
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // wait for message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(By.id("flash")).isDisplayed());

        String flashMsg = driver.findElement(By.id("flash")).getText();

        // ✅ Store message in ScenarioContext (shared bag)
        testContext.getScenarioContext().set("flashMessage", flashMsg);
    }
}
