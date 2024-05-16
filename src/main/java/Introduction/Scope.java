package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
//        int count = 0;
//        List<WebElement> links = driver.findElements(By.xpath("//a"));
//        for (WebElement link : links) {
//            count++;
//        }
//        System.out.println(count);
        //give me the count of the links on the page
        int count = driver.findElements(By.xpath("//a")).size();
        System.out.println(count);
//        this limits the scope to just the footer of the page
//        count of the footer section
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
//        count of links in the first column
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

//        click on each link in the column and check if the pages are opening
//        starting at 1 because first link does not work
        for (int i =1; i<columnDriver.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000L);
        }
//            opens all tabs
        Set<String> windows=driver.getWindowHandles(); // 4
        Iterator<String> it = windows.iterator();
        while(it.hasNext()){
           String print = driver.switchTo().window(it.next()).getTitle();
           System.out.println(print);
        }


    }
}
