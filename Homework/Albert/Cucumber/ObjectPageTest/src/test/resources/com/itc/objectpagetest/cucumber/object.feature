Feature: Test detected objects page
  Test when input valid email and password navigate to home page
  Test delete object
  Test edit object
  Test merge object

  Scenario: Test login
    Given the page is open "http://localhost:4200/login"
    And I enter email "admin@mail.ru"
    And I enter password "Admin1"
    And I enter signin button
    Then i navigate home page "http://localhost:4200/home"
