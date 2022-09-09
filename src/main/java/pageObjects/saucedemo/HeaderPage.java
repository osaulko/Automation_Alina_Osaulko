package pageObjects.saucedemo;

import org.openqa.selenium.By;

public class HeaderPage extends BasketPage {

    By basketBtn = By.className("shopping_cart_link");
    By navigationBtn = By.id("react-burger-menu-btn");
    By removeBtn = By.id("remove-sauce-labs-onesie");

    public void clickBasketBtn() {
        click(basketBtn);
    }
    public void clickNavigationBtn() {
        click(navigationBtn);
    }
    public void clickRemoveBtn(){
        click(removeBtn);
    }
}