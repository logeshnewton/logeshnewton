package data;

import Flight.BaseTest.DriverManager;
import Flight.BaseTest.DriverManagerFactory;
import Flight.PageObject.Locators;
import Flight.Utility.ConfigFileReader;
import Flight.Utility.PropertyFileReader;
import Flight.Utility.WaitUtil;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.example.dummyLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Saucedemo {

    WebDriver driver;
    Locators locators;
    public String argumentName;
    DriverManager driverManager;
    dummyLogin dummyLogin;
    PropertyFileReader propertyFileReader;
    WaitUtil waitUtil;
    ConfigFileReader configFileReader;

    @BeforeTest
    @Parameters({"browser", "headlessMode"})

    public void implementStructure(@Optional("CHROME") DriverManagerType browser, @Optional("false") boolean headlessmode) throws IOException {
        locators = new Locators();
        driverManager = DriverManagerFactory.getDrivermanager(browser);
        driver = driverManager.getDriver(headlessmode);
        propertyFileReader = new PropertyFileReader("flight/FlightTestCase");
        configFileReader=new ConfigFileReader();
        dummyLogin = new dummyLogin(driver);
        waitUtil = new WaitUtil(driver);


    }

    @Test (priority = 0)
    public void runBrowser() throws InterruptedException {
        driver.get(configFileReader.getProperty("testurl"));
        driver.manage().window().maximize();
        waitUtil.explicitWaitUntilPageLoad();

    }

    @Test(priority = 1,retryAnalyzer = Flight.Utility.TestRetry_Analyzer.class)
    public void sitechecking() throws InterruptedException {
        try {
            argumentName="result page";
            dummyLogin.selectLoginSites(driver, configFileReader.getProperty("username"), configFileReader.getProperty("password"));


            String resultpage_price = dummyLogin.results(configFileReader.getProperty("packagename"));


            dummyLogin.Shopsection();


            String firstnameProperty = configFileReader.getProperty("firstname");
            String lastnameProperty = configFileReader.getProperty("lastname");
            String zipcode = configFileReader.getProperty("zipcode");
            dummyLogin.PassengerDetails(firstnameProperty, lastnameProperty, zipcode);


            String availabilityprice = dummyLogin.CheckoutPageDetails();


            Assert.assertEquals(resultpage_price, availabilityprice);
            Assert.fail();


        } catch (Exception e) {
            System.out.println(e);

            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 2,retryAnalyzer = Flight.Utility.TestRetry_Analyzer.class)
    public void Final() {
        try {
            argumentName="Checkout Page";
            String text = dummyLogin.finishSegment();
            Assert.assertEquals(text, "kasjdkja");
        } catch (Exception e) {
            System.out.println(e);
            Assert.fail(e.getMessage());
        }
    }
}

