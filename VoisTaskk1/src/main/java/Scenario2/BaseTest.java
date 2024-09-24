package Scenario2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;


public class BaseTest {
   protected WebDriver driver;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize web elements
    }

    // Scrolls to the given element using JavaScript
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void TearDown()  // When Finish Close Driver
    {
        //driver.quit();
    }
}
