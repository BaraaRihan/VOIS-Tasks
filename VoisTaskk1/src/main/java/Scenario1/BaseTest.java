package Scenario1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;


public class BaseTest {
   protected WebDriver driver;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @AfterClass
    public void TearDown()
    {
        //driver.quit();
    }
}
