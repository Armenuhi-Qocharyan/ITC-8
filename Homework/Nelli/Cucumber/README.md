cucumber-jvm-selenium-example
================

This basic scenario tests search on Cameras page. It opens [localhost:4200/ca,eras] and search for string "Camera-11" and "aaaa".

<pre>
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
</pre>
