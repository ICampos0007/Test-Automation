package Introduction;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
//        switching window
        driver.switchTo().newWindow(WindowType.TAB);
        driver.getWindowHandles();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> id = windows.iterator();
        String parentId = id.next();
        String childId = id.next();
        driver.switchTo().window(childId);
        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.switchTo().window(parentId);
        WebElement nameInput = driver.findElement(By.name("name"));
        nameInput.sendKeys(courseName);
//        screenshot for specific element
//        File file = nameInput.getScreenshotAs(OutputType.FILE);
//        Files.copy(file,new File("logo.png"));

//        get height and width
        System.out.println(nameInput.getRect().getDimension().getHeight());
        System.out.println(nameInput.getRect().getDimension().getWidth());

    }
}
