@activity5
Feature: Data driven test with Examples

  Scenario Outline: Testing with Data from Scenario
    Given the user is on the login home page
    When the user enters "<Usernames>" and "<Passwords>" in the login form
    And clicks to the submit button
    Then get the confirmation text and verify message as "<Message>" expected

    Examples: 
      | Usernames | Passwords | Message             |
      | admin     | password  | Welcome Back, admin |