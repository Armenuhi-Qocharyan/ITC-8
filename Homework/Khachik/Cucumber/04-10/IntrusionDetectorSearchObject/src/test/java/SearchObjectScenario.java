import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchObjectScenario {
    
    private final WebDriver driver;

    public SearchObjectScenario() {
        this.driver = new ChromeDriver();
    }
    
    @Given("^the page is open \"([^\"]*)\"$")
    public void the_page_is_open(String page) throws Throwable {
    	driver.get(page);
    }

    @When("^I search object detected by \"([^\"]*)\"$")
    public void I_search_object_detected_by(String camera) throws Throwable {
	WebElement element = driver.findElement(By.xpath("/html/body/id-root/div/div/id-detected-objects/div/div/id-search/div/div/div[2]/input[1]"));
	element.sendKeys(camera);
    }

    @When("^I enter type \"([^\"]*)\"$")
    public void I_enter_type(String type) throws Throwable {
        WebElement element = driver.findElement(By.xpath("/html/body/id-root/div/div/id-detected-objects/div/div/id-search/div/div/div[2]/input[2]"));
	element.sendKeys(type);
    }
        
    @When("^I enter default date")
    public void I_enter_default_date() throws Throwable {
        WebElement element = driver.findElement(By.xpath("/html/body/id-root/div/div/id-detected-objects/div/div/id-search/div/div/div[2]/input[3]"));
	element.click();
        element = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button[1]"));
	element.click();
    }
        
    @When("^I enter search button")
    public void I_enter_search_butoon() throws Throwable {
        WebElement element = driver.findElement(By.xpath("/html/body/id-root/div/div/id-detected-objects/div/div/id-search/div/div/div[2]/button[1]"));
	element.click();
    }
        
    @Then("^a camera name should contains \"([^\"]*)\"$")
    public void a_camera_name_should_contains(String cameraName) throws Throwable {
        WebElement element = driver.findElement(By.cssSelector("body > id-root > div > div > id-detected-objects > div > div > div > div:nth-child(1) > div > div > div.object-data.col-sm-4.col-sm-offset-1.col-xs-7.col-xs-offset-1 > span:nth-child(1)"));
        assertTrue(element.getText().contains(cameraName));
    }
    
}
