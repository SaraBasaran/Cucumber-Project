@scenario_outline1
Feature: Scenario_outline

  Background: User_goes_to_google
    Given user opens the URL "https://www.google.com"

  Scenario Outline: Google_Search

    Given user search for "<item>" on the google
    Then verify the page title contains "<item>"
    Then close the application


    Examples: test_data
      |item|
      |mercedes|
      |tesla   |
      |toyota  |
      |honda   |
      |bmw     |