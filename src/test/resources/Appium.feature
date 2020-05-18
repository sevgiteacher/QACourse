Feature: Testing apks dynamically independent from activity and package
  Scenario: user should proceed pages on appiumDemos animation activity
    #Given user install "appium_application" goes "Animation_page"
    When user clicks "FADE_IN"
    And user clicks "LIST_DIALOG"
    And user clicks "Command_ONE"
    Then user views "Command_ONE_Chosen"
    And user press key "BACK"
    And user press key "APP_SWITCH"
    And user press key "HOME"

  Scenario: user should switch between apps
    Given user opens "AppiumDemos"
    When user clicks "FADE_IN"
    And user clicks "LIST_DIALOG"
    And user clicks "Command_ONE"
    And user views "Command_ONE_Chosen"
    Then user press key "APP_SWITCH"
    And user clicks "Calculator"
    And user clicks "7"
    And user clicks "Plus"
    And user clicks "9"
    And user clicks "Equal"
    And text in "Result" should be "16"
    And user press key "BACK"

  Scenario: user should be able to scroll to the text
    Given user opens "AppiumDemos"
    And user clicks "Views"
    And user scroll to "Tabs"
    And user clicks "Tabs"
    And user clicks "Scrollable"
    And user scroll horizontal to "TAB 20"
    And user clicks "TAB_20"
    Then text in "Content_Of_Tab" should be "Content for tab with tag Tab 20"


    

