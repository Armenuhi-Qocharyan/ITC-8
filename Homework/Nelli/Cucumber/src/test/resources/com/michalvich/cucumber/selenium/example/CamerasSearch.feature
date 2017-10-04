Feature: Search on Cameras
  As an user
  I want to search on cameras page
  So that I can see results

  Scenario: results are shown
    Given the page is open "http://localhost:4200/cameras"
    When I search for "Camera-11"
    Then a shown device name should contains "Camera-11"
    When bad search for "aaaa"
    Then I can't see any results