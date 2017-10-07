import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.annotation.en.And;
import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;

public class ObjectPageScenario {
    
    public static WebDriver driver = new ChromeDriver();;
    private int countBefore;
    private int countAfter;
    public ObjectPageScenario() {
        this.countBefore = 0;
        this.countAfter = 0;
    }
    
    @Given("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String page) throws Throwable {
    	driver.get(page);
        Thread.sleep(500);

    }
    
    @When("^I click button by xpath \"([^\"]*)\"$")
    public void I_click_button_by_xpath(String buttonXpath) throws Throwable {
        WebElement clickedButton = driver.findElement(By.xpath(buttonXpath));
        clickedButton.click();
        Thread.sleep(500);
    }
    
    @Then("^I should navigate to \"([^\"]*)\" page$")
    public void i_should_navigate_to_page(String pageUrl) throws Throwable {
        Assert.assertEquals("http://localhost:4200/" + pageUrl, driver.getCurrentUrl());
        Thread.sleep(500);
    }
    @When("^I enter the email and password \"([^\"]*)\" \"([^\"]*)\"$")
    public void I_enter_the_email_and_password(String inputEmail, String inputPass) throws Throwable {
        WebElement emailPass = driver.findElement(By.xpath(inputEmail));
        emailPass.sendKeys("admin@mail.ru");
        Thread.sleep(500);
        emailPass = driver.findElement(By.xpath(inputPass));
        emailPass.sendKeys("Admin1");
        Thread.sleep(500);
    }
    
    @When("^I get object count \"([^\"]*)\"$")
    public void I_get_object_count(String beforeAfter) throws MalformedURLException, IOException, JSONException {
        String urlString = "http://localhost:4300/api/v1/objects";
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET"); // By default it is GET request
        int responseCode = con.getResponseCode();
        System.out.println("Sending get request : "+ url);
        System.out.println("Response code : "+ responseCode);
        // Reading response from input Stream
        BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();
        while ((output = in.readLine()) != null) {
         response.append(output);
        }
        in.close();
        //printing result from response
        if (beforeAfter.equals("before")) {
            this.countBefore = new JSONObject(response.toString()).getInt("count");
        } else {
            this.countAfter = new JSONObject(response.toString()).getInt("count");
        }
    }
    @Then("^the count of objects will decrease by one")
    public void the_count_of_objects_will_decrease_by_one() throws Throwable {
        Assert.assertEquals(this.countBefore-1, this.countAfter);
        Thread.sleep(100);
    }

    @Then("^I enter new type xpath \"([^\"]*)\" value \"([^\"]*)\"$")
    public void I_enter_new_type_xpath_value(String xpath, String values) throws Throwable {
        WebElement inputType = driver.findElement(By.xpath(xpath));
        inputType.clear();
        Thread.sleep(500);
        inputType.sendKeys(values);
        Thread.sleep(500);
    }
    
    @Then("^I must see \"([^\"]*)\" by xpath \"([^\"]*)\"$")
    public void I_must_see_this_result(String value, String xpath) {
        WebElement objType = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(objType.getText(),value);
    }
/*
    @When("^I click pagination button$")
    public void I_click_pagination_button() throws Throwable {
        ((JavascriptExecutor) driver).executeScript("scroll(0,500);");
        double pageNumber = (double)(this.countBefore/5.0) + 1.0;
        if (pageNumber > (int)pageNumber){
            pageNumber++;
        }
        System.out.println("tiv : " + pageNumber);
        Thread.sleep(500);

        WebElement clickedButton = driver.findElement(By.xpath("/html/body/id-root/div/div/id-detected-objects/div/div[1]/div/pagination-controls/pagination-template/ul/li[4]/div/span[2]"));
        clickedButton.click();
    }
*/
}
















