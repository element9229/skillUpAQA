package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LinkedInSearchPage extends BasePage {

    @FindBy(css = "[class*='search-results__total']")
    private WebElement searchPageMainElement;

    @FindBy(css = "//[class*='search-result--person']")
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

        driver.findElement(By.cssSelector("[class*='search-results__total']")).sendKeys(Keys.CONTROL, Keys.END);
        List<WebElement> totalElements = driver.findElements(By.cssSelector("[class*='search-result--person']"));
        for (WebElement element : totalElements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            result.add(element.getText());
        }
        return result;
    }

    public boolean isPageLoaded() {
        return getCurrentUrl().equals("https://www.linkedin.com/search/results/all/");
    }
}
