package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class FileUploadPage extends BasePage {

    private By fileuploadBtn = By.id("file-upload");

    public FileUploadPage clickOnfileuploadBtn() {
        click(fileuploadBtn);
        return this;
    }

}
