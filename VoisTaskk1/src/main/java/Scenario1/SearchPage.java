package Scenario1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BaseTest {

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(css = "div[data-index='6']") // First item typically starts with index 6
    private WebElement firstItem;


    // Search for an item in the search box
    public void searchForItem(String item) {
        searchBox.sendKeys(item);
        searchBox.sendKeys(Keys.ENTER);
    }

    // Select the first item from the search results
    public void selectFirstItem() {
        firstItem.click();
    }
}
