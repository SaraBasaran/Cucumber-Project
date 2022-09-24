Feature: FE341_US3412_log_in_with_customer_credentials
  @customer_excel

  Scenario: TC01_login_with_customer

    Given user tries to login as "customer"
    Then verify the login is successful
    Then capture the screenshot
    Then close the application