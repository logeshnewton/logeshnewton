package Flight.Utility;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    public WebDriver driver;
    public ConfigFileReader propertyFileReader;

    public String takeScreenShot(WebDriver driver, String fileName) throws IOException {

        propertyFileReader = new ConfigFileReader();
       // String path = propertyFileReader.getBaseDir()+"/reports/";
        String path=propertyFileReader.getBaseDir()+"/reports/";

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destinationFileName = path + fileName+".png";
        File Distination = new File(destinationFileName);
        FileUtils.copyFile(src, Distination);
        return fileName +".png";
    }
    public String takeScreenSnapShotWithFullPage(WebDriver webDriver, String fileName) {
        propertyFileReader = new ConfigFileReader();
        String path = propertyFileReader.getBaseDir() + "/reports/";
        //  String destinationFileName = path + fileName + ".png";
        Shutterbug.shootPage(webDriver, Capture.FULL_SCROLL).withName(fileName).save(path);
        return fileName + ".png";
    }
}
