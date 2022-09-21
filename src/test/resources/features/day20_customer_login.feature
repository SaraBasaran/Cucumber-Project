Feature: Search Feature

  Background: User_goes_to_google
    Given user enters to application url

  @customer_login
  Scenario: TC01_customer_logs_in_application
    When user is on the application website
    Then user clicks on the login button
    Then user enters customer_username
    And user enters customer_password
    And user clicks on Login Button
    And verify user is logged in