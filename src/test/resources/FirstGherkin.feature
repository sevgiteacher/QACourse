Feature: Lets go to google
  Scenario: User goes to Google Main Page
    Given user opens "https://www.google.com"
    When user enters "Selenium" to "Search_Button" area
    Then user views "results"

  Scenario: User logins Facebook
    Given user opens "https://www.facebook.com"
    When user enters "a@a.com" to "Facebook_Email" area
    And user enters "pass" to "Facebook_Password" area
    And user clicks "Facebook_Login"
    Then user should see "Login_Facebook" page
