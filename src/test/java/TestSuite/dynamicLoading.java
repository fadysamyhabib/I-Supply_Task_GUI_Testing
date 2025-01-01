package TestSuite;

import Pages.GooglePage;
import Pages.HerokuApp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dynamicLoading extends baseTest {

    HerokuApp heroku;





    @Test
    public void verifyloading(){
        heroku = new HerokuApp(driver);
        driver.get("https://the-internet.herokuapp.com/");
        heroku.dynamicLoading();
        heroku.waitUntilElementNotDisplayed();
        Assert.assertTrue(heroku.verifyLoading());
    }
}
