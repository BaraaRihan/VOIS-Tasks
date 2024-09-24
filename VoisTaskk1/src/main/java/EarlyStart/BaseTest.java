package EarlyStart;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;


public class BaseTest {


    WebDriver driver;

    @BeforeClass
    public void Setup() // StartUp Driver
    {

        driver = new ChromeDriver();
        //Screen Orientation
        driver.manage().window().setSize(new Dimension(1024, 768));
        //ImplicitWait For 20 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Open AMAZON
        driver.get("https://www.amazon.com");

         // Let the user manually handle the CAPTCHA
         // System.out.println("Please solve the CAPTCHA and press Enter in the console to continue...");
         //Scanner scanner= new Scanner(System.in);
        //scanner.nextLine();  // Wait for user input  --> This line causes the program to pause and wait for the user to type something and press the Enter key.*/
        //System.out.println("Great! Lets continue.. ");

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
