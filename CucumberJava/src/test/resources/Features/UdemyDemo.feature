Feature: Test login functionality

  Scenario: Check login is Successful with valid credentials
    Given browser is open
    And User is on udemy page
    When clicks on login button
    When user enter username and password
    And user clicks on submit button
    Then user is navigated to the home page
