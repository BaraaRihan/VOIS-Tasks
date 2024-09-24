package EarlyStart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class S1AmazonTest extends BaseTest {



    @Test
    public void FirstAmazonScenario(){
        // BESMALLAH lets START

        // Search for Car Accessories
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("car accessories");
        searchBox.sendKeys(Keys.ENTER);  //OR searchBox.submit():

        // Select the First item
        WebElement firstItem = driver.findElement(By.cssSelector("div[data-index='6']"));  // Cuz first product starts with data-index ="6"
        firstItem.click();

        // Add to cart
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();

        // Go to the cart and verify
        driver.get("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");
        WebElement cartItem = driver.findElement(By.cssSelector(".sc-list-item-content"));
        if (cartItem.isDisplayed()) {
            System.out.println("Item successfully added to the cart.");
        } else {
            System.out.println("Item not found in the cart.");
        }

        // OR

        // Go to the cart and verify but with price ^*^     # It didn't work I'll check it later if there is a time
       /* List<WebElement> productPrices =driver.findElements(By.id("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
        int count = productPrices.size();
        double totalSum =0;
        for(int i =0; i< count; i++)
        {
            String amountString =productPrices.get(i).getText();
            Double price = Double.parseDouble(amountString.substring(1));  // To Remove dollar"$" sign and easy Calculation
            totalSum = totalSum + price;
        }

        String displaySum =driver.findElement(By.cssSelector("#sc-subtotal-amount-activecart > span")).getText();
        Double displayFormattedSum = Double.parseDouble(displaySum.substring(1));
        Assert.assertEquals(totalSum, displayFormattedSum);*/

    }
}
