package org.example;

import Flight.PageObject.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.*;

public class dummyLogin {


    public Locators locators = new Locators();

    WebDriver driver;

    public dummyLogin(WebDriver driver) {
        this.driver = driver;
    }


    public static String selectLoginSites(WebDriver driver, String name, String Password) {
        WebElement login = driver.findElement(By.id("user-name"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(login));

        FluentWait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).ignoring(NoSuchElementException.class).
                pollingEvery(Duration.ofSeconds(20));
        waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Swag Labs')]")));


        WebElement title = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
        login.sendKeys(name);


        WebElement password = driver.findElement(By.xpath("//input[contains(@placeholder,'Password')]"));
        password.sendKeys(Password);

        String s = title.getText();

        WebElement submit = driver.findElement(By.id("login-button"));
        submit.click();


        return s;

    }


    public String results(String name) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        double sks = 0.00;
        List<WebElement> ss = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        int i = 0;

        String[] values = name.split(",");

        for (WebElement sk : ss) {
            String dd = sk.getText();
            for (String val : values) {

                if (dd.equals(val)) {
                    WebElement AddtoCart = driver.findElement(By.xpath("(//button[contains(text(),'Add to cart')])[" + (i + 1) + "]"));
                    AddtoCart.click();
                    WebElement priceElement = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[" + (i + 1) + "]"));
                    String Price = priceElement.getText();
                    double num = Double.parseDouble(Price.replace("$", ""));
                    sks += num;
                    System.out.println("kk" + Price);

                }
            }
            i++;
        }
        String LastPrice = String.format("$%.2f", sks);
        System.out.println(LastPrice);
        return LastPrice;
    }





    public void Shopsection() {

//        driver.switchTo().alert().accept();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement shop = driver.findElement(locators.shop);
        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(shop));
        shop.click();

        WebElement checkout = driver.findElement(locators.checkOut);
        FluentWait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        waits.until(ExpectedConditions.visibilityOf(checkout));
        checkout.click();
    }


    public void PassengerDetails(String firstname, String lastname, String zipcode) throws InterruptedException {


      /*  JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript()*/
        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);


        WebElement firstnames = driver.findElement(locators.FirstName);
        wait.until(ExpectedConditions.visibilityOf(firstnames));
        firstnames.sendKeys(firstname);


        WebElement lastnames = driver.findElement(locators.LastName);
        wait.until(ExpectedConditions.visibilityOf(lastnames));
        lastnames.sendKeys(lastname);

        WebElement zipcodes = driver.findElement(locators.Zipcode);
        wait.until(ExpectedConditions.visibilityOf(zipcodes));
        zipcodes.sendKeys(zipcode);

        WebElement continues = driver.findElement(locators.Continue);
        wait.until(ExpectedConditions.visibilityOf(continues));
        continues.click();
    }



    public String CheckoutPageDetails(){

            WebElement itemTotals=driver.findElement(locators.itemTotal);
            String splits=itemTotals.getText();
            String[]  pricesplit=splits.split(" ");
            String totalamountwithoutTax=pricesplit[2];
            double itemTotalamount=Double.parseDouble(totalamountwithoutTax.replace("$",""));
            System.out.println(itemTotalamount);


            WebElement TaxElement= driver.findElement(locators.Tax);
            String Taxsplits=TaxElement.getText();
            String[] taxAmountSplit=Taxsplits.split(" ");
            String taxAmountwithoutfare=taxAmountSplit[1];
            double taxamountprice=Double.parseDouble(taxAmountwithoutfare.replace("$",""));
            System.out.println(taxamountprice);


            double firsttotalamount=itemTotalamount+taxamountprice;
            String firstTotalfareamount=String.format("$%.2f",firsttotalamount);
            System.out.println(firstTotalfareamount);


            return firstTotalfareamount;
        }


    public String finishSegment() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement finish = driver.findElement(locators.Finish);
        finish.click();


        WebElement successMessage = driver.findElement(locators.SuccessMessage);
        String SusMessage = successMessage.getText();
        return SusMessage;
    }




    public String getProperty(String key) throws IOException {
        FileInputStream fis = new FileInputStream("test_data//" +"flight/FlightTestCase.properties");
        Properties properties= new Properties();
        properties.load(fis);
        return properties.getProperty(key);
    }





   /* public static void main(String[] args) throws IOException, InterruptedException {

            dummyLogin dummy = new dummyLogin();
          //  dummy.runBrowser();




         String nameProperty=   dummy.getProperty("username");
         String passwordProperty=   dummy.getProperty("password");
         String packagenameProprty=dummy.getProperty("packagename");
         String firstnameProperty= dummy.getProperty("firstname");
         String lastnameProperty=dummy.getProperty("lastname");
         String zipcode=dummy.getProperty("zipcode");





        System.out.println(selectLoginSites(WebDriver driver,nameProperty,passwordProperty));
        dummy.results(packagenameProprty);
        dummy.shop(firstnameProperty,lastnameProperty,zipcode);
        dummy.finishSegment();







    }*/




}

