package Lecture_11;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class Login_Test extends BaseTest {

    @Test
    public void login(String username, String password) {
        new LoginPage()
                .open()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin()
                .verifyThatLoginPageIsClosed();
    }
}