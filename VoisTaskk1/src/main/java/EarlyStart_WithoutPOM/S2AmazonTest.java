package EarlyStart_WithoutPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class S2AmazonTest extends BaseTest {



    @Test
    public void filterAndAddDealToCart() throws InterruptedException {
        // BESMALLAH lets START

        // Close any alert that blocking the view
        WebElement closeAlertButton = driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input"));
        closeAlertButton.click();

        // Navigate to TodayDeals
        WebElement todaysDealsLink = driver.findElement(By.xpath("//a[@href='/gp/goldbox?ref_=nav_cs_gb']"));
        todaysDealsLink.click();

        // Filter deals by "Audible Books & Originals" Because I did not find the "Headphones"
        // Click on the specific filter for "Audible Books & Originals"
        WebElement BooksFilter = driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[1]/div/span[5]/div/label/i"));
        BooksFilter.click();

        // Short delay to ensure the filter is applied
        Thread.sleep(Duration.ofSeconds(15));

        // Scroll to the "10% off or more"
        WebElement tenPercentOffFilter = driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[5]/div/span[2]/div/label/span/span"));
        scrollToElement(tenPercentOffFilter);


        // After scrolling, click the on the filter ^_*
        WebElement applyTenPercentOffFilter = driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[5]/div/span[2]/div/label/i"));
        applyTenPercentOffFilter.click();

        // Navigate to the 4th page of deals BY adding "&page=4" to the URL
        driver.get(driver.getCurrentUrl() + "&page=4");

        // short delay to ensure the page is fully loaded
        Thread.sleep(50);

        // Select any item on the 4th page to view its details
        WebElement item = driver.findElement(By.xpath("//div[@data-test-index='3']"));
        item.click();

        // Add the selected item to the cart
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"a-autoid-4\"]/span/input"));
        addToCartButton.click();

        // Verify that the item was successfully added to the cart
        driver.get("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");
        WebElement cartItem = driver.findElement(By.cssSelector(".sc-list-item-content"));

        // Assert that the item is displayed in the cart
        Assert.assertTrue(cartItem.isDisplayed(), "Item was not added to the cart.");
    }


}

