import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static driver.SimpleDriver.getWebDriver;

public class Task_6 {

    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.saucedemo.com/");
    }

    @Test

    public void test(){

        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.xpath("//input[@data-test='login-button']")).click();
        //getWebDriver().findElement(By.id("login-button")).sendKeys(Keys.ENTER);
        //getWebDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).sendKeys(Keys.ENTER);
        getWebDriver().findElement(By.xpath("//*[@class='inventory_item_name'and text()='Sauce Labs Backpack']//ancestor::div[@class='inventory_item']//button")).click();
        getWebDriver().findElement(By.xpath("//div[contains(@class, 'shopping_cart_container')]//span[@class ='shopping_cart_badge']")).click();
        List<String> actualData = ActualData();
        List<String> expectedData = new ArrayList<>() {{
            add("Sauce Labs Backpack");
            add("$29.99");
        }};
        Assert.assertEquals (actualData, expectedData);
    }

    @AfterTest
        public void postconditions() {
        getWebDriver().close();
    }

    private List<String> ActualData() {
        List<String> actualData = new ArrayList<>();
        List<WebElement> result = getWebDriver().findElements(By.cssSelector("div a div"));
        //List<WebElement> result = getWebDriver().findElements(By.xpath("//div[contains(@class, 'cart_item_label')]//div[@class ='inventory_item_name']"));
        List<WebElement> result1 = getWebDriver().findElements(By.xpath("//div[contains(@class, 'item_pricebar')]//div[@class ='inventory_item_price']"));
        result.forEach(webElement -> {
            actualData.add(webElement.getText());
        result1.forEach(webElement1 -> actualData.add(webElement1.getText()));
        });
        return actualData;
    }
}

