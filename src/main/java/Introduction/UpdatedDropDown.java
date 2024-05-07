package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected(),"this should be false!");
//        System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
        driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected(),"This should be True!");
//        System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
//        count the number of checkboxes
        System.out.println(driver.findElements(By.cssSelector("input[type = 'checkbox']")).size());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        int count = 1;
        while (count < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            count += 1;
        }
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
//        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
//        same example using for loop instead
//        for (int i = 1; i < 5; i++) {
//            driver.findElement(By.id("hrefIncAdt")).click();
//        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        Thread.sleep(2000);
        driver.quit();

    }
}
