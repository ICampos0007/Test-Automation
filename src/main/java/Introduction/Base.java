package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot","Carrot"};

        addItems(driver,itemsNeeded,webDriverWait);



    }

    public static void addItems(WebDriver driver, String[] itemsNeeded, WebDriverWait webDriverWait) {
        int count = 0;


        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i =0; i <products.size(); i++) {
//            Cucumber - 1 Kg
//            format it to get the actual vegetable name
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
//            Check whether name you extracted is present in array
//            convert array to arrayList for easy search
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {
                count++;
//                click on add cart
                driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
                if (count == itemsNeeded.length) {
                    break;
                }
//                break;
            }
        }
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class = 'promoCode']")));
        driver.findElement(By.xpath("//input[@class = 'promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class = 'promoBtn']")).click();
//        explicit wait for specific element

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'promoInfo']")));
        System.out.println(driver.findElement(By.xpath("//span[@class = 'promoInfo']")).getText());
//        driver.quit();
    }
}
