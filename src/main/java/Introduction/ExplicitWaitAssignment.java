package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ExplicitWaitAssignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

//        login in form
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("learning");
        driver.findElement(By.xpath("//label[@class = 'customradio'][2]")).click();

//        accept button
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();

//        select dropdown
        WebElement staticDropDown = driver.findElement(By.xpath("//select[@class = 'form-control']"));
        Select dropDown = new Select(staticDropDown);
        dropDown.selectByValue("consult");

//        agree to terms
        driver.findElement(By.id("terms")).click();

//        sign in button
        driver.findElement(By.id("signInBtn")).click();

//        Get the 4 specific phones list
        String[] itemsNeeded = {"iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry"};

//        add the items
        addCart(driver, Arrays.toString(itemsNeeded),webDriverWait);

//        click checkout button
        driver.findElement(By.xpath("//a[@class = 'nav-link btn btn-primary']")).click();
    }

    public static void addCart(WebDriver driver,String itemsNeeded, WebDriverWait webDriverWait) {
        int count = 0;
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4[@class='card-title']")));
        List<WebElement> products = driver.findElements(By.xpath("//h4[@class='card-title']"));
        for (int i =0; i< products.size(); i++) {
            List itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(itemsNeeded)) {
                count++;
                driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
                if (count == itemsNeeded.length()) {
                    break;
                }
            }

        }
    }
}



