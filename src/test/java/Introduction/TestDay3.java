package Introduction;

import com.beust.jcommander.Parameter;
import org.testng.annotations.*;

public class TestDay3 {
    @BeforeClass
    public void beforeClass() {
        System.out.println("before executing any methods in the class");
    }
    @Parameters({"URL","APIKey/username"})
    @Test
    public void webLogin(String urlname, String key) {
//    selenium
        System.out.println("Web login");
        System.out.println(urlname);
        System.out.println(key);
    }

    @Test(groups = {"Smoke"})
    public void mobileLogin() {
//    appium
        System.out.println("appium login");
    }
    @BeforeMethod
    public void beforeEveryTest() {
        System.out.println("I will execute before every test method in Test day 3 class");
    }
    @AfterMethod
    public void afterEveryTest() {
        System.out.println("I will execute after every test method in Test day 3 class");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("after executing all methods in the class");
    }
    @BeforeSuite
    public void bFsuite() {
        System.out.println("I am no 1");
    }
    @Test(enabled = false)
    public void mobileSignIn() {
//    appium
        System.out.println("appium login");
    }
    @Test(dataProvider = "getData")
    public void mobileSignOut(String username, String password) {
//    appium
        System.out.println("Mobile Signout");
        System.out.println(username);
        System.out.println(password);
    }
    @Test(dependsOnMethods = {"webLogin","mobileSignOut"})
    public void loginAPI() {
//        REST API automation
        System.out.println("API login");
    }
    @DataProvider
    public Object[][] getData() {
//        1st combination - username password good credit history
//        2nd username password no credit history
//        3rd fraudulent credit history
        Object[][] data = new Object[3][2];
//        1st set
        data[0][0] = "first username";
        data[0][1] = "password";
//        columns in the row are nothing but values for that particular combination(row)
//        2nd set
        data[1][0] = "second username";
        data[1][1] = "second password";
//        3rd set
        data[2][0] = "third username";
        data[2][1] = "third password";
        return data;
    }
}
