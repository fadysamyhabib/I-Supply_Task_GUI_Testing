package TestSuite;

import Pages.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.IOException;

public class baseTest {

    WebDriver driver;
    Utilities utilities = new Utilities();

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        try {
            // Capture screenshot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotName = "TestScreenshot_" + System.currentTimeMillis() + ".png";
            String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName;

            // Create directory if it doesn't exist
            File screenshotDir = new File(System.getProperty("user.dir") + "/screenshots/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            // Save screenshot
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));

            // Embed screenshot in TestNG report
            Reporter.log("<br><img src='screenshots/" + screenshotName + "' height='400' width='800'/><br>");
            System.out.println("Screenshot saved and reported at: " + screenshotPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
