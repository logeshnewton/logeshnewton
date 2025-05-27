package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Visit {

    public static void main(String args[]) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://dss.com.sg/");

        driver.manage().window().maximize();





        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement kk=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Home')]")));

        WebElement ss=driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ss);

        ss.click();

        WebElement ms=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'iTravelKiosk')]")));

        Thread.sleep(5000);

        driver.close();
    }
}
