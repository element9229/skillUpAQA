import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedInHomePage;
import pages.LinkedInSearchPage;

public class LinkedInMainLoginTests extends BaseTest {

    @Test
    public void searchSomeDataUsingGoogleForm() throws Exception {
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");

        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login("clarizenapi@gmail.com","MadjikMadjik123");

        Assert.assertTrue(linkedInHomePage.isPageLoaded(),"Home page is not loaded");
    }

    @Test
    public void checkLinkedInSearchFunctionality() throws Exception {
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");

        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login("clarizenapi@gmail.com","MadjikMadjik123");

        Assert.assertTrue(linkedInHomePage.isPageLoaded(),"Home page is not loaded");

        LinkedInSearchPage linkedInSearchPage = linkedInHomePage.search("Automation QA");

        Assert.assertTrue(linkedInSearchPage.isPageLoaded(), "LinkedIn Search page is not displayed");
    }
}
