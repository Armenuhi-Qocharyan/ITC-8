package com.itc.intrusion_detector;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.runtime.PendingException;
import org.openqa.selenium.WebDriver;

public class PaginationScenario {

	private static WebDriver driver = CamerasSearchScenario.driver;

        
        @Given("^all cameras count$")
        public void all_cameras_count() {
            // Express the Regexp above with the code you wish you had
            throw new PendingException();
        }

        @Then("^Check pagination button's count$")
        public void Check_pagination_button_s_count() {
            // Express the Regexp above with the code you wish you had
            throw new PendingException();
        }

        @Then("^Button is disable xpath \"([^\"]*)\"$")
        public void Button_is_disable_xpath(String arg1) {
            // Express the Regexp above with the code you wish you had
            throw new PendingException();
        }

        @Then("^Button change Bachground color \"([^\"]*)\" xpath \"([^\"]*)\"$")
        public void Button_change_Bachground_color_xpath(String arg1, String arg2) {
            // Express the Regexp above with the code you wish you had
            throw new PendingException();
        }

        @Then("^Check cameras count in current page$")
        public void Check_cameras_count_in_current_page() {
            // Express the Regexp above with the code you wish you had
            throw new PendingException();
        }
       
}
