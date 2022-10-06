package HomeWork9;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.BasketPage;
import pageObjects.saucedemo.HeaderPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class Task9_2Test extends BaseTest {

    @Parameters({"url",})
    @BeforeMethod
    public void preconditions(@Optional("https://www.google.com/") String url) {
        new LoginPage()
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();;
    }

    @Test(invocationCount = 5 )
    public void invocationCountTask() {
        new ProductPage().addProductToBasket("Sauce Labs Bike Light");
        HeaderPage headerPage = new HeaderPage();
        headerPage.clickBasketBtn();
        new BasketPage().clickRemove("Sauce Labs Bike Light");
    }
}
