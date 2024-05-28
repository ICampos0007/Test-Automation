package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocator {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(By.name("name"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        WebElement dateOfBirth = driver.findElement(By.cssSelector("[for = 'dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();

        WebElement goLeft = driver.findElement(By.xpath("//label[@for= 'exampleCheck1']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(goLeft)).click();

        WebElement goRight = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(goRight)).getText());

    }
}
