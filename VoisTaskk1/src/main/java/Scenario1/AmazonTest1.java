package Scenario1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonTest1 {
    private WebDriver driver;
    private SearchPage searchPage;
    private ItemPage itemPage;
    private CarttPage cartPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        itemPage = new ItemPage(driver);
        cartPage = new CarttPage(driver);


        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void searchAddAndVerifyItemInCart() {
        // Search for car accessories
        searchPage.searchForItem("car accessories");

        // Select the first item from the search results
        searchPage.selectFirstItem();

        // Add the selected item to the cart
        itemPage.addItemToCart();

        // Navigate to the cart
        cartPage.navigateToCart();

        // Verify that the item is displayed in the cart
        Assert.assertTrue(cartPage.isItemInCart(), "Item was not added to the cart.");
    }


    }

