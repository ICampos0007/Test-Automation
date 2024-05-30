package Introduction;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDay4 {
    @Parameters({"URL"})
    @Test
    public void webLoginHome(String uname) {
//    selenium
        System.out.println("Web login home");
        System.out.println(uname);
    }

    @Test(groups = {"Smoke"})
    public void mobileLoginHome() {
//    appium
        System.out.println("appium login home");
    }
    @Test
    public void loginAPIHome() {
//        REST API automation
        System.out.println("API login home");
    }
}
