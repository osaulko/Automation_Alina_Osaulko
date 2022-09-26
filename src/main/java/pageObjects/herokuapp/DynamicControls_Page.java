package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class DynamicControls_Page extends BasePage {

    private By checkbox = By.xpath("//input[@type = 'checkbox']");
    private By removeBtn = By.tagName("button");
    private By goneString = By.id("message");
    private By input = By.xpath("//input[@type = 'text']");
    private By enableBtn = By.xpath("//*[@type='button' and text()='Enable']//ancestor::form[@id='input-example']//button");

    public DynamicControls_Page clickOnCheckbox() {
        click(checkbox);
        return this;
    }

    public DynamicControls_Page clickOnRemove() {
        click(removeBtn);
        return this;
    }

    public DynamicControls_Page inputString() {
        driver.findElement(input);
        return this;
    }

    public DynamicControls_Page checkboxNotFound(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
        return this;
    }

    public DynamicControls_Page fieldDisabled(){
        wait.until(ExpectedConditions.elementSelectionStateToBe(input, Boolean.parseBoolean("disabled")));
        return this;
    }

    public DynamicControls_Page clickOnEnable() {
        click(enableBtn);
        return this;
    }

    public String disableMassege() {
        wait.until(ExpectedConditions.textToBe(goneString,"It's enabled!"));
        return getText(goneString);
    }

    public DynamicControls_Page fieldEnable(){
        wait.until(ExpectedConditions.elementSelectionStateToBe(input, Boolean.parseBoolean("enabled!")));
        return this;
    }

    public String itsGone() {
        wait.until(ExpectedConditions.textToBe(goneString,"It's gone!"));
        return getText(goneString);
    }
}