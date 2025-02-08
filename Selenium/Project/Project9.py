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
time.sleep(1)

# Navigate to the “My Info” page
my_info_menu = driver.find_element(By.ID, "menu_pim_viewMyDetails")
my_info_menu.click()

# Wait for the page to load
time.sleep(3)

# Click on the “Emergency Contacts” menu item
emergency_contacts_menu = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")
emergency_contacts_menu.click()

# Wait for the Emergency Contacts page to load
time.sleep(3)

# Retrieve information about all the contacts listed in the table
contact_table = driver.find_element(By.ID, "emgcontact_list")

# Get all the rows of the table (excluding the header row)
rows = contact_table.find_elements(By.TAG_NAME, "tr")

# Print all the information to the console
for row in rows:
    columns = row.find_elements(By.TAG_NAME, "td")
    contact_info = [col.text for col in columns]
    
    # Only print if the row contains data (to avoid printing empty rows)
    if contact_info:
        print(contact_info)

# Close the browser
driver.quit()