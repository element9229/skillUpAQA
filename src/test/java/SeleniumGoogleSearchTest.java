import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedInHomePage;

public class SeleniumGoogleSearchTest extends BaseTest {

    @Test
    public void searchSomeDataUsingGoogleForm1() throws Exception {
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(),"Login page is not loaded");
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login("tarassokal1@gmail.com","yA7TdooR!");
        Assert.assertTrue(linkedInHomePage.isPageLoaded(),"Home page is not loaded");
    }
}
