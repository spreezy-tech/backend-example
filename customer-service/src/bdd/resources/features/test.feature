Feature: Testing login controller

  Scenario: Test login
    Given User calls login endpoint
    When System processes login request
    Then Validate response from the login endpoint