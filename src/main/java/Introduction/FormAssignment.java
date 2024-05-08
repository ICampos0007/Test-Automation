package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormAssignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        driver.findElement(By.name("name")).sendKeys("Miya");
        driver.findElement(By.name("email")).sendKeys("Miya@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Jaymee");
        driver.findElement(By.id("exampleCheck1")).click();
        driver.findElement(By.id("exampleFormControlSelect1")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']/option[2]")).click();
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("05241996");
        driver.findElement(By.xpath("//input[@class ='btn btn-success']")).click();

        Thread.sleep(2000);
        driver.quit();

    }
}
