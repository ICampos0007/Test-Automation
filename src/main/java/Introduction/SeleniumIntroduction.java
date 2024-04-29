package Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumIntroduction {
    public static void main(String[] args) {
//        Invoke the browser
//        WebDriver
//        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();

//        Firefox launch
//        Geckodriver
//        System.setProperty("webdriver.gecko.driver","C:/Users/irvin/Desktop//selenium-server/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        Microsoft Edge Driver
        System.setProperty("webdriver.edge.driver","C:/Users/irvin/Desktop//selenium-server/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
//

        driver.get("https://rahulshettyacademy.com/");
        driver.getTitle();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


        driver.close();

    }
}
