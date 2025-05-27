import Flight.BaseTest.DriverManager;
import Flight.BaseTest.DriverManagerFactory;
import Flight.TestData.HomePage;
import Flight.TestData.ResultPage;
import Flight.Utility.PropertyFileReader;
import Flight.Utility.WaitUtil;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GBAFlightHomePage {


    public WebDriver driver;
    public HomePage homepage;
    public DriverManager driverManager;
    public PropertyFileReader propertyFileReader;
    public WaitUtil waitUtil;
    public ResultPage resultpage;

    @BeforeTest
    @Parameters({"browser", "headlessMode"})
    public void openDriver(@Optional("CHROME") DriverManagerType browser, @Optional("false") boolean headlessmode) throws IOException {

        try {
            propertyFileReader = new PropertyFileReader("flight/FlightTestCase");

            driverManager = DriverManagerFactory.getDrivermanager(browser);
            driver = driverManager.getDriver(headlessmode);
            homepage = new HomePage(driver);
            resultpage = new ResultPage(driver);
            waitUtil = new WaitUtil(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(propertyFileReader.getProperty("implicitlyWait")), TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
@Test(priority = 0)
    public void homepages(){
        try{
            driver.get(propertyFileReader.getProperty("url"));
            waitUtil.explicitWaitUntilPageLoad();
            homepage.getLocation(propertyFileReader.getProperty("Sector"));

            homepage.submit();
        } catch (Exception e) {
           Assert.fail(e.getMessage());
        }


    }
    @Test(priority = 1)
    public void resultPages() throws InterruptedException {
        Thread.sleep(10000);
        waitUtil.explicitWaitUntilPageLoad();
        resultpage.checkAssertion("BookNow");
    }
  /*  @AfterTest
    public void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }*/
}
