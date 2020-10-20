package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getCurrentTitle() {
        return driver.getTitle();
    }

    protected boolean isUrlContains(String urlPart) {
        try {
            return wait.until(ExpectedConditions.urlContains(urlPart));
        } catch (TimeoutException e) {
            System.out.println("Url doesn't contain required part");
            return false;
        }
    }

    protected WebElement waitUntilElementIsVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitUntilElementTobeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /***
     *
     * Assert that UI WebElement is visible
     *
     * @param element - provided UI WebElement to be visible
     * @param message - text message in case WebElement is not visible
     */
    protected void assertElementIsVisible(WebElement element, String message) {
        try {
            waitUntilElementIsVisible(element);
        } catch (TimeoutException exception) {
            throw new AssertionError(message);
        }
    }

    protected void assertElementIsClickable(WebElement element, String message) {
        try {
            waitUntilElementTobeClickable(element);
        } catch (TimeoutException exception) {
            throw new AssertionError(message);
        }
    }

}
