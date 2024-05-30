package Introduction;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener interface which implements Testng listeners
public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("I successfully executed Listeners pass code");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("I failed executed Listeners pass code " +result.getName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }
    @Override
    public void onStart(ITestContext context) {
    }
    @Override
    public void onFinish(ITestContext context) {
    }
}
