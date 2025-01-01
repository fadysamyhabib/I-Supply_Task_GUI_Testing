package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class Utilities {

    // Static method to capture a screenshot of the current state of the browser
    public static void takeScreenshot(WebDriver driver) {
        // Convert the WebDriver object to TakesScreenshot to enable screenshot capture
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture the screenshot as a file object
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination path where the screenshot will be saved
        String destination = System.getProperty("user.dir") + "/screenshots/" + ".png";

        try {
            // Copy the screenshot from the source file to the destination path
            FileUtils.copyFile(source, new File(destination));

            // Print a message confirming the screenshot has been saved
            System.out.println("Screenshot saved at: " + destination);
        } catch (IOException e) {
            // Handle any IOException that occurs when copying the screenshot
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
