package Scenario2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BaseTest{

    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".sc-list-item-content")
    private WebElement cartItem;


    public void navigateToCart() {
        driver.get("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");
    }


    public boolean isItemInCart() {
        return cartItem.isDisplayed();
    }
}
