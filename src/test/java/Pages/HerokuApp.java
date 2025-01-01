package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Properties;

public class HerokuApp {
    // WebDriver instance for interacting with the browser
    public WebDriver driver;

    // Properties object to load configurations (currently not used in the code)
    public Properties properties = new Properties();

    // Constructor to initialize WebDriver and PageFactory elements
    public HerokuApp(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements with @FindBy annotations (if any)
    }

    // Locators for various elements on the page
    By fileUploadButton = By.xpath("//a[normalize-space()='File Upload']");
    By dynamicLoadingButton = By.xpath("//a[normalize-space()='Dynamic Loading']");
    By example2Button = By.xpath("//a[normalize-space()='Example 2: Element rendered after the fact']");
    By startButton = By.xpath("//button[normalize-space()='Start']");
    By loadingText = By.xpath("//div[@id='loading']");
    By chooseFileButton = By.id("file-upload");
    By uploadFileButton = By.id("file-submit");
    By uploadSucessTextElement = By.xpath("//h3[normalize-space()='File Uploaded!']");
    By helloWorldTextElement = By.xpath("//h4[normalize-space()='Hello World!']");

    // Method to upload a file through the file upload interface
    public void fileUpload(){
        // Click the 'File Upload' link to navigate to the file upload page
        driver.findElement(fileUploadButton).click();

        // Send the file path to the 'Choose File' input field
        driver.findElement(chooseFileButton).sendKeys("C:\\Users\\Fady\\IdeaProjects\\Assessment\\Screenshots\\Capture.PNG");

        // Submit the file upload by pressing Enter on the 'Upload' button
        driver.findElement(uploadFileButton).sendKeys(Keys.ENTER);
    }

    // Method to wait until the 'loading' text is not visible, indicating the page has finished loading
    public void waitUntilElementNotDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingText))); // Wait until the loading element disappears
    }

    // Method to navigate through the dynamic loading page example
    public void dynamicLoading(){
        // Click on 'Dynamic Loading' link and then on 'Example 2'
        driver.findElement(dynamicLoadingButton).click();
        driver.findElement(example2Button).click();

        // Click 'Start' to trigger the dynamic loading process
        driver.findElement(startButton).click();
    }

    // Method to verify that the file upload was successful (checks if success text is visible)
    public boolean verifyUpload() {
        return driver.findElement(uploadSucessTextElement).isDisplayed(); // Return true if upload success text is displayed
    }

    // Method to verify that the 'Hello World' text is visible after dynamic loading
    public boolean verifyLoading(){
        return driver.findElement(helloWorldTextElement).isDisplayed(); // Return true if 'Hello World' text is displayed
    }
}
