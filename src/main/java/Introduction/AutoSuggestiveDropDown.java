package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestiveDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000);
//        xpath way to find elements
//        List<WebElement> options = driver.findElements(By.xpath("//li[@class = 'ui-menu-item'] /a"));
        List<WebElement> options = driver.findElements(By.cssSelector("li[class = 'ui-menu-item'] a"));
                for(WebElement option : options) {
                    if (option.getText().equals("India")) {
                        option.click();
                        break;
                    }
                }
    }
}
