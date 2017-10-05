package com.itc.intrusion_detector;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.fail;
import org.openqa.selenium.Keys;

public class CamerasSearchScenario {

	public static WebDriver driver = new ChromeDriver();

	@Given("^the page is open \"([^\"]*)\"$")
	public void the_page_is_open(String page) throws Throwable {
            driver.get(page);
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	}

	@When("^I search for \"([^\"]*)\"$")
	public void I_search_for(String search) throws Throwable {
            WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"search\"]/form/input"));
            searchInput.clear();
            searchInput.sendKeys(search);
            Thread.sleep(1000);
	}

	@Then("^a shown device name should contains \"([^\"]*)\"$")
	public void a_camera_name_should_contains(String text) throws Throwable {
            ArrayList<WebElement> result = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id=\"cam-area\"]/div/div[2]/p[1]/b"));
            Assert.assertEquals(1, result.size());
            if(!result.get(0).getText().contains(text)) {
                fail("Search result are incorrect");
            }
            Thread.sleep(1000);
	}
      

	@Then("^I can't see any results$")
        public void I_can_t_see_any_results() {
            //throw new PendingException();
            ArrayList<WebElement> result = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id=\"cam-area\"]/div/div[2]/p[1]/b"));
            Assert.assertEquals(0, result.size());
        }

       
	@When("^I click button by xpath \"([^\"]*)\"$")
        public void I_click_login_button_by_xpath(String arg1) throws InterruptedException {
            Thread.sleep(1000);
            WebElement button = driver.findElement(By.xpath(arg1));
            button.click();
            Thread.sleep(1000);
        }

       
}
