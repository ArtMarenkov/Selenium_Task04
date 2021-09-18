package pages;

import org.openqa.selenium.WebElement;

public class BasePage {

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
}
