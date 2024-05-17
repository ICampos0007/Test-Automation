package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class PracticeAssignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        clicks option 2 checkbox
        driver.findElement(By.id("checkBoxOption2")).click();
//        this stores the text into the variable wordValue
        String wordValue = driver.findElement(By.xpath("//label[@for = 'benz']")).getText();
//        prints it to check if the text is correct
        System.out.println(wordValue);
        WebElement staticDropDown = driver.findElement(By.id("dropdown-class-example"));
        Select dropDown = new Select(staticDropDown);
//        selects the same option as the checkbox using the wordValue
        dropDown.selectByVisibleText(wordValue);
//        typing our wordValue into the box
        driver.findElement(By.id("name")).sendKeys(wordValue);
//        clicks the alert button
        driver.findElement(By.id("alertbtn")).click();
//        gets the text of the alert
        String[] alertText =driver.switchTo().alert().getText().split("Hello")[1].split(",");
//        String formattedText = alertText[1].split(",");
        System.out.println(alertText[0].trim());

    }
}
