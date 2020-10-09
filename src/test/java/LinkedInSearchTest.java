import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedInHomePage;
import pages.LinkedInSearchPage;

import java.util.List;

public class LinkedInSearchTest extends BaseTest {
    @Test
    public void checkLinkedInSearchFunctionality() throws Exception {
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login("clarizenapi@gmail.com", "MadjikMadjik123");

        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded");

        LinkedInSearchPage linkedInSearchPage = linkedInHomePage.search("Automation QA");

        Assert.assertTrue(linkedInSearchPage.isPageLoaded(), "LinkedIn Search page is not displayed");

        List<String> searchResult = linkedInSearchPage.getSearchResults();

        for (String elementText : searchResult) {
            Assert.assertTrue(elementText.toLowerCase().contains("Automation".toLowerCase()) ||
                            elementText.toLowerCase().contains("QA".toLowerCase()),
            "Search Text not found in returned results");
        }

        Assert.assertTrue(linkedInSearchPage.getSearchResultSize()>0, "Size Is Empty");
    }
}

