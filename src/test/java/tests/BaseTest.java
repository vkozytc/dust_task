package tests;

import com.codeborne.selenide.Configuration;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public class BaseTest {

    private static final Logger log = Logger.getLogger(BaseTest.class);

    @BeforeSuite
    public void start() {
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        Configuration.browserVersion = "83.0";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        Configuration.browserCapabilities = new DesiredCapabilities();
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @AfterSuite
    public void finish() {
        log.info("ALL TESTS ARE COMPLETED !!!");
    }

    @AfterMethod
    public void clearCookies() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }
}
