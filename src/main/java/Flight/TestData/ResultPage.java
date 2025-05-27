package Flight.TestData;

import Flight.PageObject.Locators;
import Flight.Utility.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPage {

    Locators locators = new Locators();
    public WebDriver driver;
    public WaitUtil waitUtil;

    public ResultPage(WebDriver driver){
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    public void checkAssertion(String text){
        List<WebElement> BookNow = waitUtil.fluentWaitMethodFindElements(locators.BookNow);
        for(WebElement element : BookNow){
            String bookNowText = element.getText();
            assert bookNowText.equals(text);
        }


    }

}
