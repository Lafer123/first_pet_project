package UI.WebDriverConfiguration;

import com.google.common.io.Resources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

    private static ChromeDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", Resources.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }
}
