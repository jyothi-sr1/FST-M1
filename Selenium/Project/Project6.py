from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import Select
import time

# Open the browser to the login page of OrangeHRM site.
driver = webdriver.Firefox() 
driver.get("https://alchemy.hguy.co/orangehrm")

# Find and select the username and password fields
username_field = driver.find_element(By.ID, "txtUsername")  # Username field
password_field = driver.find_element(By.ID, "txtPassword")  # Password field

# Enter login credentials into the respective fields
username_field.send_keys("orange")  # Replace with actual username
password_field.send_keys("orangepassword123")  # Replace with actual password

# Click login
login_button = driver.find_element(By.ID, "btnLogin")
login_button.click()

# Step 3: Wait for successful login and the homepage to load
WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.ID, "welcome")))

# Step 4: Locate the navigation menu and "Directory" menu item
directory_menu = WebDriverWait(driver, 10).until(
    EC.presence_of_element_located((By.ID, "menu_directory_viewDirectory"))
)

# Step 5: Verify that the "Directory" menu item is visible and clickable
try:
    # Check if "Directory" is clickable
    directory_menu = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "/html/body/div[1]/div[2]/ul/li[9]/a/b"))
    )
    print("The 'Directory' menu item is visible and clickable.")

    # Step 6: Click on the "Directory" menu item
    directory_menu.click()

    # Step 7: Verify that the heading of the page matches “Search Directory”
    page_heading = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.XPATH, "//h1[contains(text(),'Search Directory')]"))
    )

    if page_heading.text == "Search Directory":
        print("Successfully navigated to the 'Search Directory' page.")
    else:
        print(f"Heading mismatch. Found: {page_heading.text}")

except Exception as e:
    print(f"Error: {e}")

# Step 8: Close the browser
driver.quit()