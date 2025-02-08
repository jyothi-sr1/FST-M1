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
WebDriverWait(driver, 10)

# Step 4: Find the “My Info” menu item and click it
my_info_menu = WebDriverWait(driver, 10).until(
    EC.element_to_be_clickable((By.XPATH, "/html/body/div[1]/div[2]/ul/li[6]/a/b"))
)
my_info_menu.click()

# Step 5: Click the Edit button
edit_button = WebDriverWait(driver, 10).until(
    EC.element_to_be_clickable((By.ID, "btnSave"))
)
edit_button.click()

# Step 6: Fill in the Name, Gender, Nationality, and DOB fields
# Fill in the name (first and last name)
first_name_field = driver.find_element(By.ID, "personal_txtEmpFirstName")
last_name_field = driver.find_element(By.ID, "personal_txtEmpLastName")

# Replace with the new name
first_name_field.clear()
first_name_field.send_keys("Johnson")
last_name_field.clear()
last_name_field.send_keys("Doe")

# Fill in gender (select radio button for Male)
gender_male_radio = driver.find_element(By.ID, "personal_optGender_1")  # Male option
gender_male_radio.click()

# Fill in nationality (select from the dropdown)
nationality_dropdown = driver.find_element(By.ID, "personal_cmbNation")
nationality_dropdown.click()
# Select the first nationality in the dropdown (or change to a specific value if needed)
select = Select(nationality_dropdown)
select.select_by_index(10)
#nationality_dropdown.send_keys(Keys.DOWN:['4'])  # Adjust as per the desired nationality option
#nationality_dropdown.send_keys(Keys.RETURN)

# Fill in Date of Birth (DOB)
dob_field = driver.find_element(By.ID, "personal_DOB")
dob_field.clear()
dob_field.send_keys("1990-01-01")  # Replace with the required date of birth

# Step 7: Click Save
save_button = driver.find_element(By.ID, "btnSave")
save_button.click()

# Step 8: Wait to ensure the changes are saved
time.sleep(3)  # Wait for 3 seconds to make sure the save is complete
print("Employee edited successfully.")

# Step 9: Close the browser
driver.quit()