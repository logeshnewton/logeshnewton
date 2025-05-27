package Flight.Driver;

import Flight.BaseTest.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(firefoxOptions);
    }

    @Override
    protected void createWebDriver(boolean HeadlessMode) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(HeadlessMode ? "--headless" : "--no-headless");
        firefoxOptions.addArguments("--disable-gpu", "window-size=1920,1200", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(firefoxOptions);

    }
}
