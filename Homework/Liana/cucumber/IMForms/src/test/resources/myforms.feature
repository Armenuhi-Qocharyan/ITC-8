Feature: Sidenav

    Scenario Outline: Open form
        Given forms list
        When form with classname "item" exist
        And I click the "div" with classname "item"
        Then will be opened "Tab"
        And "button" with "text" "list" will be shown

Feature: Toolbar

    Scenario Outline: Toolbar schedule button  should open dialog
        Given "button" with "text" "list"
        When "button" with "text" "list" clicked
        Then "button" with "text" "assessment" will be shown
        Then I click "button" with "text" "assesment"
        Then dialog with title "Generate schedule" should be opened
        Then I click "button" with  "text" "Cancel"
        Then dialog with title "Generate schedule" should be closed

    Scenario Outline:  Button pdf should download form as pdf
        Given "button" with "text" "list"
        When "button" with "text" "list" clicked
        Then "button" with "text" "picture_as_pdf" will be shown
        Then I click "button" with "text" "picture_as_pdf"
        Then pdf should be downloaded

    Scenario Outline: button share should open dialog
        Given "button" with "text" "list"
        When "button" with "text" "list" clicked
        Then "button" with "text" "shared" will be shown
        Then I click "button" with "text" "shared"
        Then dialog with title "SHARE FORM" should be opened
        Then I click button with text "Cancel"
        Then dialog with title "Share form" should be closed

    Scenario Outline: button "delete" should delete form from menu and tabs
        Given "button" with "text" "list"
        And sidenav with form names
        And area with tabs
        When I count forms in menu and in tab
        And "button" with "text" "list" clicked
        Then "button" with "text" "delete" should be shown
        Then I click "button" "text" "delete"
        Then dialog with title "DELETE" should be opened
        Then I click button with "text" "Yes"
        Then dialog with title "DELETE" should be closed
        And I count forms in menu and in tab
        Then forms count should be decreased by 1

    Scenario Outline: button message should open dialog with text fields
        Given "button" with "text" "list"
        When "button" with "text" "list" clicked
        Then "button" with "text" "email" will be shown
        Then I click "button" with "text" "email"
        Then dialog with title "SEND MESSAGE" should be opened
        Then I click "button" with "text" "Cancel"
        Then dialog with title "SEND MESSAGE" should be closed

    Scenario Outline: button edit should redirect to create form page for edit form
        Given "button" with "text" "list"
        When "button" with "text" "list" clicked
        Then "button" with "text" "edit" will be shown
        Then I click "button" with "text" "edit"
        Then I should be redirected to "create-form" page
        Then I return to "my forms" page

 Feature: Tabs

    Scenario Outline: Tabs should be activated when clicked
        Given forms list
        When form with classname "item" exist
        And I click the "div" with "classname" "item"
        Then will be opened "Tab"
        Then I click tab
        Then tab should be activated
