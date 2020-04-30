Feature: Lets go to google
  Scenario: User goes to Google Main Page
    Given user opens "https://www.google.com"
    When user enters "Selenium" to "Search_Button" area
    Then user views "results"

