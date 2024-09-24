package WithoutPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class early {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Thread.sleep(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"fromCity_chosen\"]/a/span")).click();
        WebElement LeavingFrom = driver.findElement(By.xpath("//*[@id=\"fromCity_chosen\"]/div/div[1]/input"));
        Thread.sleep(15);
        LeavingFrom.sendKeys("CHIKKAMAGALURU");
        Thread.sleep(15);
        LeavingFrom.sendKeys(Keys.ENTER);

         driver.findElement(By.xpath("//*[@id=\"toCity_chosen\"]/a/span")).click();
        WebElement GoingTo = driver.findElement(By.xpath("//*[@id=\"toCity_chosen\"]/div/div[1]/input"));
        Thread.sleep(7);
        GoingTo.sendKeys("BENGALURU");
        GoingTo.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"departDate\"]")).click();
        WebElement ArrivalDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[4]/td[5]/a"));
        ArrivalDate.click();
        WebElement SearchButton = driver.findElement(By.xpath("//div[@class='search--btn']"));
        SearchButton.click();

        WebElement SelectSeat = driver.findElements(By.className("selectbutton")).get(1);
        SelectSeat.click();

       WebElement Seat= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[2]/div[1]/div/div[5]/div[1]"));
        Seat.click();

        WebElement BoardingSeat = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div"));
        BoardingSeat.click();

        WebElement DropingSeat = driver.findElement(By.xpath("//div[@class='point-inp flex-vc' and @tabindex='1']"));
        DropingSeat.click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div")).click();

        WebElement ProvidePassengerDetailsButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]"));
        ProvidePassengerDetailsButton.click();

        WebElement MobNum = driver.findElement(By.xpath("//input[@name='mobileNo']"));
        MobNum.sendKeys("6789125987");
        MobNum.sendKeys(Keys.ENTER);

        WebElement EmailId = driver.findElement(By.xpath("//input[@name='email']"));
        EmailId.sendKeys("Bob@gmail.com");
        EmailId.sendKeys(Keys.ENTER);

        WebElement ProceedAsGuestUserButton = driver.findElement(By.xpath("//div[@tabindex='1003']"));
        ProceedAsGuestUserButton.click();

        WebElement Name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        Name.sendKeys("Bob");
        Name.sendKeys(Keys.ENTER);

        WebElement Gendar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[4]/section/div/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]"));
        Gendar.click();

        WebElement Age = driver.findElement(By.xpath("//input[@name='paxAge[0]']"));
        Age.sendKeys("24");
        Age.sendKeys(Keys.ENTER);

       WebElement Concession = driver.findElement(By.xpath("//input[@name='paxConcessionType[0]']"));
       Concession.click();
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[4]/section/div/div[2]/div[2]/div[1]/div[2]/div[5]/div/div[2]")).click();

       WebElement IdCard = driver.findElement(By.xpath("//input[@name='paxIDCardType[0]']"));
       IdCard.click();
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[4]/section/div/div[2]/div[2]/div[1]/div[2]/div[6]/div/div[2]")).click();


       WebElement IdCardNo = driver.findElement(By.xpath("//input[@name='paxIDCardNo[0]']"));
       IdCardNo.sendKeys("1234567890123456");
       IdCardNo.sendKeys(Keys.ENTER);

       WebElement ProceedCheckOut = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[4]/section/div/div[2]/div[2]/div[2]"));
       ProceedCheckOut.click();


    }
}
