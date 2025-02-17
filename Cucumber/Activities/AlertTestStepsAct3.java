package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertTestStepsAct3 {
	private FirefoxDriver driver;
	private WebDriverWait wait;
	Alert alert;

	@Given("User is on the page")
	public void openPage() {
		FirefoxOptions options = new FirefoxOptions();
    	driver = new FirefoxDriver(options); 
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Open browser
		driver.get("https://training-support.net/webelements/alerts");
	}

	@When("User clicks the Simple Alert button")
	public void openSimpleAlert() {
		driver.findElement(By.id("simple")).click();
	}

	@When("User clicks the Confirmation Alert button")
	public void openConfirmAlert() {
		driver.findElement(By.id("confirmation")).click();
	}

	@When("User clicks the Prompt Alert button")
	public void openPromptAlert() {
		driver.findElement(By.id("prompt")).click();
	}

	@Then("Alert opens")
	public void switchFocus() {
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
	}

	@And("Read the text from it and print it")
	public void readAlert() {
		System.out.println("Alert says: " + alert.getText());
	}

	@And("Write a custom message in it")
	public void writeToPrompt() {
		alert.sendKeys("Custom Message");
	}

	@And("Close the alert")
	public void closeAlert() {
		alert.accept();
	}

	@And("Close the alert with Cancel")
	public void closeAlertWithCAncel() {
		alert.dismiss();
	}

	@And("Read the result text")
	public void readResultText() {
		String message = driver.findElement(By.id("result")).getText();
		System.out.println("Action performed: " + message);
	}
	
	@io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser after the test
        }
    }
}
