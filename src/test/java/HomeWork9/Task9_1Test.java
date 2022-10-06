package HomeWork9;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class Task9_1Test extends BaseTest {
    @Parameters({"url",})
    @BeforeMethod
    public void preconditions(@Optional("https://www.google.com/") String url) {
        new LoginPage()
                .open();
    }

    @Test(dataProvider = "login data")
    public void login(String username, String password) {
        new LoginPage()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }

    @DataProvider(name = "login data")// поставщик данных в двумерном массиве
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "3645769"},
                {"AlinaName@", "secret_sauce"},
        };
    }
}
