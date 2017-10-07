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
    
    @Then("^I check whether the delet edit merge and slide buttons by xpath \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" is visible$")
    public void I_check_whether_the_delet_edit_and_merge_buttons_by_xpath_is_visible(String delete, String edit, String merge, String slide) throws Throwable {
        Assert.assertTrue(!driver.findElements(By.xpath(delete)).isEmpty());
        Assert.assertTrue(!driver.findElements(By.xpath(edit)).isEmpty());
        Assert.assertTrue(!driver.findElements(By.xpath(merge)).isEmpty());
        Assert.assertTrue(!driver.findElements(By.xpath(slide)).isEmpty());
        Thread.sleep(500);
    }
    @Then("^I check whether edit form by xpath \"([^\"]*)\"$")
    public void I_check_whether_edit_form_by_xpath(String editForm) throws Throwable {
        Assert.assertTrue(!driver.findElements(By.xpath(editForm)).isEmpty());
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
        if (beforeAfter.equals("before")) {
            this.countBefore = new JSONObject(response.toString()).getInt("count");
        } else {
            this.countAfter = new JSONObject(response.toString()).getInt("count");
        }
    }
    @Then("^the count of objects will decrease by one")
    public void the_count_of_objects_will_decrease_by_one() throws Throwable {
        Assert.assertEquals(this.countBefore-1, this.countAfter);
        Thread.sleep(300);
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

    @When("^I click pagination button$")
    public void I_click_pagination_button() throws Throwable {
        ((JavascriptExecutor) driver).executeScript("scroll(0,500);");
        double pageNumber = (double)(this.countBefore/5.0) + 1.0;
        pageNumber = pageNumber > (int)pageNumber ? ++pageNumber : pageNumber;
        pageNumber = (int)pageNumber > 9 ? 10 : (int)pageNumber;
        if (2 < (int)pageNumber) {
            Assert.assertTrue(!driver.findElements(By.xpath("/html/body/id-root/div/div/id-detected-objects/div/div[1]/div/pagination-controls/pagination-template/ul/li["+(int)pageNumber+"]/a/span[2]")).isEmpty());
            WebElement clickedButton = driver.findElement(By.xpath("/html/body/id-root/div/div/id-detected-objects/div/div[1]/div/pagination-controls/pagination-template/ul/li["+(int)pageNumber+"]/a/span[2]"));
            clickedButton.click();
        } else {
            Assert.assertTrue(driver.findElements(By.xpath("/html/body/id-root/div/div/id-detected-objects/div/div[1]/div/pagination-controls/pagination-template/ul/li["+(int)pageNumber+"]/a/span[2]")).isEmpty());
        }
        Thread.sleep(500);
    } 
    
    @Then("^end test$")
    public void end_test() throws Throwable {
        Thread.sleep(3000);
        driver.quit();
    }
    
}
















