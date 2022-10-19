package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class FramesPage extends BasePage {
    private By iframe = By.id("mce_0_ifr");
    private By textArea = By.id("tinymce");
    private By boldTxt = By.cssSelector("[aria-label='Bold']");
    private By textToCheck = By.id("tinymce");

    private By clickLink(String linkText) {
        return By.linkText(linkText);
    }

    public FramesPage clickFrameLink(String linkText) {
        click(clickLink(linkText));
        return this;
    }

    public FramesPage switchToFrame() {
        driver.switchTo().frame(driver.findElement(iframe));
        return this;
    }

    public String checkMassege() {
        wait.until(ExpectedConditions.textToBe(textToCheck, "Your content goes here."));
        return getText(textToCheck);
    }

    public FramesPage enterText(String text) {
        enter(textArea, text, Keys.chord(Keys.CONTROL, "a"));
        return this;
    }

    public FramesPage unSwitchFrame() {
        driver.switchTo().defaultContent();
        return this;
    }

    public FramesPage clickBoldTxt() {
        click(boldTxt);
        return this;
    }
}