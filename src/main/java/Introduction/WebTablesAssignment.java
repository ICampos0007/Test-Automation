package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablesAssignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,400)");
//        number of columns
        System.out.println(driver.findElements(By.xpath("//table[@class = 'table-display']/tbody/tr/th")).size());

//        2nd row content
        System.out.println(driver.findElement(By.xpath("//table[@class = 'table-display']/tbody/tr[3]")).getText());

//        11 count with header and rows
        int sum = 0;
        int rows = driver.findElements(By.xpath("//table[@class = 'table-display']/tbody/tr/td[2]")).size();

        int headerCount = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th[2]")).size();

        sum = rows + headerCount;

        System.out.println(sum);
    }
}
