package HomeWork7;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class Task7a extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        ProductPage productPage = new ProductPage();
        productPage.verifyPageTitle();
    }

    @Test
    public void loginTest1(){
        LoginPage loginPage1 = new LoginPage();
        loginPage1.open();
        loginPage1.enterUsername("problem_user");
        loginPage1.enterPassword("secret_sauce");
        loginPage1.clickLogin();
        ProductPage productPage1 = new ProductPage();
        productPage1.verifyPageTitle();
    }

    @Test
    public void loginTest2(){
        LoginPage loginPage2 = new LoginPage();
        loginPage2.open();
        loginPage2.enterUsername("performance_glitch_user");
        loginPage2.enterPassword("secret_sauce");
        loginPage2.clickLogin();
        ProductPage productPage2 = new ProductPage();
        productPage2.verifyPageTitle();
    }
}
