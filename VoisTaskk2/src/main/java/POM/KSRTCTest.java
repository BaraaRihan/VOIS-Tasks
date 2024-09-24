package POM;

import org.testng.annotations.Test;

import java.time.Duration;

public class KSRTCTest extends BaseTest{


    @Test
    public void bookBusTicket() throws InterruptedException {


        Thread.sleep(Duration.ofSeconds(5));
        HomePage homePage = new HomePage(driver);
        SelectBusPage selectBusPage = new SelectBusPage(driver);
        PassengerDetailsPage passengerDetailsPage = new PassengerDetailsPage(driver);

        homePage.selectFromCity("CHIKKAMAGALURU");
        homePage.selectToCity("BENGALURU");
        homePage.selectArrivalDate();
        homePage.clickSearch();


        selectBusPage.selectBusSeat();
        selectBusPage.selectBoardingPoint();
        selectBusPage.selectDroppingPoint();
        selectBusPage.providePassengerDetails();

        passengerDetailsPage.enterCustomerDetails("6789125987", "Bob@gmail.com");
        passengerDetailsPage.proceedAsGuest();
        passengerDetailsPage.fillPassengerDetails("Bob", "24", "1234567890123456");
        passengerDetailsPage.proceedToCheckout();
    }
}
