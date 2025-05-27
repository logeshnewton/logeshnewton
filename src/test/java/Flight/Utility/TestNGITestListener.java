package Flight.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGITestListener extends ScreenShot implements ITestListener {


    ExtentReports extentReports = ExtentReporter.getReportObject();
    ExtentTest extentTest;
    ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        extentTestThread.set(extentTest);
        System.out.println("New Test Started " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        WebDriver clientDriver = null;
        String argumentName = null;
        String testMethodName = result.getMethod().getMethodName();
        System.out.println("Test Successfully Finished " + result.getName());

        try {
            clientDriver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("clientDriver")
                    .get(result.getInstance());
            argumentName = (String) result.getTestClass().getRealClass().getDeclaredField("argumentName")
                    .get(result.getInstance());
            argumentName = argumentName.replaceAll("[^a-zA-Z0-9]", "_");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {

            String imgFileName = takeScreenSnapShotWithFullPage(clientDriver, argumentName);
            extentTestThread.get().log(Status.PASS, "Test Case Method <b style=\"color:Tomato\"> "
                    + argumentName + " </b> executed successfully and working as expected");

            System.out.println("Image File Name " + argumentName);
            extentTestThread.get().addScreenCaptureFromPath(imgFileName, testMethodName);

        } catch (Exception e) {
            System.out.println("Error message user " + e.getMessage());
        }
    }



    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = extentTestThread.get();
        if (test == null) {
            test = extentReports.createTest(result.getMethod().getMethodName());
            extentTestThread.set(test);
        }

        test.fail(result.getThrowable());

        WebDriver clientDriver = null;
        String argumentName = null;
        String testMethodName = result.getMethod().getMethodName();

        try {
            clientDriver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
                    .get(result.getInstance());

            argumentName = (String) result.getTestClass().getRealClass().getDeclaredField("argumentName")
                    .get(result.getInstance());

            argumentName = "failed_" + argumentName.replaceAll("[^a-zA-Z0-9]", "_");

            if (clientDriver != null) {
                String imgFileName = takeScreenShot(clientDriver, argumentName);
                test.addScreenCaptureFromPath(imgFileName, testMethodName);
                System.out.println("📸 Screenshot captured: " + imgFileName);
            } else {
                System.out.println("⚠️ WebDriver is null — screenshot skipped");
            }

        } catch (Exception e) {
            System.out.println("⚠️ Exception in onTestFailure: " + e.getMessage());
        }
    }
   /* public void onTestFailure(ITestResult result) {
        ExtentTest test = extentTestThread.get();
        if (test == null) {
            test = extentReports.createTest(result.getMethod().getMethodName());
            extentTestThread.set(test);
        }

        test.fail(result.getThrowable());  // Log the exception properly

        WebDriver clientDriver = null;
        String argumentName = null;
        String testMethodName = result.getMethod().getMethodName();

        System.out.println("❌ Test Failure Listener Invoked: " + testMethodName);

        try {
            clientDriver = (WebDriver) result.getTestClass()
                    .getRealClass()
                    .getDeclaredField("clientDriver")
                    .get(result.getInstance());

            argumentName = (String) result.getTestClass()
                    .getRealClass()
                    .getDeclaredField("argumentName")
                    .get(result.getInstance());

            argumentName = "failed_" + argumentName.replaceAll("[^a-zA-Z0-9]", "_");

            String imgFileName = takeScreenSnapShotWithFullPage(clientDriver, argumentName);
            test.addScreenCaptureFromPath(imgFileName, testMethodName);
        } catch (Exception e) {
            System.out.println("⚠️ Screenshot capture failed: " + e.getMessage());
        }
    }*/


    @Override
    public void onTestSkipped(ITestResult result) {
        WebDriver clientDriver = null;
        String argumentName = null;
        String testMethodName = result.getMethod().getMethodName();
        System.out.println("Test Successfully Failure Listener Invoked " + result.getName());

        try {
            clientDriver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("clientDriver")
                    .get(result.getInstance());
            argumentName = (String) result.getTestClass().getRealClass().getDeclaredField("argumentName")
                    .get(result.getInstance());
            argumentName = "skipped_" + argumentName.replaceAll("[^a-zA-Z0-9]", "_");
        } catch (IllegalArgumentException | IllegalAccessException | SecurityException | NoSuchFieldException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            String imgFileName = takeScreenSnapShotWithFullPage(clientDriver, argumentName);
            extentTestThread.get().log(Status.SKIP, "Test Case Method <b style=\"color:Tomato\"> "
                    + argumentName + " </b> executed successfully but not working as expected");

            System.out.println("Image File Name " + imgFileName);
            extentTestThread.get().addScreenCaptureFromPath(imgFileName, testMethodName);
        } catch (Exception e) {
            System.out.println("Error message user " + e.getMessage());
        }

        System.out.println("Test Skipped" + result.getName());

    }




    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        System.out.println("Test Failed but within success percentage" + result.getName());

    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println("This is onStart method" + context.getOutputDirectory());

    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();

        System.out.println("This is onFinish method" + context.getPassedTests());
        System.out.println("This is onFinish method" + context.getFailedTests());
    }



}
