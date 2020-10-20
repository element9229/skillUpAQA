package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LinkedInSearchPage extends BasePage{

    @FindBy(css = "[class*='search-results__total']")
    private WebElement searchPageMainElement;

    @FindBy(css = "[class*='search-result--person']")
    private List<WebElement> searchResultPersons;

    public LinkedInSearchPage(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.wait = webDriverWait;
        PageFactory.initElements(driver, this);
        waitUntilElementIsVisible(searchPageMainElement);
    }

    public int getSearchResultSize(){
        return searchResultPersons.size();
    }

    public List<String> getSearchResults(){
        List<String> result = new ArrayList<>();

        for (WebElement element : searchResultPersons) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            result.add(element.getText());
        }
        return result;
    }

    public boolean isPageLoaded() {
        return getCurrentUrl().contains("https://www.linkedin.com/search/results/all/");
    }
}
