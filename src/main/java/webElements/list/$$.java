package webElements.list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webElements.single.$;

import java.util.List;

public class $$ implements IListActions {
    private final By locator;
    private final WebDriver driver;
    private List<WebElement> webElementList;

    public $$(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    public $ getElementAtIndex(int n) {
        findElements();
        var webElement = webElementList.get(n);
        return new $(webElement, driver);
    }

    public $ getFirst() {
        return getElementAtIndex(0);
    }

    public $ getLast() {
        return getElementAtIndex(webElementList.size() - 1);
    }

    @Override
    public void clickAll() {
        findElements();
        for (var webElement : webElementList) {
            var element = new $(webElement, driver);
            element.click();
        }
    }

    private void findElements() {
        webElementList = driver.findElements(locator);
    }
}
