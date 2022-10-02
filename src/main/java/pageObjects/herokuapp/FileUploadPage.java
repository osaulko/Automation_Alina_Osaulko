package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class FileUploadPage extends BasePage {
    private By name = By.xpath("/html/body/div[2]/div/div[1]/form/input[1]");


    public FileUploadPage addElement (){
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\hugo\\Desktop\\проекты\\Скриншоты\\Без названия.png");
        return this;
    }

    public FileUploadPage nameElement() {
        wait.until(ExpectedConditions.textToBePresentInElementValue(name,"Без названия"));
        return this;
    }
}



