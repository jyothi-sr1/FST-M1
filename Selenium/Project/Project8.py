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

# Navigate to the Dashboard page and click on the "Apply Leave" option
apply_leave_button = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/img")
apply_leave_button.click()

# Wait for the "Apply Leave" page to load
time.sleep(3)

# Selecting leave type
leave_type_dropdown = driver.find_element(By.ID, "applyleave_txtLeaveType")
leave_type_dropdown.click()
driver.find_element(By.XPATH, "//option[text()='DayOff']").click()

# Select the leave duration
from_date_input = driver.find_element(By.ID, "applyleave_txtFromDate")
to_date_input = driver.find_element(By.ID, "applyleave_txtToDate")

# Add Dates
from_date_input.clear()
from_date_input.send_keys("2025-02-10")
to_date_input.clear()
to_date_input.send_keys("2025-02-15")

# Click Apply to submit the leave application
apply_button = driver.find_element(By.ID, "applyBtn")
apply_button.click()

# Wait for the leave application to be processed
time.sleep(3)

# Navigate to the "My Leave" page to check the status of the leave application
my_leave_button = driver.find_element(By.ID, "menu_leave_viewMyLeaveList")
my_leave_button.click()

# Wait for the "My Leave" page to load
time.sleep(3)

# Check the leave status
# You can check the leave status in the table or on the page
leave_status_table = driver.find_element(By.ID, "resultTable")

# Optionally, print out the table data to verify the leave application status
print(leave_status_table.text)

#Close the browser
driver.quit()