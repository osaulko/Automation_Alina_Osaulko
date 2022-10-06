package HomeWork9;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.BasketPage;
import pageObjects.saucedemo.HeaderPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class Task9_3Test extends BaseTest {

    @Parameters({"url",})
    @BeforeMethod
    public void preconditions(@Optional("https://www.google.com/") String url) {
        new LoginPage()
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();
        ;
    }

    @Test (dataProvider = "products name")
    public void dataProviderTask(String productName , String productCost) {
        new ProductPage().addProductToBasket(productName);
        HeaderPage headerPage = new HeaderPage();
        headerPage.clickBasketBtn();
        new BasketPage().clickRemove(productName);
    }

    @DataProvider(name = "products name")
    public Object[][] getData() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99"},
                {"Sauce Labs Bike Light", "$9.99"},
                {"Sauce Labs Bolt T-Shirt", "$15.99"},
                {"Sauce Labs Fleece Jacket", "$49.99"},
        };
    }
}
