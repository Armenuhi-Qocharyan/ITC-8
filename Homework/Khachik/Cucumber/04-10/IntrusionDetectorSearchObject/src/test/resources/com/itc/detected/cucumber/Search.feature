Feature: Search on detected objects
  As an user
  I want to search on detected objects list
  So that I can see results

  Scenario: results are shown
    Given the page is open "http://localhost:4200/detected"
    When I search object detected by "Camera-1"
    And I enter type "people"
    And I enter default date
    And I enter search button
    Then a camera name should contains "Camera-1"
