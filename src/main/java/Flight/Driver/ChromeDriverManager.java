package Flight.Driver;

import Flight.BaseTest.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        // TODO Auto-generated method stub
        ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-save-password-bubble");

        WebDriverManager.chromedriver().setup();  // Set up the ChromeDriver using WebDriverManager
        driver = new ChromeDriver(chromeOptions);

    }

    @Override
    protected void createWebDriver(boolean HeadlessMode) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(HeadlessMode ? "--headless" : "--no-headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-save-password-bubble");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

    }
}
