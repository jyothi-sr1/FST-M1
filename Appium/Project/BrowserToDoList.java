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
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

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

public class BrowserToDoList {
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

		// Driver Initialization
				driver = new AndroidDriver(serverURL, options);
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			}
			
			// Test method
			@Test
			public void todolist() {
				// Open the page in Chrome
				driver.findElement(AppiumBy.accessibilityId("Chrome")).click();
				wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				
				driver.get("https://v1.training-support.net/selenium");
				wait = new WebDriverWait(driver, Duration.ofSeconds(20));
								
		        // Find and click the get started button, 
		       driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")).click();
		       wait = new WebDriverWait(driver, Duration.ofSeconds(20));	
		        
		     // UiScrollable object string
		        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		        List<WebElement> listElements = driver.findElements(AppiumBy.className("android.view.View"));
		        System.out.println("Before scroll: " + listElements.size());
		      		  
		        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward(25)"));
		        wait.until(ExpectedConditions.visibilityOfElementLocated(
		        	    AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")
		        	));
		        
		        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")).click();
		        wait.until(ExpectedConditions.elementToBeClickable(
		         AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")));
		       
		        wait = new WebDriverWait(driver, Duration.ofSeconds(20));			        
		        //add tasks,  //*[@id="taskInput"]  //android.widget.TextView[@text="Add more tasks to this list."]
		        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("1");
		        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
		        wait.until(ExpectedConditions.elementToBeClickable(
				       	   AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")));
		        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("2");
		        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
		        wait.until(ExpectedConditions.elementToBeClickable(
				       	   AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")));
		        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("3");
		        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
		        wait.until(ExpectedConditions.elementToBeClickable(
				       	   AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")));
		       
		        List<WebElement> tasklist=driver.findElements(AppiumBy.id("taskList"));
		        System.out.println("number of taks added: "+tasklist.size());
		        
		        Assert.assertEquals(tasklist.size(), 3);
		        
		        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"1\"]")).click();
		        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"2\"]")).click();
		        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"3\"]")).click();
		        
		        driver.findElement(AppiumBy.xpath("//android.view.View[@text='Clear List']")).click();
		        tasklist = driver.findElements(AppiumBy.id("taskList"));
		        int taskCount = tasklist.size();
		        System.out.println("number of taks added: "+taskCount);
		        		        	        
		        Assert.assertEquals(taskCount,0);
  }
			// Tear down method
		     @AfterClass
		     public void tearDown() {
		         // Close the app
		        driver.quit();
		   }
}