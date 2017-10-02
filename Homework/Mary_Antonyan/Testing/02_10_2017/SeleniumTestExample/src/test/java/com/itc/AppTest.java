package com.itc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.InterruptedException;

public class AppTest extends TestCase {
    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testApp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/mary/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.name("identifier")).sendKeys("enter your email");

        driver.findElement(By.cssSelector("div[id='identifierNext']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("enter your password");

        driver.findElement(By.cssSelector("div[id='passwordNext']")).click();
        Thread.sleep(10000);

        driver.findElement(By.cssSelector("div[class='T-I J-J5-Ji T-I-KE L3']")).click();
        Thread.sleep(4000);

        driver.findElement(By.cssSelector("textarea[id=':ah']")).sendKeys("enter reciever");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("input[id=':a0']")).sendKeys("Selenium Test");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("div[id=':b1']")).sendKeys("Hello!");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("div[id=':9q']")).click();
        Thread.sleep(1000);

        driver.quit();
        assertTrue(true);
    }
}
