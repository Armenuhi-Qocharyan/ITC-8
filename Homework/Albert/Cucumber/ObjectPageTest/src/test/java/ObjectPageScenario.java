import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObjectPageScenario {
    
    private final WebDriver driver;

    public ObjectPageScenario() {
        this.driver = new ChromeDriver();
    }
    
    @Given("^the page is open \"([^\"]*)\"$")
    public void the_page_is_open(String page) throws Throwable {
    	driver.get(page);
    }

    @When("^I enter email \"([^\"]*)\"$")
    public void I_enter_email(String email) throws Throwable {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"inputEmail\"]"));
	element.sendKeys(email);
    }
        
    @When("^I enter password \"([^\"]*)\"$")
    public void I_enter_password(String password) throws Throwable {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"inputPassword\"]"));
	element.sendKeys(password);
    }
        
    @When("^I enter signin button")
    public void I_enter_signin_butoon() throws Throwable {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/button"));
	element.click();
    }
        
    @Then("^i navigate home page \"([^\"]*)\"$")
    public void i_navigate_home_page(String pageUrl) throws Throwable {
        System.out.println("url: " + pageUrl);
        System.out.println("drive : " + driver.getCurrentUrl());
        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains(pageUrl));
    }
    
}
