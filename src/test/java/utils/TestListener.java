package utils;

import org.testng.*;
import com.aventstack.extentreports.*;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    public void onTestStart(ITestResult r) {
        test = extent.createTest(r.getName());
    }

    public void onTestFailure(ITestResult r) {
        ScreenshotUtil.capture(r.getName());
        test.fail(r.getThrowable());
    }

    public void onFinish(ITestContext c) {
        extent.flush();
    }
}
