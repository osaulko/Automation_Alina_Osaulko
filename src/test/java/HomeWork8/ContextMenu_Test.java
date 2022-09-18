package HomeWork8;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.ContextMenuPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.CONTEXT_MENU;

public class ContextMenu_Test extends BaseTest {

    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test()
    public void contextMenu_Test() {
        new NavigationPage()
                .navigateTo(CONTEXT_MENU);
        new ContextMenuPage().clickContext().verifyAlert("You selected a context menu");
    }
}
