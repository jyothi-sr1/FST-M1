package examples;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LocatorsExample {
	//Declare Appium driver
	AppiumDriver driver;
	
	//Setup Function
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException{
		//Desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		//options.setApp("/path/to/app.apk");
		options.setAppPackage("com.android.calculator2");
		options.setAppActivity(".Calculator");
		options.noReset();
			
		//server url
		URL serverURL = new URI("http://localhost:4723").toURL();
			
		//Initialize the driver
		driver = new AndroidDriver(serverURL,options);
	}
	
	//test functions
	@Test
	public void addTest() {
		// Find digit 5 and tap it
		driver.findElement(AppiumBy.id("digit_5")).click();
		// Find plus symbol and tap it
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		// Find digit 9 and tap it
		driver.findElement(AppiumBy.id("digit_9")).click();
		// Find equals symbol and tap it
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
	
		//Assertions
		String result = driver.findElement(AppiumBy.id("result")).getText();
		assertEquals(result, "14");
	}
	
	//Tear down function
	 @AfterClass
	 public void tearDown() {
		//close the app
		driver.quit();
	}
}

