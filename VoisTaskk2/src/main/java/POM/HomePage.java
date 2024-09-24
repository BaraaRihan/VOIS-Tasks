package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BaseTest {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromCity(String cityName) throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='fromCity_chosen']/a/span")).click();
        WebElement leavingFrom = driver.findElement(By.xpath("//*[@id='fromCity_chosen']/div/div[1]/input"));
        Thread.sleep(15);
        leavingFrom.sendKeys(cityName);
        leavingFrom.sendKeys(Keys.ENTER);
        Thread.sleep(20);
    }

    public void selectToCity(String cityName) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='toCity_chosen']/a/span")).click();
        WebElement goingTo = driver.findElement(By.xpath("//*[@id='toCity_chosen']/div/div[1]/input"));
        Thread.sleep(20);
        goingTo.sendKeys(cityName);
        goingTo.sendKeys(Keys.ENTER);
    }

    public void selectArrivalDate() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='departDate']")).click();
        WebElement arrivalDate = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[5]/a"));
        arrivalDate.click();
        Thread.sleep(20);
    }

    public void clickSearch() {
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='search--btn']"));
        searchButton.click();
    }
    }
