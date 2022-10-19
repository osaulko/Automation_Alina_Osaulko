package HomeWork8;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.FramesPage;
import pageObjects.herokuapp.NavigationItems;
import pageObjects.herokuapp.NavigationPage;

public class Frames_Test extends BaseTest {
    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test
    public void Frames_Test() {
        new NavigationPage()
                .navigateTo(NavigationItems.FRAMES);
        new FramesPage()
                .clickFrameLink("iFrame")
                .switchToFrame()
                .checkMassege();
    }
}
