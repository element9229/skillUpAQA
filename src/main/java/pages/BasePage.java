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

    protected WebElement waitUntilElementIsVisible(WebElement element, int seconds) {
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
