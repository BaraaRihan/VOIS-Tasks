package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectBusPage{
    private WebDriver driver;

    public SelectBusPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBusSeat() {
        // Select seat from available options
        WebElement selectSeat = driver.findElements(By.className("selectbutton")).get(1);
        selectSeat.click();

        // Pick a specific seat (example)
        WebElement seat = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[2]/div[1]/div/div[5]/div[1]"));
        seat.click();
    }

    public void selectBoardingPoint() {
        // Select the boarding point
        WebElement boardingPoint = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div"));
        boardingPoint.click();
    }

    public void selectDroppingPoint() {
        // Select the dropping point
        WebElement droppingPoint = driver.findElement(By.xpath("//div[@class='point-inp flex-vc' and @tabindex='1']"));
        droppingPoint.click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div")).click();
    }

    public void providePassengerDetails() {
        // Click on the button to provide passenger details
        WebElement providePassengerDetailsButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]"));
        providePassengerDetailsButton.click();
    }
}
