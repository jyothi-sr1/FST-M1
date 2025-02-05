package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity2 {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Actions object
        Actions builder = new Actions(driver);

        // Open the page
        driver.get("http://alchemy.hguy.co/orangehrm");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Press the key
        builder.sendKeys("This is coming from Selenium").sendKeys(Keys.RETURN).build().perform();
        
        //Print url
        WebElement headerImage = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/img"));
        String imageUrl = headerImage.getAttribute("src");
        
        System.out.println("The URL of the header image is: " + imageUrl);
        
        // Print the message from the page
        //String pageText = driver.findElement(By.cssSelector("#divLogo > img:nth-child(1)")).getText();
        //System.out.println(pageText);

        // Close the browser
        driver.quit();
    }
}
