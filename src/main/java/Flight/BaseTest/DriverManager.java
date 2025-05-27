package Flight.BaseTest;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract void createWebDriver();
    protected abstract void createWebDriver(boolean HeadlessMode);

    public WebDriver getDriver(){
        if(driver == null){
            createWebDriver();
        }
        return driver;
    }

    public WebDriver getDriver(boolean HeadlessMode){
        if(driver == null){
            createWebDriver(HeadlessMode);
        }
        return driver;

    }
    public void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }


}
