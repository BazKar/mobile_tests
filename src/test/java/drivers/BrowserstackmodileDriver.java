package drivers;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class BrowserstackmodileDriver implements WebDriverProvider {
    @SneakyThrows
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", "kara_u1wIMW");
        mutableCapabilities.setCapability("browserstack.key", "gR5GjXw1n7Rw4soEXVRz");

        // Set app under test
        mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Set device and OS
        mutableCapabilities.setCapability("device", "Google Pixel 7 Pro");
        mutableCapabilities.setCapability("os_version", "13.0");

        // Set BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        AndroidDriver driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), mutableCapabilities);
        return null;
    }
}
