import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObjectPageScenario {
    
    private final WebDriver driver;
    private int countObj;
    public ObjectPageScenario() {
        this.driver = new ChromeDriver();
        this.countObj = 0;
    }
    
    @Given("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String page) throws Throwable {
    	driver.get(page);
    }
    
    @When("^I click button by xpath \"([^\"]*)\"$")
    public void I_click_button_by_xpath(String buttonXpath) throws Throwable {
        WebElement clickedButton = driver.findElement(By.xpath(buttonXpath));
        clickedButton.click();
        Thread.sleep(300);
    }
    
    @Then("^I should navigate to \"([^\"]*)\" page$")
    public void i_should_navigate_to_page(String pageUrl) throws Throwable {
        Assert.assertEquals("http://localhost:4200/" + pageUrl, driver.getCurrentUrl());
        Thread.sleep(500);
        if (driver.getCurrentUrl().equals("http://localhost:4200/detected")){
            ArrayList<WebElement> countObjList = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id=\"obj-area\"]/div/div"));
            this.countObj = countObjList.size();
        }
    }
    @When("^I enter the email and password \"([^\"]*)\" \"([^\"]*)\"$")
    public void I_enter_the_email_and_password(String inputEmail, String inputPass) {
        WebElement emailPass = driver.findElement(By.xpath(inputEmail));
        emailPass.sendKeys("admin@mail.ru");
        emailPass = driver.findElement(By.xpath(inputPass));
        emailPass.sendKeys("Admin1");
    }
    
    @Then("^the count of objects will decrease by one")
    public void the_count_of_objects_will_decrease_by_one() throws Throwable {
        ArrayList<WebElement> countObjList = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id=\"obj-area\"]/div/div"));
        Assert.assertEquals(this.countObj-1, countObjList.size());
    }
    
    @Then("^I enter new type xpath \"([^\"]*)\" value \"([^\"]*)\"$")
    public void I_enter_new_type_xpath_value(String xpath, String values) {
        WebElement inputType = driver.findElement(By.xpath(xpath));
        inputType.clear();
        inputType.sendKeys(values);
    }
    
    @Then("^I must see \"([^\"]*)\" by xpath \"([^\"]*)\"$")
    public void I_must_see_this_result(String value, String xpath) {
        WebElement objType = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(objType.getText(),value);
    }
}
















