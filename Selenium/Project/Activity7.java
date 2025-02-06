package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
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
        Thread.sleep(5000);
        
     // Find the MyInfo option in the menu and click it
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[6]/a/b")).click();
        Thread.sleep(2000);
        // Find the Edit button and click it
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
               
     // Find the Qualification option in the menu and click it
        driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[9]/a")).click();
        Thread.sleep(2000);
       
     // Click on Add
        driver.findElement(By.xpath("//*[@id=\"addWorkExperience\"]")).click();
        Thread.sleep(2000);
        
     // Find the input fields
        WebElement company = driver.findElement(By.xpath("//*[@id=\"experience_employer\"]"));
        WebElement jobtitle = driver.findElement(By.xpath("//*[@id=\"experience_jobtitle\"]"));
        WebElement from = driver.findElement(By.id("experience_from_date"));
        WebElement to = driver.findElement(By.id("experience_to_date"));
     // Enter the details
        company.clear();
        company.sendKeys("ABC");
        jobtitle.clear();
        jobtitle.sendKeys("Tester");
        from.clear();
        from.sendKeys("2020-01-01");
        from.clear();
        from.sendKeys("2025-01-01");
     // Find and click the save button
        driver.findElement(By.xpath("//*[@id=\"btnWorkExpSave\"]")).click();
        
      
      // Print the message
      System.out.println(driver.findElement(By.xpath("//*[@id=\"profile-pic\"]/h1")).getText());
      System.out.println(driver.findElement(By.xpath("//*[@id=\"sectionWorkExperience\"]/div[1]/h1")).getText());
         
        // Close the browser
        driver.quit();
    }
}

