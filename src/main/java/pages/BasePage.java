package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    protected WebElement waitUntilElementIsVisible(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void assertElementIsVisible(WebElement element, int seconds, String message) {
        try {
            waitUntilElementIsVisible(element, seconds);
        } catch (TimeoutException exception) {
            throw new AssertionError(message);
        }
    }
}
