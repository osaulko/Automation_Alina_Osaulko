package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

import static driver.SimpleDriver.getWebDriver;

public class BasketPage extends BasePage {

    private final By removeBtn = By.cssSelector("[class='btn btn_secondary btn_small cart_button']");

    private final By checkoutBtn = By.cssSelector("[class='btn btn_action btn_medium checkout_button']");

    private WebElement getElementCartItem(String productName) {
        return getWebDriver().findElement(By.xpath("//*[@class = 'inventory_item_name' and text() = '" + productName + "']//ancestor::div[@class='cart_item']"));
    }

    private WebElement getDeleteCartItem(String productName) {
        return getElementCartItem(productName).findElement(By.tagName("button"));
    }

    private WebElement getCheckout(String productName){
        return getElementCartItem(productName).findElement(By.id("checkout"));
    }

    private WebElement getElementProductCost(String productName) {
        return getElementCartItem(productName).findElement(By.className("inventory_item_price"));
    }

    private WebElement getElementCartQuantity(String productName){
        return getElementCartItem(productName).findElement(By.className("cart_quantity"));
    }

    public String getProductCost(String productName) {
        return getText(getElementProductCost(productName));
    }

    public String enterCartQuantity(String productName) {
        return getText(getElementCartQuantity(productName));
    }

    public BasketPage checkThatRemoveBtnNotExist() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(removeBtn));
        return  this;
    }

    public BasketPage clickRemove(String productName) {
        click(getDeleteCartItem(productName));
        return this;
    }

    public BasketPage checkCheckoutButton() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkoutBtn));
        return  this;
    }

    public BasketPage clickCheckout(String productName){
        click(checkoutBtn);
        return this;
    }
}