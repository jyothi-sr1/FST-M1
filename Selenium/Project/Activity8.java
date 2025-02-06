package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {
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
        
     // Find the Apply Leave option and click it
        driver.findElement(By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[4]/div/a/img")).click();
        Thread.sleep(1000);
        // Find the Edit button and click it
        //driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
                 
     // Find the input fields
        WebElement leavetypeDropdown = driver.findElement(By.id("applyleave_txtLeaveType"));
        WebElement fromdate = driver.findElement(By.id("applyleave_txtFromDate"));
        WebElement todate = driver.findElement(By.id("applyleave_txtToDate"));
     // Enter the details
        leavetypeDropdown.click();
        WebElement leavetypeOption = driver.findElement(By.xpath("//option[text()='DayOff']")); 
        leavetypeOption.click();
        fromdate.clear();
        fromdate.sendKeys("2025-02-10");
        todate.clear();
        todate.sendKeys("2025-02-10");
     // Find and click the save button
        driver.findElement(By.xpath("//*[@id=\"applyBtn\"]")).click();
     
        // Find the My Leave option and click it
        driver.findElement(By.xpath("//*[@id=\"menu_leave_viewMyLeaveList\"]")).click();
        Thread.sleep(200);
        
     // Click on Search
        driver.findElement(By.xpath("//*[@id=\"btnSearch\"]")).click();
        Thread.sleep(200);
      
      // Print the message
      System.out.println(driver.findElement(By.xpath("//*[@id=\"welcome\"]")).getText());
      System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[3]/table/tbody/tr[1]/td[6]/a")).getText());
         
        // Close the browser
        driver.quit();
    }
}


