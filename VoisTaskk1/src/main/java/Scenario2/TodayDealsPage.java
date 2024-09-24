package Scenario2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodayDealsPage extends BaseTest {

    public TodayDealsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id='nav-main']/div[1]/div/div/div[3]/span[1]/span/input")
    private WebElement closeAlertButton;

    @FindBy(xpath = "//a[@href='/gp/goldbox?ref_=nav_cs_gb']")
    private WebElement todaysDealsLink;

    @FindBy(xpath = "//*[@id='DealsGridScrollAnchor']/div[2]/div[1]/div/span[5]/div/label/i")
    private WebElement audibleBooksFilter;

    @FindBy(xpath = "//*[@id='DealsGridScrollAnchor']/div[2]/div[5]/div/span[2]/div/label/span/span")
    private WebElement tenPercentOffFilter;

    @FindBy(xpath = "//*[@id='DealsGridScrollAnchor']/div[2]/div[5]/div/span[2]/div/label/i")
    private WebElement applyTenPercentOffFilter;

    @FindBy(xpath = "//div[@data-test-index='3']")
    private WebElement item;

    @FindBy(xpath = "//*[@id='a-autoid-4']/span/input")
    private WebElement addToCartButton;


    public void closeAlert() {
        closeAlertButton.click();
    }

    public void openTodaysDeals() {
        todaysDealsLink.click();
    }

    public void filterByAudibleBooks() {
        audibleBooksFilter.click();
    }

    public void applyTenPercentOffFilter() throws InterruptedException {
        scrollToElement(tenPercentOffFilter); // Scroll to the "10% off" filter
        Thread.sleep(2000);  // Optional delay to ensure smooth scrolling
        applyTenPercentOffFilter.click();
    }

    public void navigateToFourthPage() {
        driver.get(driver.getCurrentUrl() + "&page=4");
    }

    public void selectItemAndAddToCart() {
        item.click();  // Select the item
        addToCartButton.click();  // Add the item to cart
    }

}
