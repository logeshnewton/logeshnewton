package Flight.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

    static ExtentReports extent;
    static ConfigFileReader configFileReader;

    public static synchronized ExtentReports getReportObject() {
        configFileReader = new ConfigFileReader();
        String path = configFileReader.getBaseDir() + "/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("ClarityTTS Test Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Logesh Vivegananthan");
        return extent;

    }
}
