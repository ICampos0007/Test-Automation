package Introduction;

import org.testng.annotations.Test;

public class TestDay3 {
    @Test
    public void webLogin() {
//    selenium
        System.out.println("Web login");
    }

    @Test(enabled = false)
    public void mobileLogin() {
//    appium
        System.out.println("appium login");
    }
    @Test(enabled = false)
    public void mobileSignIn() {
//    appium
        System.out.println("appium login");
    }
    @Test(enabled = false)
    public void mobileSignOut() {
//    appium
        System.out.println("appium login");
    }
    @Test
    public void loginAPI() {
//        REST API automation
        System.out.println("API login");
    }
}
