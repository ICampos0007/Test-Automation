package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
//        create web element variable to make it shorter for the action block of code optional.
        WebElement move = driver.findElement(By.xpath("//a[@id = 'nav-link-accountList']"));
//        moves to specific element
        actions.moveToElement(move).build().perform();

//        move to the search box
        actions.moveToElement(driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']"))).click()
                .doubleClick().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();

//        move back to the sign in
        actions.moveToElement(move).contextClick().build().perform();

    }
}
