package UI.WebDriverConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public static WebDriver getWebDriver(WebDriverEnumeration enumeration) {
        switch (enumeration) {
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME:
            default:
                return getChromeDriver();
        }
    }

    private static WebDriver getChromeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(CapabilityType.VERSION, "87.0");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Linux");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "87.0");
        capabilities.setCapability("enableLog", true);
        capabilities.setCapability("timeZone", "Europe/Moscow");
        capabilities.setCapability("sessionTimeout", "1m");
        WebDriver driver = null;
        try {
             driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
