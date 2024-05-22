package Introduction;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Miscellaneous {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.manage().deleteCookieNamed("adsf");
        driver.get("https://google.com/");
//        take a screenshot using selenium
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src, new File("C:\\Users\\irvin\\screenshot.png"));
    }
}
