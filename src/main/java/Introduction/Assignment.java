package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        driver.findElement(By.id("name")).sendKeys("Cozy");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(2000);
//        it accepts the alert.
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

//        alert cancel button
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        Thread.sleep(2000);
        driver.quit();
    }
}
