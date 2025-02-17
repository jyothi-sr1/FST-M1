package stepDefinitions;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsAct4 {
	private FirefoxDriver driver;
	private WebDriverWait wait;
	
    @Given("the user is on login page")
    public void openPage() {
    	FirefoxOptions options = new FirefoxOptions();
    	driver = new FirefoxDriver(options);  
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Open the login page
        driver.get("https://training-support.net/webelements/login-form");
        // Assert page title
        Assertions.assertEquals("Selenium: Login Form", driver.getTitle());
    }

    @When("the user enters username and password")
    public void enterCredentials() {
        // Find username field and enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        // Find password field and enter password
        driver.findElement(By.id("password")).sendKeys("password");
    }

    @When("the user enters {string} and {string}")
    public void enterCredentialsFromInputs(String username, String password) {
        // Find the input fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        // Clear the fields
        usernameField.clear();
        passwordField.clear();
        // Find username field and enter username
        usernameField.sendKeys(username);
        // Find password field and enter password
        passwordField.sendKeys(password);
    }
    
    @And("clicks the submit button")
    public void clickSubmit() {
        // Find the submit button and click it
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }

    @Then("get the confirmation text and verify message as {string}")
    public void confirmMessage(String expectedMessage) {
        // Find the confirmation message
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
        String message = driver.findElement(By.cssSelector("h2.mt-5")).getText();
        // Assert message
        Assertions.assertEquals("Welcome Back, Admin!", message);
    }
    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser
        }
    }
}