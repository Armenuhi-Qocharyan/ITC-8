@login
Feature: login

  Background:
    Given Open "Google Chrome" browser with "https://localhost:3000/login-register" url

  Scenario Outline: Compare data between Hive and Vertica for "<vertica_table>" table
    When Fill "<filed1>" element with "<value1>" value
    When "<filed2>" element with "<value2>" value
    Then Click on "<button>" button
    Then Verify "<title>"

    Examples:
      | filed1    | value1    | filed2 | value2       | button  | title |
      | username  | nn@nn.nn  | pass   | maybe0508    | submit  | Home  |


