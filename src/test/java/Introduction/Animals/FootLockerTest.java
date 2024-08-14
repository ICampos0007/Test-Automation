package Introduction.Animals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FootLockerTest {
    @Test
    public void SearchBarTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.footlocker.com/");

        driver.findElement(By.xpath("//input[@type='search'][1]")).sendKeys("jordans", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='SearchResults']/ul/li[2]")));
        driver.findElement(By.xpath("//div[@class='SearchResults']/ul/li[2]")).click();
        String Result = driver.findElement(By.xpath("//div[@class='Heading ProductName']/h1/span[1]")).getText();
        System.out.println(Result);
        Assert.assertEquals("Jordan Retro 4", Result);
        driver.findElement(By.xpath("//div[@class ='slick-slide slick-active'][2]")).click();
    }

//    @Test
//    public void AddShoeTest() {
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='SearchResults']/ul/li[2]")));
//        driver.findElement(By.xpath("//div[@class='SearchResults']/ul/li[2]")).click();
//    }
}
