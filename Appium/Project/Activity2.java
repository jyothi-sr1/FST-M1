package AppiumProjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;

public class Activity2 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
		// Test method
	    @Test
	    public void taskTest() {
	        // Find and click the KeepNotes button
	        driver.findElement(AppiumBy.accessibilityId("Keep Notes")).click();
	     
	        // Wait for elements to load
	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.id("com.google.android.keep:id/speed_dial_create_close_button")
	        )); 
	        
	     // Find and click on add
	        driver.findElement(AppiumBy.accessibilityId("Create a note")).click();
	        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
	        //driver.findElement(AppiumBy.accessibilityId("com.google.android.keep:id/editable_title")).click();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	      	             
	     // Enter the details
	        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("hello");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        driver.findElement(AppiumBy.xpath(
	                "//android.widget.EditText[@resource-id=\"com.google.android.keep:id/editable_title\"]"
	        )).sendKeys("test");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        	        
	      driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
	      wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	      // Step 7: Assert that the note with the reminder is present in the Reminders page
	        WebElement reminderNote = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.google.android.keep:id/index_note_title\"])[1]"));
	        Assert.assertTrue(reminderNote.isDisplayed());

	        System.out.println("Test Passed: The note is added.");
	    
	    }
	   
	  // Tear down method
	     @AfterClass
	     public void tearDown() {
	         // Close the app
	        driver.quit();
	   }
}