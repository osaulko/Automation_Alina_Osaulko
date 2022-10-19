package pageObjects.baseObjects;

import driver.SimpleDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testNgUtils.ExtentReportListener;
import testNgUtils.Listener;

import static driver.SimpleDriver.closeWebDriver;

@Listeners({Listener.class, ExtentReportListener.class})
public abstract class BaseTest {

    @BeforeTest
    public void setUp() {
        System.out.println("I'm started new wed driver!");
        new SimpleDriver();
    }

    @AfterTest
    public void stop() {
        System.out.println("I'm close wed driver!");
        closeWebDriver();
    }
}