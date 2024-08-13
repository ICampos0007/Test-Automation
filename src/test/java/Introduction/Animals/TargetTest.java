package Introduction.Animals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TargetTest {

    @Test
    public void LogoIsVisibileTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.target.com/");
//        validate if target logo is visible
        System.out.println(driver.findElement(By.xpath("//a[@aria-label='Target home'][1]")).isDisplayed());
//        now click on deals
        driver.findElement(By.xpath("//a[@aria-label='Deals']")).click();
//        now click on Weekly AD
        driver.findElement(By.linkText("Weekly Ad")).click();
//        click on browse by categroy and  click electronics
        driver.findElement(By.xpath("//span[@class='nds_sc__btn-lbl']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Electronics (6)']")).click();

    }
}
