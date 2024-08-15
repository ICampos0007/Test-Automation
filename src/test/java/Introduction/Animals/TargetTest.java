package Introduction.Animals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TargetTest {

    @Test
    public void LogoIsVisibileTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.target.com/");
        String ItemName = "Bose SoundLink Revolve Plus II Portable Bluetooth Speaker - Gray";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        validate if target logo is visible
        System.out.println(driver.findElement(By.xpath("//a[@aria-label='Target home'][1]")).isDisplayed());
//        now click on deals
        driver.findElement(By.xpath("//a[@aria-label='Deals']")).click();
//        now click on Weekly AD
        driver.findElement(By.linkText("Weekly Ad")).click();
//        click on browse by categroy and  click electronics
        driver.findElement(By.xpath("//span[@class='nds_sc__btn-lbl']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Electronics (6)']")));
        driver.findElement(By.xpath("//a[@aria-label='Electronics (6)']")).click();
        driver.findElement(By.id("page-20")).click();
//        get all the electronics promo deals
        List<WebElement> promoDeals = driver.findElements(By.xpath("//div[@data-test='promo-card']"));
        System.out.println(promoDeals.size());
//       print all the promo deals
        for (WebElement promoDeal: promoDeals) {
            System.out.println(promoDeal.getText());
        }
        int randomIntIWantToClick = 1;

        for (int i = 0; i < promoDeals.size(); i++) {
            if (i == randomIntIWantToClick) {
                // Find the button within the specific promo deal and click it
                WebElement button = promoDeals.get(i).findElement(By.xpath(".//button[@type='button']"));
                button.click();
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label*='Add Bose SoundLink']")));
//            now add it to cart
        driver.findElement(By.cssSelector("button[aria-label*='Add Bose SoundLink']")).click();
//            now change the color of the item
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Carousel']/ul/li[2]")));
        driver.findElement(By.xpath("//div[@aria-label='Carousel']/ul/li[2]")).click();
//            now finally add it to cart.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='styles__ThreeUpButtonWrapper-sc-11rka0i-0 gfFifD']")));
        driver.findElement(By.xpath("//div[@class='styles__ThreeUpButtonWrapper-sc-11rka0i-0 gfFifD']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='styles__StyledHeading-sc-1awz1yh-0 gonTex']")));
        String actualName = driver.findElement(By.xpath("//h4[@class='styles__StyledHeading-sc-1awz1yh-0 gonTex']")).getText();
        Assert.assertEquals(ItemName,actualName);
//        decline the coverage
        driver.findElement(By.xpath("//div[@class='h-margin-t-default']/button[2]")).click();
    }
}
