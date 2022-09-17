package Utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basetest {

    protected static WebDriver driver;

    @BeforeAll
    public  static  void  setup()
    {System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver= new ChromeDriver();
        driver.navigate().to("https://www.a101.com.tr/");
        driver.manage().window().maximize();
    }
    @AfterAll

    public  static  void teardown()
    {
        driver.quit();
    }

}