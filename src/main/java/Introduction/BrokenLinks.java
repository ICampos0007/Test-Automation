package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        SoftAssert softAssert = new SoftAssert();

        //        Broken URL
//        Step 1  Get all the URLS tied up to the links using selenium
//        Java methods will call URLs  and gets you the status code
//        if status code >400  then that urls is not working -> link which tied to url is broken
//        a[href*='soapui']

        WebElement footer =  driver.findElement(By.id("gf-BIG"));
        List<WebElement> links = footer.findElements(By.tagName("a"));
        for(WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            softAssert.assertTrue(respCode<400,"The link with text " + link.getText() + " is broken with code " + respCode);
        }
        softAssert.assertAll();
    }
}
