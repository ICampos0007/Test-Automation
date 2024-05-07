package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAssignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id = 'checkBoxOption1']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@id = 'checkBoxOption1']")).isSelected());
        driver.findElement(By.xpath("//input[@id = 'checkBoxOption1']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@id = 'checkBoxOption1']")).isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type = 'checkbox']")).size());

    }
}
