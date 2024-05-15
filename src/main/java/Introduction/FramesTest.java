package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
//        driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class = 'demo-frame']")));
//        driver.findElement(By.id("draggable")).click();
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(source,target).build().perform();
//        switches back from the iframe to the current webpage
        driver.switchTo().defaultContent();
    }
}
