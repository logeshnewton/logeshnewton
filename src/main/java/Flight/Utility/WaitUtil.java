package Flight.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WaitUtil {

    public WebDriver driver;

    public WaitUtil(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement fluentWaitMethod(By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        return fluentWait.until(driver1 -> driver1.findElement(elementPath));

    }

    public List<WebElement> fluentWaitMethodFindElements(By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        return fluentWait.until(driver1 -> driver1.findElements(elementPath));
    }

    public WebElement fluentWaitMethodForFindBelow(WebElement webElement, By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        return fluentWait.until(driver1 -> driver1.findElement(RelativeLocator.with(elementPath).below(webElement)));

    }

    public WebElement fluentWaitMethodForFindNear(WebElement webelement, By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        return fluentWait.until(driver1 -> driver1.findElement(RelativeLocator.with(elementPath).near(webelement)));
    }

    public List<WebElement> fluentWaitMethodForFindBelowElements(WebElement webElement, By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        return fluentWait.until(driver1 -> driver1.findElements(RelativeLocator.with(elementPath).below(webElement)));
    }

    public WebElement fluentWaitMethodForFindRight(WebElement webElement, By elementPath) {

        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        return fluentWait.until(driver1 -> driver1.findElement(RelativeLocator.with(elementPath).toRightOf(webElement)));
    }

    public WebElement fluentWaitMethodForFindBelow(By webElementBy, By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElement(RelativeLocator.with(elementPath).below(webElementBy)));
    }

    public WebElement fluentWaitMethodFindElement(WebElement webElement, By elementPath) {
        Wait<WebElement> fluentWait = new FluentWait<>(webElement).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return fluentWait.until(element1 -> element1.findElement(elementPath));
    }

    public void explicitWaitUntilVisibility(By elementPath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementPath));
    }

    public void explicitWaitUntilPresenceOfElementLocated(By elementPath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(elementPath));
    }

    public void explicitWaitUntilPageLoad(){

        try{
            org.openqa.selenium.JavascriptExecutor jse = (org.openqa.selenium.JavascriptExecutor) driver;
            if(jse.executeScript("return document.readyState").toString().equals("complete")){
                try {
                    // fluentWaitMethod(By.xpath("//span[@class='close pointer']")).click();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void explicitWaitUntilClickable(By elementPath) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(elementPath));
    }

    public void explicitWaitUntilClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void threadWaitUntilElementInvisible(By elementPath) {
        try {
            int i = 1;
            WebElement element = driver.findElement(elementPath);
            while (i <= 1200) {
                if (element.isDisplayed()) {
                    Thread.sleep(100);
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void threadWaitUntilElementInvisible(By elementPath, int seconds) {
        try {
            int i = 1;
            fluentWaitMethod(elementPath);
            while (i <= seconds) {
                LocalDateTime myObj = LocalDateTime.now();
                //log.info(i + " : " + myObj);
                driver.findElement(elementPath);
                Thread.sleep(1000);
                i++;
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public void waitUntilElementInvisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitUntilElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementVisible(By elementPath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementPath));
    }

    public WebElement fluentWaitMethodForFindNear(By webElementBy, By elementPath) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElement(RelativeLocator.with(elementPath).near(webElementBy)));
    }

    public void waitForNewWindow(By elementPath) {
        String parent = null;
        String child = null;

        int i = 0;
        int max_Retry = 6;

        do {
            i++;

            try {
                Thread.sleep(1000);
                Set<String> handles = driver.getWindowHandles();
                Iterator<String> it = handles.iterator();

                parent = it.next();
                child = it.next();

                driver.switchTo().window(child);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.presenceOfElementLocated(elementPath));
                break;

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (!parent.equals(child) && i <= max_Retry);
    }





}
