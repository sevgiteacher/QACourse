Feature: Lets do some Rest Assured with cucumber

  Scenario: Verify user name with GET
    Given I perform "GET" operation with "/users/2"
    Then I should see the First_Name as "Janet"
    And I should see the status_code as 200


  Scenario: test with post
    Given I perform "POST" operation with "/users"
    |name  | job     |
    |Jack  | engineer|
    Then I should see the status_code as 201