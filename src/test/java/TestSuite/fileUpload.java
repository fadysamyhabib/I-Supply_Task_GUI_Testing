package TestSuite;

import Pages.HerokuApp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class fileUpload extends baseTest {

    // Declare an instance of the HerokuApp object to interact with the Heroku app page
    HerokuApp heroku;

    // Test method to verify file upload functionality
    @Test
    public void verifyUpload(){
        // Initialize the HerokuApp object using the WebDriver instance from the baseTest class
        heroku = new HerokuApp(driver);

        // Navigate to the Heroku App page containing the file upload functionality
        driver.get("https://the-internet.herokuapp.com/");

        // Call the fileUpload method to interact with the file upload feature
        heroku.fileUpload();

        // Assert that the file upload was successful by verifying the upload status
        Assert.assertTrue(heroku.verifyUpload());
    }
}
