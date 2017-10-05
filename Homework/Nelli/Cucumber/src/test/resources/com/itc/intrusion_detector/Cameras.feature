Feature: Cameras
  As an user
  I want to search on cameras page
  So that I can see results

  Scenario: Search Camera
    Given the page is open "http://localhost:4200/cameras"
    When I search for "test"
    Then a shown device name should contains "test"
    When I search for "bdcbhfh"
    Then I can't see any results


  Scenario: login
    When I click button by xpath "/html/body/id-root/div/div/id-header/header/nav/div/div[2]/ul[2]/a"
    Then I should navigate to "login" page
    When I fill the email and password "//*[@id='inputEmail']" "//*[@id='inputPassword']"
    And  I click button by xpath "/html/body/id-root/div/div/id-login/div/div/form/button"
    Then I should navigate to "home" page
    And I should care that login button's text is changed xpath "/html/body/id-root/div/div/id-header/header/nav/div/div[2]/ul[2]/a"
    
  Scenario: Edit  camera
    When I click button by xpath "/html/body/id-root/div/div/id-header/header/nav/div/div[2]/ul[1]/li[3]/a"
    Then I should navigate to "cameras" page
    Then I should see edit and delete buttons by xpath "/html/body/id-root/div/div/id-cameras/div/div[2]/div/div[3]/button[1]" "/html/body/id-root/div/div/id-cameras/div/div[2]/div/div[3]/button[2]"
    When I click button by xpath "/html/body/id-root/div/div/id-cameras/div/div[2]/div/div[3]/button[1]"
    Then I should see modal dialog  by xpath "//*[@id='myModal']"
    Then I fill xpath "/html/body/id-root/div/div/id-cameras/div/div[2]/id-edit-area/div/div/div/div[2]/div[1]/input"  values "test"  
    Then I fill xpath "(//*[@id='basic-url'])[1]"  values "90"
    Then I fill xpath "(//*[@id='basic-url'])[2]"  values "100"
    Then I fill xpath "/html/body/id-root/div/div/id-cameras/div/div[2]/id-edit-area/div/div/div/div[2]/div[2]/div[4]/input"  values "About camera 1" 
    Then I click button by xpath "(//*[@id='myModal']/div/div/div[2]/div[3]/button[1])[1]"
    Then I check, that camera's information has changed xpath "(//*[@id='cam-area']/div/div[2]/p[1]/b)[1]" expected result "test"
    Then I check, that camera's information has changed xpath "(//*[@id='cam-area']/div/div[2]/p[3])[1]" expected result "Latitude       : 90"
    Then I check, that camera's information has changed xpath "(//*[@id='cam-area']/div/div[2]/p[4])[1]" expected result "Longitude    : 100"
    Then I check, that camera's information has changed xpath "(//*[@id='cam-area']/div/div[2]/p[5])[1]" expected result "Description  : About camera 1"
  
  Scenario: Delete camera
    When I click button by xpath "(//*[@id='cam-area']/div/div[3]/button[2])[1]"
    Then Camera was deleted 

  Scenario: Pagination
    Given all cameras count
    Then Check pagination button's count  
    And Button is disable xpath "" 
    When I click button by xpath ""
    Then Button change Bachground color "" xpath ""
    And Check cameras count in current page 





