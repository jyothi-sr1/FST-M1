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

public class loginWithCorrectCredentials {
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
			public void CorrectCredentials() {
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
		      		  
		      // driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward(5)"));
		       wait.until(ExpectedConditions.visibilityOfElementLocated(
		        	    AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")
		       	));
		      driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")).click();
			
		    // Wait for elements to load
	        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        // Wait for elements to load
	        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")));
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
	        
	        	        
	       // wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	      //  wait.until(ExpectedConditions.visibilityOfElementLocated(
	      //          AppiumBy.xpath("//android.widget.TextView[@text='Welcome Back, Admin']")
	       //     ));
	        //    WebElement successMessage = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Welcome Back, Admin']"));
	      //      Assert.assertTrue(successMessage.isDisplayed(), "Welcome Back, Admin");
	        }
			
			@AfterClass
		    public void tearDown() {
		        if (driver != null) {
		            driver.quit();
		        }
		    }
}





