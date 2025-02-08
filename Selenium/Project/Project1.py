import pandas
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By

#create WebDriver instance
with webdriver.Firefox() as driver:
    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
   #go to web page
    driver.get("http://alchemy.hguy.co/orangehrm")
    #do the stuff on the page
    pageTitle = driver.title
    print("Title of the page is : " + pageTitle) 

# Verify if the title matches "OrangeHRM"
if pageTitle == "OrangeHRM":
    print("Title matches: OrangeHRM")
else:
    print("Title does not match. It is: {website_title}")

# Close the browser
driver.quit()