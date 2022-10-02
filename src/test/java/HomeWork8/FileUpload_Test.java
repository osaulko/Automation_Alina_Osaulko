package HomeWork8;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.FileUploadPage;
import pageObjects.herokuapp.NavigationItems;
import pageObjects.herokuapp.NavigationPage;

public class FileUpload_Test extends BaseTest {

    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test()
    public void FileUpload_Test() {
        new NavigationPage()
                .navigateTo(NavigationItems.FILE_UPLOAD);
        FileUploadPage fileUploadPage = new FileUploadPage();
        fileUploadPage.addElement().nameElement();
    }
}