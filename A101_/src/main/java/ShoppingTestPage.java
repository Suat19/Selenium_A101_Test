import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;
import java.util.Random;

public class ShoppingTestPage{
    private  WebDriver driver;

    public ShoppingTestPage(WebDriver driver) {this.driver=driver;
    }

    public void goToWebSite() throws InterruptedException {
        driver.getWindowHandle();
        WebElement cookiestext= driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogHeader\"]"));
        driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();
    }
    public  void findSocks() throws InterruptedException {
        List<WebElement> console=driver.findElements(By.className("js-navigation-item"));
        Actions actions=new Actions(driver);
        actions.moveToElement(console.get(3)).perform();
        Thread.sleep(500);
        console.get(3).click();

        List<WebElement>  womenWear=driver.findElements(By.className("js-filter-link"));
        womenWear.get(1).click();
        Thread.sleep(1000);

        List<WebElement> kneeSock=driver.findElements(By.className("js-filter-link"));
        kneeSock.get(1).click();
       Thread.sleep(1000);
    }

    public void selectSocks() throws InterruptedException {
        WebElement socks=driver.findElement(By.xpath("/html/body/section/section[4]/div[3]/div[2]/div/div[2]/div[2]/div/ul/li[1]/article/div/div[2]/div[2]"));
        //Thread.sleep(1000);
        socks.click();
       Thread.sleep(500);

        List<WebElement> socksColor=driver.findElements(By.className("variant-colors__item-image"));
        socksColor.get(0).click();

        Thread.sleep(500);
        List<WebElement> addBasket=driver.findElements(By.className("js-add-basket"));
        addBasket.get(0).click();
        Thread.sleep(1000);

        driver.getWindowHandle();
        List<WebElement> goBasket=driver.findElements(By.className("go-to-shop"));
        //Thread.sleep(1000);
        goBasket.get(0).click();
        //Thread.sleep(2000);

    }
    public void continueToBuy() throws InterruptedException {
        WebElement goToBuy=driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div/div[2]/div/a"));
        goToBuy.click();
        Thread.sleep(1000);
        WebElement continueWithoutSignin=driver.findElement(By.xpath("/html/body/section/div[1]/div/div[1]/div[1]/div[2]/a"));
        continueWithoutSignin.click();
        Thread.sleep(1000);
        List<WebElement> enterEmail=driver.findElements(By.name("user_email"));
        enterEmail.get(0).sendKeys("FakenuserMail@gmail.com");
        Thread.sleep(1000);

        WebElement continueButton=driver.findElement(By.cssSelector(" div.page-auth > div > div.row.js-block-email > div > div > form > button"));
        continueButton.click();
        Thread.sleep(1000);

        WebElement newAdress=driver.findElement(By.xpath("/html/body/section/section/div/div[2]/div/div[1]/div/div[1]/div[2]/ul[2]/li"));
        newAdress.click();
        Thread.sleep(1000);
    }

    public void addAdress() throws InterruptedException {
        driver.getWindowHandle();
       // Thread.sleep(1000);
        WebElement titleAdress=driver.findElement(By.cssSelector("div:nth-child(3) > div > div > label > input[type=text]"));
        titleAdress.sendKeys("Ev adresi");
        //Thread.sleep(1000);
        WebElement firstname=driver.findElement(By.cssSelector("input[name=first_name]"));
        firstname.sendKeys("FakeName");
        WebElement lastname=driver.findElement(By.cssSelector("input[name=last_name]"));
        lastname.sendKeys("FakeSurname");
        //Thread.sleep(1000);
        WebElement phoneNumber=driver.findElement(By.cssSelector("input[name=phone_number]"));
        phoneNumber.sendKeys("5554447788");
        //Thread.sleep(1000);

        Select il=new Select(driver.findElement(By.className("js-cities")));
        il.selectByVisibleText("BURSA");
        Thread.sleep(500);
        Select ilce=new Select(driver.findElement(By.className("js-township")));
        ilce.selectByVisibleText("NİLÜFER");
        Thread.sleep(500);

        Select mahalle=new Select(driver.findElement(By.className("js-district")));
        mahalle.selectByVisibleText("DUMLUPINAR MAH");
       // Thread.sleep(1000);

        WebElement adress=driver.findElement(By.className("js-address-textarea"));
        Random doorNumber = new Random();
        for (int i= 0; i<=1; i++){
            int randomNumber = doorNumber.nextInt(100);
            adress.sendKeys("ABC sokak.Güzelyalı sitesi No:1 daire: "+ randomNumber);
        }
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement kaydet=driver.findElement(By.xpath("//button[normalize-space()='KAYDET']"));
        kaydet.click();
        Thread.sleep(2000);
    }
    public void finish() throws InterruptedException {

        WebElement continueButton=driver.findElement(By.xpath("//*[@class='button block green js-proceed-button']"));
        continueButton.click();
        Thread.sleep(1000);

        WebElement odemesayfasi=driver.findElement(By.xpath("/html/body/section/section/div/div[3]/div[1]/div[1]"));
       List<WebElement>  siparisOzeti=driver.findElements(By.cssSelector("div.products > ul > li > a"));
        System.out.println(siparisOzeti.get(0).getText());
        System.out.println(odemesayfasi.getText());
        Assert.assertEquals("Kart ile ödeme",odemesayfasi.getText());

        Thread.sleep(1000);
        System.out.println("............Test Başarılı..........");
    }

}
