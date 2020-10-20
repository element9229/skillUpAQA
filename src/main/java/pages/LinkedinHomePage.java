package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedinHomePage extends BasePage {

    @FindBy(id = "global-nav-typeahead")
    private WebElement searchField;

    @FindBy(css = "[class='search-global-typeahead__input always-show-placeholder']")
    private WebElement searchFieldInput;

    public LinkedinHomePage(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.wait = webDriverWait;
        PageFactory.initElements(driver, this);
    }

    public LinkedInSearchPage search(String searchString) {
        searchField.click();
        searchFieldInput.sendKeys(searchString);
        searchFieldInput.sendKeys(Keys.ENTER);
        return new LinkedInSearchPage(driver, wait);
    }

    public boolean isPageLoaded() {
        return getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && getCurrentTitle().equals("LinkedIn")
                && searchField.isDisplayed();
    }

}