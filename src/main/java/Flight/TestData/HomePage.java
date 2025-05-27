package Flight.TestData;

import Flight.PageObject.Locators;
import Flight.Utility.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class HomePage {
    Locators locators1 = new Locators();

    public WebDriver driver;
    public WaitUtil waitUtil;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);


    }


    public void getLocation(String from) {
        String[] sd = from.split(",");
        String fromSector = sd[0];
        String toSector = sd[1];
        String FromDate = sd[2];
        String TODate = sd[3];
        getRoute(fromSector, toSector);
        getDate(FromDate,TODate);






    }

    public void getDate(String FromDate, String ToDate) {


        WebElement datepicker = waitUtil.fluentWaitMethod(locators1.FlightDepartureDatePicker);

        datepicker.click();
        String[] date = FromDate.split("-");
        String routeDate = date[0];
        String routeMonth = date[1];
        String routeYear = date[2];
        selectMonth(routeMonth);
        selectYear(routeYear);
        selectDate(routeDate);
        String[] ToDate1 = ToDate.split("-");
        String returnDate = ToDate1[0];
        String returnMonth = ToDate1[1];
        String returnYear = ToDate1[2];
        selectMonth(returnMonth);
        selectYear(returnYear);
        selectDate(returnDate);

    }

    public void getRoute(String name, String to) {
        WebElement From = waitUtil.fluentWaitMethod(locators1.FlightDaparture);
        setAirport(From, name);
        WebElement To = waitUtil.fluentWaitMethod(locators1.FlightReturn);
        setAirport(To, to);
    }

    public void setAirport(WebElement element, String keys) {

        waitUtil.explicitWaitUntilClickable(element);
        element.clear();
        element.sendKeys(keys);
        By spanText = By.xpath("//a[contains(text(),'" + keys + "')]");
        WebElement fromelement = waitUtil.fluentWaitMethodForFindNear(element, spanText);
        fromelement.click();
    }

    public void selectMonth(String Month) {


        WebElement month = waitUtil.fluentWaitMethod(locators1.FlightDepartureMonth);


        Select select = new Select(month);
        select.selectByVisibleText(Month);



    }

    public  String selectDate(WebDriver driver,String name,String Password) {





        // WebElement dd=driver
        WebElement date = driver.findElement(locators1.date);
        FluentWait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).ignoring(NoSuchElementException.class).
                pollingEvery(Duration.ofSeconds(20));
        waits.until(ExpectedConditions.visibilityOf(date));
        date.click();

        WebElement datepickertext = driver.findElement(locators1.datepicker);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(datepickertext));
        String text = datepickertext.getText();
        String[] ss = text.split(" ");
        String month = ss[0];
        String year = ss[1];
        String s = "25";

        while (datepickertext.isDisplayed()) {
            if (month.equals(name) || year.equals(Password)) {
                WebElement datenn = driver.findElement(By.xpath("//div[@class='react-datepicker__month']//div[contains(text(),'" + s + "')]"));
                datenn.click();
                break;
            } else {
                WebElement next = driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']"));
                next.click();
            }

        }
        return text;


    }

    public void selectYear(String year) {
        try {
            WebElement Year = waitUtil.fluentWaitMethod(locators1.FlightDepartureYear);
            Select select = new Select(Year);
            select.selectByVisibleText(year);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectDate(String Date) {
        try {
            List<WebElement> ll = driver.findElements(locators1.FlightDepartureDate);
            for (WebElement mm : ll) {
                String date = mm.getText().trim();
                if (date.equals(Date)) {
                    mm.click();
                    break;
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void submit(){
        WebElement submit = waitUtil.fluentWaitMethod(By.xpath("(//button[@class='c-button'])[2]"));
        submit.click();
    }
}


