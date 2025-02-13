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

public class Activity1 {
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
	        // Find and click the Tasks button
	        driver.findElement(AppiumBy.accessibilityId("Tasks")).click();
	     
	        // Wait for elements to load
	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")
	        )); 
	        
	     // Find and click on add
	        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
	     
	     // Wait for elements to load
	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]")
	        ));
	   	   
	     // Enter the details
	        driver.findElement(AppiumBy.xpath(
	                "//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]"
	        )).sendKeys("Complete Activity with Google Tasks");
	        
	     // Find and click on save
	        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
	       
	     // Find and click on add
	        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
	     
	     // Wait for elements to load
	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]")
	        ));
	   	   
	     // Enter the details
	        driver.findElement(AppiumBy.xpath(
	                "//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]"
	        )).sendKeys("Complete Activity with Google Keep");
	        
	     // Find and click on save
	        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	     // Find and click on add
	        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
	     
	     // Wait for elements to load
	        wait.until(ExpectedConditions.elementToBeClickable(
	                AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]")
	        ));
	   	   
	     // Enter the details
	        driver.findElement(AppiumBy.xpath(
	                "//android.widget.EditText[@resource-id=\"com.google.android.apps.tasks:id/add_task_title\"]"
	        )).sendKeys("Complete the second Activity Google Keep");
	        
	     // Find and click on save
	        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        List<WebElement> taskList = driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	     // Assertion to verify all three tasks have been added
	     Assert.assertEquals(taskList.size(), 3, "There should be 3 tasks in the list");

	     // verify the task names
	     Assert.assertTrue(taskList.get(0).getText().contains("Complete the second Activity Google Keep"));
	     Assert.assertTrue(taskList.get(1).getText().contains("Complete Activity with Google Keep"));
	     Assert.assertTrue(taskList.get(2).getText().contains("Complete Activity with Google Tasks"));
    
}
	 // Tear down method
	     @AfterClass
	     public void tearDown() {
	         // Close the app
	         driver.quit();
	     }
	}