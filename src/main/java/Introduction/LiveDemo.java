package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        click column
        driver.findElement(By.xpath("//th[@role = 'columnheader'][1]")).click();
//        capture all webelements into list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
//        capture text of all webelements into new(original) list
        List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
//        sort on original list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
//        compare original list vs sorted list
        Assert.assertEquals(originalList, sortedList);
//        Scan the name column with getText ->Beans->print the price of the Beans

        List<Object> price;
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
             price = rows.stream().filter(s->s.getText().contains("Rice"))
                    .map(s->getPriceVeggie(s)).collect(Collectors.toList());
            price.stream().forEach(System.out::println);
            if (price.size()<1) {
                driver.findElement(By.xpath("//a[@aria-label = 'Next']")).click();
            }
        } while (price.size()<1);

    }

    private static Object getPriceVeggie(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
