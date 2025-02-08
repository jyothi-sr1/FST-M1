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

    header_image = driver.find_element(By.XPATH, "/html/body/div[1]/div/div[2]/div[1]/img")
    header_image_url = header_image.get_attribute("src")

# Step d: Print the image URL to the console
print("URL of the header image:", header_image_url)

# Step e: Close the browser
driver.quit()