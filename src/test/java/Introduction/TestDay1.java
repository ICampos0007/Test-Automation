package Introduction;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestDay1 {
    @AfterTest
    public void lastExecution() {
        System.out.println("I will execute Last");
    }
    @Test
    public void demo() {
        System.out.println("Hello");
        Assert.assertTrue(false);
    }
    @AfterSuite
    public void aFSuite() {
        System.out.println("I am the no 1 from last");
    }
    @Test
    public void secondTest() {
        System.out.println("Bye");
    }
}
