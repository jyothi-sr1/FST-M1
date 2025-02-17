@SmokeTest
Feature: Link to the about us page

 Scenario: The user should be able to navigate to the About Us page
    Given User is on the training support home page
    When User clicks on the About Us button
    Then User should be taken to the About Us page
    And Close the browser