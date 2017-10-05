package com.itc.intrusion_detector;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginScenario {

	private static WebDriver driver = CamerasSearchScenario.driver;

        @When("^I fill the email and password \"([^\"]*)\" \"([^\"]*)\"$")
        public void I_fill_the_email_and_password(String arg1, String arg2) {
            WebElement field = driver.findElement(By.xpath(arg1));
            field.sendKeys("admin@gmail.com");
            field = driver.findElement(By.xpath(arg2));
            field.sendKeys("Admin1");
        }

        @Then("^I should navigate to \"([^\"]*)\" page$")
        public void I_should_navigate_to_page(String page) {
            Assert.assertEquals("http://localhost:4200/" + page, driver.getCurrentUrl());
        }

        @Then("^I should care that login button's text is changed xpath \"([^\"]*)\"$")
        public void I_should_care_that_login_button_s_text_is_changed_xpath(String arg1) {
            WebElement loginButton = driver.findElement(By.xpath(arg1));
            Assert.assertEquals("logout", loginButton.getText());
        }
       
}
