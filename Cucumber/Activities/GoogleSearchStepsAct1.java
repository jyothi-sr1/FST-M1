package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchStepsAct1 {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Given("User is on Google Home Page")
	public void userIsOnGooglePage() throws Throwable {	
		FirefoxOptions options = new FirefoxOptions();
		// Open the browser
		driver = new FirefoxDriver(options);
		driver.get("https://www.google.com/search");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("User types in Cheese and hits ENTER")
	public void userTypesInCheeseAndHitsENTER() throws Throwable {
		driver.findElement(By.name("q")).sendKeys("Cheese", Keys.ENTER);
	}

	@Then("Show how many search results were shown")
	public void showHowManySearchResultsWereShown() throws Throwable {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hdtb-tls")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hdtb-tls"))).click();
		} catch (Exception e) {
			System.out.println("Error occurred while waiting for the 'Sort by' dropdown: " + e.getMessage());
        }
		String resultStats = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats"))).getText();
		System.out.println("Number of results found: " + resultStats);
	}
	
	@io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser
        }
    }
}