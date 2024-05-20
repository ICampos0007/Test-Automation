package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CalenderTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        String monthNumber = "6";
        String date = "15";
        String year = "2027";
        String[] expectedList = {monthNumber,date,year};

        driver.findElement(By.xpath("//a[@class = 'cart-header-navlink'][1]")).click();
        Set<String> windows = driver.getWindowHandles(); // [parentId, childId]
        Iterator<String> id = windows.iterator();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String parentId = id.next();
        String childId = id.next();
        driver.switchTo().window(childId);
        driver.findElement(By.xpath("//button[@class = 'react-date-picker__calendar-button react-date-picker__button']")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text() = '" +year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
        driver.findElement(By.xpath("//abbr[text() = '" +date+"']")).click();
        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for (int i = 0; i<actualList.size(); i++) {
            actualList.get(i).getAttribute("value");
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }

        driver.quit();

    }
}
