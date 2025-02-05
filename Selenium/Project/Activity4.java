package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity4 {
    public static void main(String[] args) throws Throwable {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Actions object
        Actions builder = new Actions(driver);

        // Open the page
        driver.get("http://alchemy.hguy.co/orangehrm");
        
     // Find the username field and enter the username
        driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("orange");
        // Find the password field and enter the password
        driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("orangepassword123");
        // Find the login button and click it
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        Thread.sleep(2000);
        
     // Find the PIM option in the menu and click it
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click();
        Thread.sleep(2000);
        // Find the Add button and click it
        driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
       
     // Find the input fields
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
     // Enter the details
        firstName.sendKeys("Jyothi");
        lastName.sendKeys("SR");
     // Find and click the save button
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
            
      // Print the message
      System.out.println(driver.findElement(By.id("employee-details")).getText());
         
        // Close the browser
        driver.quit();
    }
}