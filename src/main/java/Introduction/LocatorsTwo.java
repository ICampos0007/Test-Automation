package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LocatorsTwo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String password = getPassword(driver);
        String name = "rahul";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),"Hello " + name + ",");
        driver.findElement(By.xpath("//button[@class = 'logout-btn']")).click();
//        xpath by text
//        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        Thread.sleep(2000);
        driver.quit();


    }
    public static String getPassword(WebDriver driver) throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
//        Please use temporary password 'rahulshettyacademy' to Login.
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String[] passwordArray = passwordText.split("'");
        String password = passwordArray[1].split("'")[0];
        return password;
    }
}
