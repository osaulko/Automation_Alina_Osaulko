package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class DynamicLoadingPage extends BasePage {

    private By startBtn = By.id("start");
    private By loading = By.id("loading");
    private By finish = By.id("finish");

    private By getByLink(String textLink) {
        return By.partialLinkText(textLink);
    }


    public DynamicLoadingPage clickOnExample(String text) {
        click(getByLink(text));
        return this;
    }

    public DynamicLoadingPage clickOnStart() {
        click(startBtn);
        return this;
    }

    public String pageIsLoaded() {
        return getText(loading);
    }
}