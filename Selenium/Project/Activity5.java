package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
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
       
     // Find the input fields
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpLastName\"]"));
        WebElement genderField = driver.findElement(By.id("personal_optGender_1")); // Male
        WebElement nationalityDropdown = driver.findElement(By.id("personal_cmbNation"));
        WebElement dobField = driver.findElement(By.id("personal_DOB"));
     // Enter the details
        firstName.clear();
        firstName.sendKeys("Jhon");
        lastName.clear();
        lastName.sendKeys("Doe");
        genderField.click();
        nationalityDropdown.click();
        WebElement nationalityOption = driver.findElement(By.xpath("//option[@value='4']")); // Example value for nationality
        nationalityOption.click();
        dobField.clear();
        dobField.sendKeys("1996-03-07");
     // Find and click the save button
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
        
      
      // Print the message
      System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div/h1")).getText());
      System.out.println(driver.findElement(By.xpath("//option[@value='4']")).getText());
         
        // Close the browser
        driver.quit();
    }
}
