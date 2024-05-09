package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Base {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/irvin/Desktop//selenium-server/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot","Carrot"};
        int j = 0;


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
                j++;
//                click on add cart
                driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;
                }
//                break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
