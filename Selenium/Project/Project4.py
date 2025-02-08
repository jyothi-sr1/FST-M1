from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
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
WebDriverWait(driver, 10)

# Find the PIM option in the menu and click it.
pim_menu = driver.find_element(By.ID, "menu_pim_viewPimModule")
pim_menu.click()

# Click the Add button to add a new Employee
add_button = WebDriverWait(driver, 10).until(
    EC.element_to_be_clickable((By.ID, "btnAdd"))
)
add_button.click()

# Fill in the required fields and click Save.
first_name_field = driver.find_element(By.ID, "firstName")
last_name_field = driver.find_element(By.ID, "lastName")

# Replace with the employee's information
first_name_field.send_keys("Johnson")
last_name_field.send_keys("Doe")

# Click Save
save_button = driver.find_element(By.ID, "btnSave")
save_button.click()

# Navigate back to the PIM page (Employee List tab) and verify the creation of your employee.
employee_list_tab = WebDriverWait(driver, 10).until(
    EC.element_to_be_clickable((By.ID, "menu_pim_viewEmployeeList"))
)
employee_list_tab.click()

# Use employee ID to verify if the employee is listed
try:
    WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.XPATH, "//*[@id='empsearch_employee_name_empName']"))
    )
    print("Employee added successfully.")
except:
    print("Employee was not added or not found in the list.")

# Step 9: Close the browser
driver.quit()