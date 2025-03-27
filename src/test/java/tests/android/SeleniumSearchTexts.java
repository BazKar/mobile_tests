package tests.android;

import java.net.URL;
import java.util.List;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumBy;

import java.time.Duration;


public class SeleniumSearchTexts {
    @Test
    void successSearchTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your BrowserStack credentials
        caps.setCapability("browserstack.user", "kara_u1wIMW");
        caps.setCapability("browserstack.key", "gR5GjXw1n7Rw4soEXVRz");

        // Set app under test
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Set device and OS
        caps.setCapability("device", "Google Pixel 7 Pro");
        caps.setCapability("os_version", "13.0");

        // Set BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        // Initialize AndroidDriver
       
        AndroidDriver driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);

        // Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Find and click "Search Wikipedia"
        WebElement searchElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Search Wikipedia")));
        searchElement.click();

        // Find search input and enter text
        WebElement insertTextElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");

        Thread.sleep(5000);

        // Find all search results
        List<WebElement> allProductsName = driver.findElements(
                AppiumBy.className("android.widget.TextView"));

        assert(allProductsName.size() > 0);

        // Quit the driver
        driver.quit();
    }
}
