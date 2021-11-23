package core;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LogListener implements ITestListener {

    private static final org.apache.log4j.Logger log = Logger.getLogger(LogListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("START TEST EXECUTION: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("TEST IS PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("TEST IS FAILED: " + result.getName());
        addScreenshotToReport();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("TEST IS SKIPPED: " + result.getName());
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] addScreenshotToReport() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
