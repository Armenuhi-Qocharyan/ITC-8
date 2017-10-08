package com.itc.intrusion_detector;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginationScenario {

	private static WebDriver driver = CamerasSearchScenario.driver;
        private int camerasCount;
        
        @Given("^all cameras count$")
        public void all_cameras_count() throws IOException, ParseException {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("http://localhost:4300/api/v1/cameras");
            ResponseHandler<String> handler = new BasicResponseHandler();
            BasicHttpResponse httpResponse = (BasicHttpResponse) httpClient.execute(httpGet);
            // HttpEntity responseEntity = httpResponse.getEntity();
            String body = handler.handleResponse(httpResponse);
            int code = httpResponse.getStatusLine().getStatusCode();
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray)parser.parse(body);
            System.out.println("=====================> " + array.size() / 5);
            this.camerasCount = array.size();
        }

        @Then("^Check pagination button's count$")
        public void Check_pagination_button_s_count() {
            ArrayList<WebElement> pages = (ArrayList<WebElement>) driver.findElements(By.xpath("/html/body/id-root/div/div/id-cameras/pagination-controls/pagination-template/ul/li"));
               Assert.assertEquals((int)Math.floor(this.camerasCount / 5), pages.size() - 2);
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
