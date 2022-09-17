import Utility.Basetest;
import org.junit.jupiter.api.Test;

public class ShoppingTest extends Basetest {

    ShoppingTestPage shoppingTestPage=new ShoppingTestPage(driver);

    @Test
    public  void test_1() throws InterruptedException
    {
        shoppingTestPage.goToWebSite();
    }
    @Test
    public  void test_2() throws InterruptedException
    {
        shoppingTestPage.findSocks();
    }
    @Test
    public  void test_3() throws InterruptedException
    {
        shoppingTestPage.selectSocks();
    }
    @Test
    public  void test_4() throws InterruptedException
    {
        shoppingTestPage.continueToBuy();
    }
    @Test
    public  void test_5() throws InterruptedException
    {
        shoppingTestPage.addAdress();
    }
    @Test
    public  void test_6() throws InterruptedException
    {
        shoppingTestPage.finish();
    }
}