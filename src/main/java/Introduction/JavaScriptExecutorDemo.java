package Introduction;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;
//        this wall make it scroll down
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

//        Scroll inside the table
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> values = driver.findElements(By.xpath("//div[@class = 'tableFixHead'] /table/tbody/tr/td[4]"));
        int sum = 0;
        for (int i =0; i< values.size(); i++) {
            sum = sum + Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);

        String actual = driver.findElement(By.xpath("//div[@class = 'totalAmount']")).getText().split(":")[1].trim();

        Assert.assertEquals(sum,Integer.parseInt(actual));
    }
}
