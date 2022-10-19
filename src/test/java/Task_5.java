import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static driver.SimpleDriver.getWebDriver;

public class Task_5 {

    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }


    @Test
    public void test1() {
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys("5");

        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys("3");

        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys("1000");

        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys("75");

        getWebDriver().findElement(By.name("calc_inpack")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys("10");

        getWebDriver().findElement(By.name("calc_price")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getWebDriver().findElement(By.name("calc_price")).sendKeys("600");
        Select selectCalcDirect = new Select(getWebDriver().findElement(By.name("calc_direct")));
        selectCalcDirect.selectByValue("toh");

        getWebDriver().findElement(By.name("calc_bias")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getWebDriver().findElement(By.name("calc_bias")).sendKeys("200");

        getWebDriver().findElement(By.name("calc_walldist")).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys("15");

        getWebDriver().findElement(By.cssSelector("[value='Рассчитать']")).click();
        List<String> actualData = ActualData();
        List<String> expectedData = new ArrayList<>() {{
            add("Площадь укладки: 14.76 м2.");
            add("Кол-во панелей: 203 шт.");
            add("Кол-во упаковок: 21 шт.");
            add("Стоимость: 9450 руб.");
            add("Остатки: 7 шт.");
            add("Отрезки: 18 шт.");
        }};

        Assert.assertEquals(actualData, expectedData);

    }

    @AfterTest
    public void postconditions() {
        getWebDriver().close();
    }

    private List<String> ActualData() {
        List<String> actualData = new ArrayList<>();
        List<WebElement> result = getWebDriver().findElements(By.xpath("//div[contains(@class, 'whiteback')]//div[@class ='form_element']"));
        result.forEach(webElement -> {
            actualData.add(webElement.getText());
        });
        return actualData;
    }
}
