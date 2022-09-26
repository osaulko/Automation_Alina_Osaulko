package HomeWork8;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DynamicControls_Page;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.DYNAMIC_CONTROLS;

public class DynamicControls_Test extends BaseTest {

    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test
    public void DynamicControls_Test(){
        new NavigationPage()
                .navigateTo(DYNAMIC_CONTROLS);
        DynamicControls_Page dynamicControls_page = new DynamicControls_Page();
        dynamicControls_page.clickOnCheckbox();
        dynamicControls_page.clickOnRemove();
        dynamicControls_page.itsGone();
        dynamicControls_page.checkboxNotFound();
        dynamicControls_page.inputString()
                .fieldDisabled()
                .clickOnEnable()
                .disableMassege();
        dynamicControls_page.fieldEnable();
    }
}
