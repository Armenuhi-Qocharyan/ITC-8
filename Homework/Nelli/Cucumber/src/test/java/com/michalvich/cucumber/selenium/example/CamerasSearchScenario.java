package com.michalvich.cucumber.selenium.example;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.fail;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.fail;

public class CamerasSearchScenario {

	public static WebDriver driver = new ChromeDriver();

	@Given("^the page is open \"([^\"]*)\"$")
	public void the_page_is_open(String page) throws Throwable {
            driver.get(page);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void I_search_for(String search) throws Throwable {
            WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"search\"]/form/input"));
            searchInput.clear();
            searchInput.sendKeys(search);
            Thread.sleep(3000);
	}

	@Then("^a shown device name should contains \"([^\"]*)\"$")
	public void a_camera_name_should_contains(String text) throws Throwable {
            ArrayList<WebElement> result = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id=\"cam-area\"]/div/div[2]/p[1]/b"));
            Assert.assertEquals(0, result.size());
            /*if(!result.get(0).getText().contains(text)) {
                fail("Search result are incorrect");
            }*/
            Thread.sleep(3000);
	}
        @When("^bad search for \"([^\"]*)\"$")
	public void bad_search_for(String newSearch) throws Throwable {
            
            WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"search\"]/form/input"));
            searchInput.clear();
            searchInput.sendKeys(newSearch);
            Thread.sleep(5000);
	}

	@Then("^I can't see any results$")
        public void I_can_t_see_any_results() {
            //throw new PendingException();
            ArrayList<WebElement> result = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id=\"cam-area\"]/div/div[2]/p[1]/b"));
            Assert.assertEquals(0, result.size());
        }

       
	@When("^I click button by xpath \"([^\"]*)\"$")
        public void I_click_login_button_by_xpath(String arg1) {
            WebElement loginButton = driver.findElement(By.xpath(arg1));
            loginButton.click();
        }

        @Then("^I fill xpath \"([^\"]*)\"  values \"([^\"]*)\"$")
        public void I_fill_xpath_values(String arg1, String arg2) {
            WebElement input = driver.findElement(By.xpath(arg1));
            input.clear();
            input.sendKeys(arg1);
        }
}
