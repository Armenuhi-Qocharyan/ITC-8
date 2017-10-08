package com.itc.imforms;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class  MyForms {

    WebDriver driver = null;

    @Before("@myforms")
    public void init() {
    }

    @Given("^Open \"(.*?)\" browser with \"(.*?)\" url$")
    public void open_browser_with_url(String arg1, String arg2) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/liana/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get(arg2);
        driver.manage().window().maximize();
    }

    @When("^Fill \"(.*?)\" element with \"(.*?)\" value$")
    public void fill_element_with_value(String arg1, String arg2) throws Throwable {
        driver.findElement(By.id(arg1)).sendKeys(arg2);
    }

    @When("^\"(.*?)\" element with \"(.*?)\" value$")
    public void element_with_value(String arg1, String arg2) throws Throwable {
        driver.findElement(By.id(arg1)).sendKeys(arg2);
    }

    @Then("^Click on \"(.*?)\" button$")
    public void click_on_button(String arg1) throws Throwable {
        driver.findElement(By.name(arg1)).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlToBe("http://localhost:4200/home"));

    }

    @Then("^navigate to \"(.*?)\" url$")
    public void navigate_to_url(String arg1) throws Throwable {
        driver.get(arg1);

    }

    @Then("^Click form with \"(.*?)\" name$")
    public void click_form_with_name(String arg1) throws Throwable {
        String[] forms = arg1.split(", ");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        for (int i = 0; i < forms.length; ++i) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'item')]  [contains(text(),'" +forms[i]+ "')]")));
            driver.findElement(By.xpath("//div[contains(@class,'item')]  [contains(text(),'" + forms[i] + "')]")).click();
        }
    }

    @Then("^Tab with name \"(.*?)\" will be opened$")
    public void tab_with_name_will_be_opened(String arg1) throws Throwable {
        String[] forms = arg1.split(", ");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        for (int i = 0; i < forms.length; ++i) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'tab')]  [contains(text(),'" +forms[i]+ "')]")));
        }
    }

    @Then("^Click Tab with current name should see data$")
    public void click_Tab_with_current_name_should_see_data(List<List<String>> arg1) throws Throwable {
        for (List<String> list: arg1) {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            driver.findElement(By.xpath("//div[contains(@class,'item')]  [contains(text(),'" + list.get(0) + "')]")).click();
            String[] tabs =  list.get(1).split(", ");
            for (int i = 0; i < tabs.length; ++i) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'" +tabs[i]+ "')]")));
            }
        }
    }

    @Then("^Click on \"(.*?)\" icon$")
    public void click_on_icon(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'mat-icon')]  [contains(text(),'" + arg1 + "')]")));
        driver.findElement(By.xpath("//*[contains(@class,'mat-icon')]  [contains(text(),'" + arg1 + "')]")).click();
    }

    @Then("^Should be downloaded pdf which contains \"(.*?)\"$")
    public void should_be_downloaded_pdf_which_contains(String arg1) throws Throwable {
        String[] formName = arg1.split(", ");
        File dir = new File("/Users/liana/Downloads");
        File[] files = dir.listFiles();
        boolean flag = false;
        if (files == null || files.length == 0) {
            flag = false;
        }

        for (int i = 1; i < files.length; i++) {
            if(files[i].getName().contains(formName[formName.length - 1])) {
                flag=true;
            }
        }
        assertTrue(flag);
    }

    @Then("^Should be opened dialog with \"(.*?)\" title$")
    public void should_be_opened_dialog_with_title(String arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'titleForm')]  [contains(text(),'" + arg1 + "')]")));
    }

    @Then("^Enter email in field textarea$")
    public void enter_email_in_field_textarea(List<String> arg1) throws Throwable {
        WebElement element = driver.findElement(By.id(arg1.get(1)));
        element.sendKeys(arg1.get(0));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + arg1.get(0) + "')]")));
        driver.findElement(By.xpath("//a[contains(text(),'" + arg1.get(0) + "')]")).click();
    }

    @Then("^click on button$")
    public void click_on_button(List<String> arg1) throws Throwable {
        driver.findElement(By.xpath("//*[contains(@class," +arg1.get(1)+ ")] [contains(text(),'" + arg1.get(0) + "')]")).click();
    }

    @Then("^Should be opened toaster with text$")
    public void should_be_opened_toaster_with_text(List<String> arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, '" +arg1.get(0)+ "')]")));
    }

    @Then("^Url Should be$")
    public void url_Should_be(List<String> arg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlToBe(arg1.get(0)));
    }

    @After("@myforms")
    public void close() {
        driver.quit();
    }

}
