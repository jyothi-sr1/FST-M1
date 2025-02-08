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

my_info_menu = driver.find_element(By.ID, "menu_pim_viewMyDetails")
my_info_menu.click()

# Wait for the page to load
time.sleep(3)

# Find the "Qualification" option on the left side menu and click it
qualification_menu = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[1]/ul/li[9]/a")
qualification_menu.click()

# Wait for the page to load
time.sleep(3)

# Add Work Experience
add_work_experience_button = driver.find_element(By.ID, "addWorkExperience")
add_work_experience_button.click()

# Fill out the work experience form
company_input = driver.find_element(By.ID, "experience_employer")
job_title_input = driver.find_element(By.ID, "experience_jobtitle")
from_date_input = driver.find_element(By.ID, "experience_from_date")
to_date_input = driver.find_element(By.ID, "experience_to_date")
comments_input = driver.find_element(By.ID, "experience_comments")

# Example of adding data, modify as needed
company_input.send_keys("ABCD")
job_title_input.send_keys("Software Engineer")
from_date_input.clear()
from_date_input.send_keys("2020-01-01") 
to_date_input.clear() 
to_date_input.send_keys("2023-12-31")
comments_input.send_keys("developer")

# Save the work experience
save_button = driver.find_element(By.ID, "btnWorkExpSave")
save_button.click()

# Wait for the save action to complete
time.sleep(3)
print("Added qualification successfully.")

# 6. Close the browser
driver.quit()