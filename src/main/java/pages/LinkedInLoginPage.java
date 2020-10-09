package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

import java.io.IOException;

public class LinkedInLoginPage extends BasePage{

    @FindBy(id="username")
    private WebElement userEmailField;

    @FindBy(id="password")
    private WebElement userPasswordField;

    @FindBy(xpath = "//button[@data-litms-control-urn='login-submit']")
    private WebElement enterButton;

    public LinkedInLoginPage(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.wait = webDriverWait;
        PageFactory.initElements(driver, this);
        assertElementIsVisible(enterButton,"Login page is not loaded.");
    }

    public LinkedInHomePage login (String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        enterButton.click();
        return new LinkedInHomePage(driver, wait);
    }

   public boolean isPageLoaded () throws IOException {
        return  getCurrentUrl().equals(ConfigProperties.getProperty("webUrl"))
                && getCurrentTitle().equals("Вход в LinkedIn, Войти | LinkedIn")
                && enterButton.isDisplayed();
   }
}
