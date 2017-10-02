package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.lang.InterruptedException;

public class WebDriverTest {
    private WebDriver driver;
    private String url;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
        url = "https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default";
    }
    @Test
    public void registerGmail() throws InterruptedException, NullPointerException {
        driver.get(url);
        driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys("newFirstName");    
        driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("newLastName");
        driver.findElement(By.xpath("//*[@id='GmailAddress']")).sendKeys("seleniumNewTest1@gmail.com");
        driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys("selenium1");
        driver.findElement(By.xpath("//*[@id='PasswdAgain']")).sendKeys("selenium1");
        driver.findElement(By.xpath("//*[@id='BirthDay']")).sendKeys("19");
        driver.findElement(By.xpath("//*[@id='BirthYear']")).sendKeys("1993");

        WebElement element=driver.findElement(By.xpath("//*[@id='BirthMonth']/div[1]/div[2]"));
        element.click();
        element = driver.findElement(By.xpath("//*[@id=':8']"));
        element.click();

        element = driver.findElement(By.xpath("//*[@id='Gender']/div[1]"));
        element.click();
        element = driver.findElement(By.xpath("//*[@id=':f']"));
        element.click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,250);");

        driver.findElement(By.xpath("//*[@id='RecoveryEmailAddress']")).sendKeys("albertaxajanyan@mail.ru");

        element = driver.findElement(By.xpath("//*[@id='submitbutton']"));
        element.click();
        for (int i = 0; i < 3; ++i) {
            element = driver.findElement(By.xpath("//*[@id='tos-scroll-button']"));
            element.click();
            Thread.sleep(1000);
        }

        element = driver.findElement(By.xpath("//*[@id='iagreebutton']"));
        element.click();

        Thread.sleep(7000);
    }
    @AfterTest
    public void quitBrowser() {
        driver.quit();
    }

}

