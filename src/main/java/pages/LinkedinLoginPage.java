package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

import java.io.IOException;

public class LinkedinLoginPage extends BasePage{

    @FindBy(id = "username")
    private WebElement userEmailField;

    @FindBy(id = "password")
    private WebElement userPasswordField;

    @FindBy(xpath = "//button[@data-litms-control-urn='login-submit']")
    private WebElement enterButton;

    public LinkedinLoginPage(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.wait = webDriverWait;
        PageFactory.initElements(driver, this);
        assertElementIsVisible(enterButton, "Login page is not loaded.");
    }

    public <T> T login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        enterButton.click();

        if (isUrlContains("/feed")){
            return (T) new LinkedinHomePage(driver, wait);
        }
        if (isUrlContains("/checkpoint/lg/login-submit")) {
            return (T) new LinkedinLoginSubmitPage(driver, wait);
        }
        else {
            return (T) this;
        }
    }

    public boolean isPageLoaded() throws IOException {
        return getCurrentUrl().equals(ConfigProperties.getProperty("webUrl"))
                && getCurrentTitle().equals("Вход в LinkedIn, Войти | LinkedIn")
                && enterButton.isDisplayed();
    }
}
