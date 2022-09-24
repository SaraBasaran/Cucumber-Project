@data_tables
Feature: data_tables
  Scenario: customer_login
    Given user opens the URL "https://www.bluerentalcars.com/"
    When user navigate the login page
    And user enters manager_username and manager_password
      |username                     |password  |
      |customer@bluerentalcars.com  |12345     |
    Then verify the login is successful
    Then close the application