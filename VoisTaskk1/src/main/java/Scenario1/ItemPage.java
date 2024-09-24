package Scenario1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BaseTest {

    public ItemPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    // Add the selected item to the cart
    public void addItemToCart() {
        addToCartButton.click();
    }
}
