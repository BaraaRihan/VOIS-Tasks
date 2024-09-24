package Scenario1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarttPage extends BaseTest {

    public CarttPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".sc-list-item-content")
    private WebElement cartItem;


    // Navigate to the cart page
    public void navigateToCart() {
        driver.get("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");
    }

    // Check if the item is displayed in the cart
    public boolean isItemInCart() {
        return cartItem.isDisplayed();
    }
}
