@myforms
Feature: MyForms
    Background:
        Given Open "Google Chrome" browser with "http://localhost:4200/my-forms" url

    Scenario Outline: Tabs, menu and toolbar
        When Fill "<filed1>" element with "<value1>" value
        When Fill "<filed2>" element with "<value2>" value
        Then Click on "<button>" button
        Then navigate to <url> url
        Then Click form with <name> name
        Then Tab with name <name> will be opened
        Then Click Tab with current name should see data
         | IMForms | First Name, Last Name               |
         | Cucumber| First Name, Last Name, Email        |
         | Selenium| First Name, Last Name, Email, Phone |
        Then Click form with <name> name
        And Click on "<menu>" icon
        And Click on "<pdf>" icon
        Then Should be downloaded pdf which contains <name>
        Then Click on "<menu>" icon
        And Click on "<share>" icon
        Then Should be opened dialog with "<shareform>" title
        Then Enter email in field textarea
          | anun@gmail.com | email |
        And click on button
          | Share | btn |
        Then Should be opened toaster with text
          | toast-success |
        Then Click on "<menu>" icon
        And Click on "<edit>" icon
        Then Url Should be
          | http://localhost:4200/create-form |


      Examples:
            | filed1   | value1           | filed2 | value2    | button  | url                                | name                           | pdf            | menu | edit | share | shareform  |
            | username | email@gmail.com  | pass   | password0 | login   | "http://localhost:4200/my-forms"   | "IMForms, Cucumber, Selenium"  | picture_as_pdf | list | edit |shared| SHARE FORM |
