import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SeleniumGoogleSearchTest extends BaseTest {

    @Test
    public void searchSomeDataUsingGoogleForm() throws Exception {

        WebElement element = driver.findElement(By.cssSelector("[role='combobox']"));
        element.click();
        element.clear();
        element.sendKeys("Selenium");
        element.sendKeys(Keys.ENTER);

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='rc']"));

        if (searchResults.size() == 9) {
            System.out.println("The result is correct");
        } else {
            System.out.println("The result is not correct");
        }

//        for (int i =0; i<= searchResults.size()-1; i++) {
//            System.out.println(searchResults.get(i).getText());
//            System.out.println("\n");
//        }

        List<Boolean> toCheck = new ArrayList<Boolean>();

        for (WebElement result : searchResults) {
            String textFromSearchResult = result.getText();
            System.out.println(textFromSearchResult);
            System.out.println("\n");

            if (textFromSearchResult.contains("Selenium")) {
                toCheck.add(true);
            } else {
                toCheck.add(false);
            }
        }

        for (Boolean result : toCheck) {
            System.out.println(result);
        }

        Thread.sleep( 5000);

    }
}

