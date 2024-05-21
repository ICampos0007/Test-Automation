package Introduction;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;
import java.util.Map;

public class SSLCheck {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        EdgeOptions edgeOptions = new EdgeOptions();
//        SafariOptions safariOptions = new SafariOptions();
        chromeOptions.setAcceptInsecureCerts(true);
//        firefoxOptions.setAcceptInsecureCerts(true);
//        edgeOptions.setAcceptInsecureCerts(true);
//        safariOptions.setAcceptInsecureCerts(true);
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        chromeOptions.setCapability("proxy", proxy);
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        chromeOptions.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(chromeOptions);
//        WebDriver fireFoxDriver = new FirefoxDriver(firefoxOptions);
//        WebDriver edgeDriver = new EdgeDriver(edgeOptions);
//        WebDriver safariDriver = new SafariDriver(safariOptions);
        driver.get("https://expired.badssl.com/");
//        fireFoxDriver.get("https://expired.badssl.com/");
//        edgeDriver.get("https://expired.badssl.com/");
//        safariDriver.get("https://expired.badssl.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
//        fireFoxDriver.getTitle();
//        edgeDriver.getTitle();
//        safariDriver.getTitle();

    }
}
