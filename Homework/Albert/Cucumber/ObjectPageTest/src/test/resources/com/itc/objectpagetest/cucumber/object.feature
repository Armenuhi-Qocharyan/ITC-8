Feature: Test detected objects page
  Test when input valid email and password navigate to home page
  Test delete object
  Test edit object
  Test merge object

  Scenario: Test login
    Given I navigate to "http://localhost:4200/home"
    When I click button by xpath "/html/body/id-root/div/div/id-header/header/nav/div/div[2]/ul[2]/a"
    Then I should navigate to "login" page
    When I enter the email and password "//*[@id='inputEmail']" "//*[@id='inputPassword']"
    And  I click button by xpath "/html/body/id-root/div/div/id-login/div/div/form/button"
    Then I should navigate to "home" page
    When I click button by xpath "/html/body/id-root/div/div/id-header/header/nav/div/div[2]/ul[1]/li[2]/a"
    Then I should navigate to "detected" page

    When I click button by xpath "//*[@id='obj-area']/div/div/div[2]/button[1]"
    Then the count of objects will decrease by one

    When I click button by xpath "//*[@id='obj-area']/div/div/div[2]/button[2]"
    Then I enter new type xpath "//*[@id='edit']/div/div/form/div[1]/div/div[1]/input" value "car"
    And I click button by xpath "//*[@id='edit']/div/div/form/div[2]/button[1]"
    Then I must see "car" by xpath "//*[@id='obj-area']/div/div/div[1]/h6[1]"
 

