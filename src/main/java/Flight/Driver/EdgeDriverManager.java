package Flight.Driver;

import Flight.BaseTest.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(edgeOptions);
    }

    @Override
    protected void createWebDriver(boolean HeadlessMode) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(HeadlessMode ? "--headless" : "--no-headless");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(edgeOptions);

    }
}
