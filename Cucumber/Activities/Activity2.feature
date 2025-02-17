@activity2
Feature: Activity to test the login feature

  Scenario: Successful login
    Given the user is on to the login page
    When the user enters the username and password
    And clicks on the submit button
    Then get the confirmation message on the page and verify it