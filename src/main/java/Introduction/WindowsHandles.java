package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowsHandles {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class = 'blinkingText']")).click();
        Set<String> windows = driver.getWindowHandles(); // [parentId, childId]
        Iterator<String> id = windows.iterator();
        String parentId = id.next();
        String childId = id.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector("p[class = 'im-para red']")).getText());
        String emailId = driver.findElement(By.cssSelector("p[class = 'im-para red']")).getText().split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailId);
    }
}
