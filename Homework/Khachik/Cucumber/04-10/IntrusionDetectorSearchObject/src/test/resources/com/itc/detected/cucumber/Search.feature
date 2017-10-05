Feature: Search on detected objects
  As an user
  I want to search on detected objects list
  So that I can see results

  Scenario: Open the page
    Given the page is open "http://localhost:4200/detected"

  Scenario Outline: Positive search   
    When I search object detected by <camera_name>
    And I enter type <object_type>
    And I enter default date
    And I click button "/html/body/id-root/div/div/id-detected-objects/div/div/id-search/div/div/div[2]/button[1]"
    Then a camera name should contains <camera_name>
    Examples:
      | camera_name | object_type |
      |  "Camera-1" |   "people"  |
      |  "Camera-2" |   "people"  |

  Scenario Outline: date time picker test
    When I open date picker "/html/body/id-root/div/div/id-detected-objects/div/div/id-search/div/div/div[2]/input[3]"
    And I click button <switch_month_button>
    Then field "/html/body/div[2]/div[1]/div[2]/table/thead/tr[1]/th[2]" should contains <left_month_text_area_value> 
    And I click button <day_button> 
    Then a input area "/html/body/div[2]/div[1]/div[1]/input" should contains <date_input_area_value>
    And I click button "/html/body/div[2]/div[3]/div/button[1]"
    Examples:
      |                    switch_month_button                     | left_month_text_area_value |                       day_button                         | date_input_area_value |
      |"/html/body/div[2]/div[1]/div[2]/table/thead/tr[1]/th[1]/i" |         "Dec 2016"         | "/html/body/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[5]"| "2016-12-01 12:00:00" |
      |"/html/body/div[2]/div[2]/div[2]/table/thead/tr[1]/th[3]/i" |         "Jan 2017"         | "/html/body/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[1]"| "2017-01-01 12:00:00" |

  Scenario Outline: search negative testing
    When I search object detected by <camera_name>
    And I enter type <object_type>
    And I click button "/html/body/id-root/div/div/id-detected-objects/div/div/id-search/div/div/div[2]/button[1]"
    Then a page body should contains "/html/body/modal-overlay/div/bs-modal-container/div/div"
    And I click button "/html/body/modal-overlay/div/bs-modal-container/div/div/modal-content/modal-footer/div/button"
    Examples:
      | camera_name | object_type |
      |  "aaaadd-%" |   "person"  |
      |  "Kamera_1" |   "camel"   |
      |  "!@#$%^_1" |    "cow"    |
      |      ""     |      ""     |

  Scenario: test clean all button
    When I click button "/html/body/id-root/div/div/id-detected-objects/div/div/id-search/div/div/div[2]/button[2]"
    Then a page body should contains "/html/body/id-root/div/div/id-detected-objects/div/div/div/div"