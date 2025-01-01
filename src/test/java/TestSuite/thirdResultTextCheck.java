package TestSuite;

import Pages.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class thirdResultTextCheck extends baseTest {

    // Declare an instance of the GooglePage object to interact with the Google page
    GooglePage google;

    // Test method to verify the text in the third search result
    @Test
    public void textCheck(){
        // Initialize the GooglePage object using the WebDriver instance from the baseTest class
        google = new GooglePage(driver);

        // Navigate to the Google homepage
        driver.get("https://www.google.com/ncr");

        // Perform a search for "selenium webdriver"
        google.submitSearch();

        // Assert that the third search result contains the expected text
        Assert.assertTrue(google.compareText());
    }
}
