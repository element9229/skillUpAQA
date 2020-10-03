package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LinkedInHomePage extends BasePage {
    @FindBy(id = "global-nav-typeahead")
    private WebElement searchField;

    @FindBy(css = "[class='search-global-typeahead__input always-show-placeholder']")
    private WebElement searchFieldInput;

    public LinkedInHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search(String searchString) {
        searchField.click();
        searchFieldInput.sendKeys(searchString);
        searchFieldInput.sendKeys(Keys.ENTER);
    }

    public boolean isPageLoaded() throws IOException {
        return getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && getCurrentTitle().equals("LinkedIn")
                && searchField.isDisplayed();
    }
}
