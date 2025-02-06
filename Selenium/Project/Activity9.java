package seleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity9 {
    private static Object table_rows;
	private static Object contact_name;
	private static Object contact_relationship;
	private static Object contact_home_phone;
	private static Object contact_mobile_phone;
	private static Object contact_work_phone;

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
        Thread.sleep(500);
        
     // Find the MyInfo option in the menu and click it
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();
        Thread.sleep(200);
               
     // Find the Emergency contacts option in the menu and click it
        driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[3]/a")).click();
        Thread.sleep(200);
            
        //TO print row info  //*[@id="emgcontact_list"]/thead
        List<WebElement> Heading = driver.findElements(By.xpath("//*[@id=\"emgcontact_list\"]/thead"));
        List<WebElement> contact1 = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr[1]"));
        List<WebElement> contact2 = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr[2]"));
        List<WebElement> contact3 = driver.findElements(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr[3]"));
        
        System.out.println("Column Names: ");
        for(WebElement cell : Heading) {
            System.out.println(cell.getText());
        }
        System.out.println("First row values: ");
        for(WebElement cell : contact1) {
            System.out.println(cell.getText());
        }
        System.out.println("Second row values: ");
        for(WebElement cell : contact2) {
            System.out.println(cell.getText());
        }
        System.out.println("Third row values: ");
        for(WebElement cell : contact3) {
            System.out.println(cell.getText());
        }              
       
     // Print the message
     // System.out.println(driver.findElement(By.xpath("//*[@id=\"profile-pic\"]/h1")).getText());
     // System.out.println(driver.findElement(By.xpath("//*[@id=\"sectionWorkExperience\"]/div[1]/h1")).getText());
         
        // Close the browser
        driver.quit();
    }
}


