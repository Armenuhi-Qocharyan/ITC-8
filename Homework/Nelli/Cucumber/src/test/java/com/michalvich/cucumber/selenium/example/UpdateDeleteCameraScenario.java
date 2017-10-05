package com.michalvich.cucumber.selenium.example;

import cucumber.annotation.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateDeleteCameraScenario {

	private static WebDriver driver = CamerasSearchScenario.driver;

       @Then("^I should see edit and delete buttons by xpath \"([^\"]*)\" \"([^\"]*)\"$")
       public void I_should_see_edit_and_delete_buttons_by_xpath(String arg1, String arg2) {
          Assert.assertTrue(driver.findElements(By.xpath(arg1)).size() != 0);
          Assert.assertTrue(driver.findElements(By.xpath(arg2)).size() != 0);
       }


       @Then("^I should see modal dialog$")
       public void I_should_see_modal_dialog(String arg1) {
          Assert.assertTrue(driver.findElements(By.xpath(arg1)).size() != 0);
       }
       
     
}
