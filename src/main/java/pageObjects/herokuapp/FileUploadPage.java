package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class FileUploadPage extends BasePage {
    
    private By uploadBtn = By.id("drag-drop-upload");

    public FileUploadPage clickUpload() {
        click(uploadBtn);
        return this;
    }
    public FileUploadPage click(String linkText) {
        driver.findElement(By.name("Без названия"));
        click(linkText);
        return this;
    }
}
