package com.itc.intrusion_detector;

import cucumber.annotation.en.Then;
import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateDeleteCameraScenario {

       private static WebDriver driver = CamerasSearchScenario.driver;

       @Then("^I should see edit and delete buttons by xpath \"([^\"]*)\" \"([^\"]*)\"$")
       public void I_should_see_edit_and_delete_buttons_by_xpath(String arg1, String arg2) throws InterruptedException {
          Thread.sleep(3000);
          Assert.assertTrue(driver.findElements(By.xpath(arg1)).size() != 0);
          Assert.assertTrue(driver.findElements(By.xpath(arg2)).size() != 0);
       }

       
       @Then("^I should see modal dialog  by xpath \"([^\"]*)\"$")
       public void I_should_see_modal_dialog_by_xpath(String arg1) {
           Assert.assertTrue(driver.findElements(By.xpath(arg1)).size() != 0);
       }
       
        @Then("^I fill xpath \"([^\"]*)\"  values \"([^\"]*)\"$")
        public void I_fill_xpath_values(String arg1, String arg2) {
            WebElement input = driver.findElement(By.xpath(arg1));
            input.clear();
            input.sendKeys(arg2);
        }
       
       @Then("^I check, that camera's information has changed xpath \"([^\"]*)\" expected result \"([^\"]*)\"$")
       public void I_check_that_camera_s_information_has_changed_xpath_expected_result(String arg1, String arg2) {
            WebElement element = driver.findElement(By.xpath(arg1));
            Assert.assertEquals(element.getText(),arg2);
        }
       
        @Then("^Camera was deleted$")
        public void Camera_was_deleted() {
           ArrayList<WebElement> cameras = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id=\'cam-area\']/div"));
           Assert.assertEquals(4, cameras.size());
        }
}
