import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import gherkin.formatter.model.Scenario;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObjectSearch {
    
    public static WebDriver driver = new ChromeDriver();
    private WebElement element;
    
    @Given("^the page is open \"([^\"]*)\"$")
    public void the_page_is_open(String page) throws Throwable {
    	driver.get(page);
    }

    @When("^I search object detected by \"([^\"]*)\"$")
    public void I_search_object_detected_by(String camera) throws Throwable {
	element = driver.findElement(By.xpath("/html/body/id-root/div/div/id-detected-objects/div/div/id-search/div/div/div[2]/input[1]"));
        element.clear();
	element.sendKeys(camera);
    }

    @When("^I enter type \"([^\"]*)\"$")
    public void I_enter_type(String type) throws Throwable {
        element = driver.findElement(By.xpath("/html/body/id-root/div/div/id-detected-objects/div/div/id-search/div/div/div[2]/input[2]"));
	element.clear();
        element.sendKeys(type);
    }
        
    @When("^I enter default date")
    public void I_enter_default_date() throws Throwable {
        element = driver.findElement(By.xpath("/html/body/id-root/div/div/id-detected-objects/div/div/id-search/div/div/div[2]/input[3]"));
	element.click();
        element = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button[1]"));
	element.click();
    }
        
    @When("^I click button \"([^\"]*)\"$")
    public void I_click_butoon(String xpath) throws Throwable {
        element = driver.findElement(By.xpath(xpath));
        Thread.sleep(300);
	element.click();
    }
    
            
    @When("^I open date picker \"([^\"]*)\"$")
    public void I_open_date_picker(String xpath) {
        element = driver.findElement(By.xpath(xpath));
	element.click();
    }
    
    @Then("^field \"([^\"]*)\" should contains \"([^\"]*)\"$")
    public void field_should_contains(String xpath, String value) {
        element = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(element.getText(), value);
    }
    
    @Then("^a input area \"([^\"]*)\" should contains \"([^\"]*)\"$")
    public void a_input_area_should_contains(String xpath, String value) {
        element = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(element.getAttribute("value"), value);
    }
        
    @Then("^a camera name should contains \"([^\"]*)\"$")
    public void a_camera_name_should_contains(String cameraName) throws Throwable {
        Thread.sleep(1000);
        element = driver.findElement(By.cssSelector("body > id-root > div > div > id-detected-objects > div > div > div > div:nth-child(1) > div > div > div.object-data.col-sm-4.col-sm-offset-1.col-xs-7.col-xs-offset-1 > span:nth-child(1)"));
        assertTrue(element.getText().contains(cameraName));
        Thread.sleep(1000);
    }
    
    @Then("^a page body should contains \"([^\"]*)\"$")
    public void a_page_body_should_contains(String xpath) throws InterruptedException {
        Thread.sleep(400);
        element = driver.findElement(By.xpath(xpath));
        Assert.assertTrue(element != null);
    }
        
}
