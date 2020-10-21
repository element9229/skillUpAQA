package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

import java.io.IOException;

public class LinkedinLoginSubmitPage extends BasePage{

    @FindBy(id = "username")
    private WebElement userEmailField;

    @FindBy(id = "password")
    private WebElement userPasswordField;

    @FindBy(xpath = "//button[@data-litms-control-urn='login-submit']")
    private WebElement enterButton;

    @FindBy(id = "error-for-username")
    private WebElement errorForUserName;

    public LinkedinLoginSubmitPage(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.wait = webDriverWait;
        PageFactory.initElements(driver, this);
    }

    public String getErrorMessageForUserName(){
        return errorForUserName.getText();
    }

    public boolean isPageLoaded() {
        return getCurrentUrl().contains("/login-submit")
                && getCurrentTitle().equals("Вход в LinkedIn, Войти | LinkedIn");
    }
}
