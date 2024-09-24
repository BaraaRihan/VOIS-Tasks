package Scenario2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonTest2 {
    private WebDriver driver;
    private TodayDealsPage todayDealsPage;
    private CartPage cartPage;

    @BeforeClass
    public void setUp() {
        // Initialize the driver and the page objects
        driver = new ChromeDriver();
        todayDealsPage = new TodayDealsPage(driver);
        cartPage = new CartPage(driver);
        driver.get("https://www.amazon.com/");

    }

    @Test
    public void filterAndAddDealToCart() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Close any alert
        todayDealsPage.closeAlert();

        // Open Today's Deals
        todayDealsPage.openTodaysDeals();

        // Apply the filter for Audible Books & Originals
        todayDealsPage.filterByAudibleBooks();

        // Apply "10% off or more" filter
        todayDealsPage.applyTenPercentOffFilter();

        // Navigate to the 4th page of deals
        todayDealsPage.navigateToFourthPage();

        // Select an item and add it to the cart
        todayDealsPage.selectItemAndAddToCart();

        // Verify that the item is in the cart
        cartPage.navigateToCart();
        Assert.assertTrue(cartPage.isItemInCart(), "Item was not added to the cart.");
    }



}
