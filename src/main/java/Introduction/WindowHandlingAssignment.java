package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandlingAssignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        click the multiple window link
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        driver.findElement(By.xpath("//a[text() = 'Click Here']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> id = windows.iterator();
        String parentId = id.next();
        driver.switchTo().window(id.next());
        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());

    }
}
