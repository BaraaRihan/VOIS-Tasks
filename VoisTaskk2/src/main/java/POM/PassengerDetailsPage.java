package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PassengerDetailsPage {


    private WebDriver driver;

    public PassengerDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCustomerDetails(String mobileNumber, String email) throws InterruptedException {
        Thread.sleep(10);
        WebElement mobileInput = driver.findElement(By.xpath("//input[@name='mobileNo']"));
        mobileInput.sendKeys(mobileNumber);

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys(email);
    }

    public void proceedAsGuest() throws InterruptedException {
        Thread.sleep(15);
        WebElement proceedAsGuestButton = driver.findElement(By.xpath("//div[@tabindex='1003']"));
        proceedAsGuestButton.click();
    }

    public void fillPassengerDetails(String name, String age, String idCardNo) throws InterruptedException {
        // Fill passenger name
        WebElement nameInput = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        nameInput.sendKeys(name);
        nameInput.sendKeys(Keys.ENTER);

        // Select gender (Male)
        Thread.sleep(20);
        WebElement gender = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[4]/section/div/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]"));
        gender.click();


        // Enter age
        WebElement ageInput = driver.findElement(By.xpath("//input[@name='paxAge[0]']"));
        ageInput.sendKeys(age);
        Thread.sleep(10);
        ageInput.sendKeys(Keys.ENTER);


        // Choose a concession type
        WebElement concession = driver.findElement(By.xpath("//input[@name='paxConcessionType[0]']"));
        concession.click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[4]/section/div/div[2]/div[2]/div[1]/div[2]/div[5]/div/div[2]")).click();

        // Select ID card type and enter ID card number
        WebElement idCard = driver.findElement(By.xpath("//input[@name='paxIDCardType[0]']"));
        idCard.click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[4]/section/div/div[2]/div[2]/div[1]/div[2]/div[6]/div/div[2]")).click();

        WebElement idCardNoInput = driver.findElement(By.xpath("//input[@name='paxIDCardNo[0]']"));
        idCardNoInput.sendKeys(idCardNo);
    }

    public void proceedToCheckout() {
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[4]/section/div/div[2]/div[2]/div[2]"));
        proceedToCheckoutButton.click();
    }
}
