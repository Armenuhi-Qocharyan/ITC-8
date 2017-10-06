package com.itc.intrusion_detector;
import static com.itc.intrusion_detector.CamerasSearchScenario.driver;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.runtime.PendingException;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginationScenario {

	private static WebDriver driver = CamerasSearchScenario.driver;

        
        @Given("^all cameras count$")
        public void all_cameras_count() throws IOException {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("http://localhost:4300/api/v1/cameras");
            BasicHttpResponse httpResponse = (BasicHttpResponse) httpClient.execute(httpGet);
            // HttpEntity responseEntity = httpResponse.getEntity();
            System.out.println("=====================> " + httpResponse);
        }

        @Then("^Check pagination button's count$")
        public void Check_pagination_button_s_count() {
            
        }

        @Then("^Button is disable xpath \"([^\"]*)\"$")
        public void Button_is_disable_xpath(String arg1) {
           WebElement element = driver.findElement(By.xpath(arg1));
            
            /* try{
                WebDriverWait wait = new WebDriverWait(driver, 6);
                wait.until(ExpectedConditions.elementToBeClickable((By) element));
                
            }
            catch (Exception e){
                
            } */
            Assert.assertTrue(element.isDisplayed());
        }

        @Then("^Button is selected xpath \"([^\"]*)\"$")
        public void Button_change_Bachground_color_xpath(String arg1) throws InterruptedException {
            WebElement element = driver.findElement(By.xpath(arg1));
            // Assert.assertTrue(element.isSelected());
            // Assert.assertTrue(element.equals(driver.switchTo().activeElement()));
        }

        @Then("^Check cameras count in current page$")
        public void Check_cameras_count_in_current_page() {
            
        }
       
}
