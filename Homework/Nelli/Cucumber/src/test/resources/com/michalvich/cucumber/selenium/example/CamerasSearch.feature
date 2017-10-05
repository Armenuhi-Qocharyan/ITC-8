Feature: Cameras
  As an user
  I want to search on cameras page
  So that I can see results

  Scenario: results are shown
    Given the page is open "http://localhost:4200/cameras"
    When I search for "Camera-11"
    Then a shown device name should contains "Camera-11"
    When bad search for "aaaa"
    Then I can't see any results


  Scenario: login
    When I click button by xpath "/html/body/id-root/div/div/id-header/header/nav/div/div[2]/ul[2]/a"
    Then I should navigate to "login" page
    When I fill the email and password "//*[@id='inputEmail']" "//*[@id='inputPassword']"
    And  I click button by xpath "/html/body/id-root/div/div/id-login/div/div/form/button"
    Then I should navigate to "home" page
    And I should care that login button's text is changed xpath "/html/body/id-root/div/div/id-header/header/nav/div/div[2]/ul[2]/a"
    
  Scenario: Edit and delete camera
    When I click button by xpath "/html/body/id-root/div/div/id-header/header/nav/div/div[2]/ul[1]/li[3]/a"
    Then I should navigate to "cameras" page
    Then I should see edit and delete buttons by xpath "/html/body/id-root/div/div/id-cameras/div/div[2]/div/div[3]/button[1]" "/html/body/id-root/div/div/id-cameras/div/div[2]/div/div[3]/button[2]"
    When I click button by xpath "/html/body/id-root/div/div/id-cameras/div/div[2]/div/div[3]/button[1]"
    Then I should see modal dialog  by xpath "//*[@id='myModal']"
    Then I fill xpath "/html/body/id-root/div/div/id-cameras/div/div[2]/id-edit-area/div/div/div/div[2]/div[1]/input"  values "Camera-1"  
    Then I fill xpath "(//*[@id='basic-url'])[1]"  values "20"
    Then I fill xpath "(//*[@id='basic-url'])[1]"  values "20"
    Then I fill xpath "/html/body/id-root/div/div/id-cameras/div/div[2]/id-edit-area/div/div/div/div[2]/div[2]/div[4]/input"  values "About camera 1" 