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
    And I click button by xpath "/html/body/id-root/div/div/id-login/div/div/form/button"
    Then I should navigate to "home" page

  Scenario: Test Detected Object page
    When I click button by xpath "/html/body/id-root/div/div/id-header/header/nav/div/div[2]/ul[1]/li[2]/a"
    Then I should navigate to "detected" page
    Then I check whether the delet edit merge and slide buttons by xpath "/html/body/id-root/div/div/id-detected-objects/div/div[1]/div/div[1]/div/div/div[2]/button[1]" "/html/body/id-root/div/div/id-detected-objects/div/div[1]/div/div[1]/div/div/div[2]/button[2]" "/html/body/id-root/div/div/id-detected-objects/div/button" "/html/body/id-root/div/div/id-detected-objects/div/div[1]/div/div[1]/div/div/div[2]/button[3]" is visible 

  Scenario: Test delete object
    When I get object count "before"
    And I click button by xpath "/html/body/id-root/div/div/id-detected-objects/div/div[1]/div/div[1]/div/div/div[2]/button[1]"
    And I get object count "after"
    Then the count of objects will decrease by one

  Scenario: Test edit object
    When I click button by xpath "/html/body/id-root/div/div/id-detected-objects/div/div[1]/div/div[1]/div/div/div[2]/button[2]"
    Then I check whether edit form by xpath "//*[@id='edit']/div/div/form"
    Then I enter new type xpath "//*[@id='edit']/div/div/form/div[1]/div/div[1]/input" value "car"
    And I click button by xpath "//*[@id='edit']/div/div/form/div[2]/button[1]"
    Then I must see "car" by xpath "/html/body/id-root/div/div/id-detected-objects/div/div[1]/div/div[1]/div/div/div[1]/h6[1]"

  Scenario: Test merge object
    When I get object count "before"
    And I click button by xpath "/html/body/id-root/div/div/id-detected-objects/div/div[1]/div/div[1]/div/div/div[3]/label"
    And I click button by xpath "/html/body/id-root/div/div/id-detected-objects/div/div[1]/div/div[2]/div/div/div[3]/label"
    And I click button by xpath "/html/body/id-root/div/div/id-detected-objects/div/button"
    And I click button by xpath "//*[@id='myModal']/div/div/form/div[2]/button[1]"
    And I get object count "after"
    Then the count of objects will decrease by one

  Scenario: Test pagination
    When I get object count "before"
    And I click pagination button

  Scenario: Test end
    Then end test





 

