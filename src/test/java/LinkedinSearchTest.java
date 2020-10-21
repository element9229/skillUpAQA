import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedInSearchPage;
import pages.LinkedinHomePage;

import java.util.List;

public class LinkedinSearchTest extends BaseTest{

    /***
     * Validate LinkedIn search functionality by providing text value `Automation QA` in search field
     *
     * Preconditions:
     * - Open new browser;
     * - navigate to linkedin.com;
     * - login to LinkedInt account
     *
     * Scenario:
     * - insert text value `Automation QA` to search filed and click enter
     *
     * Expected Result
     * - get 10 records with searched criteria
     * - check that each search result contains `Automation QA`
     *
     * @throws Exception
     */
    @Test
    public void checkLinkedInSearchFunctionality() throws Exception {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login("clarizenapi@gmail.com", "MadjikMadjik123");

        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Home page is not loaded");

        LinkedInSearchPage linkedInSearchPage = linkedinHomePage.search("Automation QA");

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

