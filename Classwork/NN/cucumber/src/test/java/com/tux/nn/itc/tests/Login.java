package com.tux.nn.itc.tests;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class  Login {


    @Before("@login")
    public void init() {
    }

    @Given("^Open \"(.*?)\" browser with \"(.*?)\" url$")
    public void open_browser_with_url(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    }

    @When("^Fill \"(.*?)\" element with \"(.*?)\" value$")
    public void fill_element_with_value(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    }

    @When("^\"(.*?)\" element with \"(.*?)\" value$")
    public void element_with_value(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    }

    @Then("^Click on \"(.*?)\" button$")
    public void click_on_button(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    }

    @Then("^Verify \"(.*?)\"$")
    public void verify(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    }
}