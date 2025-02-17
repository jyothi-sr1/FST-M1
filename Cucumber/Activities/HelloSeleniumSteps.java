package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HelloSeleniumSteps {
	private WebDriver driver;

	@Given("User is on the training support home page")
	public void  user_is_on_home_page() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net");
	}

	@When("User clicks on the About Us button")
	public void click_about_us_button() throws InterruptedException {
		driver.findElement(By.linkText("About Us")).click();
		Thread.sleep(2000);
	}

	@Then("User should be taken to the About Us page")
	public void take_user_to_about_page() {
		String title = driver.getTitle();
		Assertions.assertEquals("About Training Support", title);
	}

	@And("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}
}