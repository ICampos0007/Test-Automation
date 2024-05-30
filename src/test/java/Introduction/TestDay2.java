package Introduction;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDay2 {
    @Test(groups = {"Smoke"})
    public void goodDemo() {
        System.out.println("Good");
    }
    @BeforeTest
    public void prerequisite() {
        System.out.println("I will execute first");
    }
}
