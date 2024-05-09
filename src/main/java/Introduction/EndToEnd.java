package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEnd {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value= 'DEL']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value = 'MAA']")).click();
        //        Calendar
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
            System.out.println("It's disabled.");
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }

        driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();

        //        same example using for loop instead for dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
//        currency dropdown
        Thread.sleep(2000);
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropDown = new Select(staticDropDown);
        Thread.sleep(2000);
        dropDown.selectByIndex(3);

//        submit button
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}
