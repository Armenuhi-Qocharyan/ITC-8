import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private String baseUrl;
    private WebDriver driver;
    
    public SeleniumTest() {
    }
    
    @Before
    public void setUp() {
        baseUrl = "https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fe-11-14e9d148bce691e989779d15e7b71223-86e7f37f97d88daf38faa442bd0ff5b361a23400";
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    
  
    @Test
    public void createGmail() {
        assertEquals("The page title should equal Google at the start of the test.", "Create your Google Account", driver.getTitle());
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"FirstName\"]"));
        searchField.sendKeys("Test");
        searchField = driver.findElement(By.xpath("//*[@id=\"LastName\"]"));
        searchField.sendKeys("Test");
        searchField = driver.findElement(By.xpath("//*[@id=\"GmailAddress\"]"));
        searchField.sendKeys(getRandomString(20));
        // Password
        searchField = driver.findElement(By.xpath("//*[@id=\"Passwd\"]"));
        String pass = getRandomString(10);
        searchField.sendKeys(pass);
        searchField = driver.findElement(By.xpath("//*[@id=\"PasswdAgain\"]"));
        searchField.sendKeys(pass);
        // Birthday
        searchField = driver.findElement(By.xpath("//*[@id=\"BirthMonth\"]/div[1]/div[2]"));
        searchField.click();
        searchField = driver.findElement(By.xpath("//*[@id=\":1\"]"));
        searchField.click();
        searchField = driver.findElement(By.xpath("//*[@id=\"BirthDay\"]"));
        searchField.sendKeys("10");
        searchField = driver.findElement(By.xpath("//*[@id=\"BirthYear\"]"));
        searchField.sendKeys("2000");
        // Gender
        searchField = driver.findElement(By.xpath("//*[@id=\"Gender\"]/div[1]"));
        searchField.click();
        searchField = driver.findElement(By.xpath("//*[@id=\":f\"]"));
        searchField.click();
        // Current email
        searchField = driver.findElement(By.xpath("//*[@id=\"RecoveryEmailAddress\"]"));
        searchField.sendKeys("testseleniumexample@gmail.com");
        // Press button
        searchField = driver.findElement(By.xpath("//*[@id=\"submitbutton\"]"));
        searchField.click();
        // I agree
        searchField = driver.findElement(By.xpath("//*[@id=\"tos-scroll-button\"]/div/img"));
        searchField.click();
        searchField.click();
        searchField = driver.findElement(By.xpath("//*[@id=\"iagreebutton\"]"));
        searchField.click();
        
    }
    
    public String getRandomString(int length) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }
    
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
