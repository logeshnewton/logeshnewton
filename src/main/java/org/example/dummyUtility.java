package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class dummyUtility {



    public void screenshot() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File disc=new File(System.getProperty("user.dir")+"/screenshot.png");
        FileUtils.copyFile(src,disc);
        driver.quit();

    }

    public void extentreportss(String filepath){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filepath);
        extentSparkReporter.config().setDocumentTitle("Automate");
        extentSparkReporter.config().setReportName("automation report");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Author", "Logesh");
        extentReports.setSystemInfo("Role", "QA");

        // Example test case
        ExtentTest test = extentReports.createTest("Sample Test Case");
        test.pass("Test passed successfully");

        // ✅ Important: Flush the report to write to the file
        extentReports.flush();

    }
}
