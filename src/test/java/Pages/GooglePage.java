package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import java.util.Properties;

public class GooglePage {

    // WebDriver instance to interact with the browser
    public WebDriver driver;

    // Properties object to load configuration settings (currently not used in the code)
    public Properties properties = new Properties();

    // Constructor to initialize the WebDriver and PageFactory elements
    public GooglePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initializes elements marked with @FindBy annotations (if any)
    }

    // Locator for the Google search bar (identified by its ID)
    By searchBar = By.id("APjFqb");

    // Locator for the third search result (using XPath)
    By thirdResultText = By.xpath("(//div[@class='g'])[3]");

    /*
    // Example setup method (commented out) to load properties file for configurations
    @BeforeClass
    public void setUp() {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file); // Load properties from the config file
        } catch (Exception e) {
            e.printStackTrace(); // Print error stack trace if loading properties fails
        }
    }
    */

    // Function to type a search query in the search bar and press the Enter key
    public void submitSearch(){
        // Find the search bar element and type the query
        driver.findElement(searchBar).sendKeys("selenium webdriver");

        // Simulate pressing the Enter key to submit the search
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
    }

    // Boolean function to verify if the third search result contains the expected text
    public boolean compareText(){
        // Get the text from the third search result
        String thirdText = driver.findElement(thirdResultText).getText();

        // Check if the text contains the expected string "What is Selenium WebDriver?"
        return thirdText.contains("What is Selenium WebDriver?");
    }
}
