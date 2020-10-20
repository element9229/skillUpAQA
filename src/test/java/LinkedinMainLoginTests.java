import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LinkedInSearchPage;
import pages.LinkedinHomePage;
import pages.LinkedinLoginPage;
import pages.LinkedinLoginSubmitPage;

import java.io.IOException;

public class LinkedinMainLoginTests extends BaseTest {

    /***
     * Generate valid DataProvider with `userEmail` and `userPassword`
     * (required for positive tests)
     * @return an Object with `userEmail` and `userPassword`
     */
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"clarizenapi@gmail.com", "MadjikMadjik123"}
        };
    }

    /***
     * Generate un-valid DataProvider with fake `userEmail` and `userPassword`
     * (required for negative tests)
     * @return an Object with fake `userEmail` and `userPassword`
     */
    @DataProvider
    public Object[][] notValidDataProvider() {
        return new Object[][]{
                {"dasdsad12312@gmail.com", "wrong12312312"}
        };
    }

    /***
     * Check successful login to Linkedin account.
     *
     * Preconditions:
     * - Open new browser;
     * - navigate to linkedin.com;
     *
     * Scenario:
     * - Verify that login page is loaded
     * - Insert `userEmail`
     * - Insert `userPassword`
     * - Click on `Sign In\Enter` button
     * - Verify `Home` page is loaded
     *
     * @param userEmail
     * @param userPassword
     * @throws Exception
     */
    @Test(dataProvider = "validDataProvider")
    public void checkSuccessfulLoginToLinkedin(String userEmail, String userPassword) throws Exception {

        logger.info("=====> Start `checkSuccessfulLoginToLinkedin` test");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail, userPassword);

        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Home page is not loaded");

        logger.info("<=====End `checkSuccessfulLoginToLinkedin` test");
    }

//    /***
//     * Validate LinkedIn search functionality by providing text value `Automation QA` in search field
//     *
//     * Preconditions:
//     * - Open new browser;
//     * - navigate to linkedin.com;
//     * - login to LinkedInt account
//     *
//     * Scenario:
//     * - insert text value `Automation QA` to search filed and click enter
//     *
//     * Expected Result
//     * - get 10 records with searched criteria
//     *
//     * @param userEmail
//     * @param userPassword
//     * @throws Exception
//     */
//    @Test(dataProvider = "validDataProvider")
//    public void checkLinkedInSearchFunctionality(String userEmail, String userPassword) throws Exception {
//        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");
//
//        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail, userPassword);
//
//        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Home page is not loaded");
//
//        LinkedInSearchPage linkedInSearchPage = linkedinHomePage.search("Automation QA");
//
//        Assert.assertTrue(linkedInSearchPage.isPageLoaded(), "LinkedIn Search page is not displayed");
//    }
//
//    /***
//     *
//     * Validate you can't login with empty `userEmail` and `userPassword`
//     *
//     * Preconditions:
//     * - Open new browser;
//     * - navigate to linkedin.com;
//     *
//     * Scenario:
//     * - Insert empty `userEmail`
//     * - Insert empty `userPassword`
//     * - Click on `Sign In\Enter` button
//     * - Verify you still on the `LoginPage`
//     *
//     * @throws IOException
//     */
//    @Test
//    public void emptyUserEmailAndUserPasswordTest() throws IOException {
//        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");
//
//        LinkedinLoginPage linkedinLoginPages = linkedinLoginPage.login("", "");
//
//        Assert.assertTrue(linkedinLoginPages.isPageLoaded(), "Home page is not loaded");
//    }
//
//    /***
//     * Validate LinkedIn exception when provide wrong `userEmail` and `userPassword`
//     *
//     *
//     * Preconditions:
//     * - Open new browser;
//     * - navigate to linkedin.com;
//     *
//     * Scenario:
//     * - Insert wrong `userEmail`
//     * - Insert wrong `userPassword`
//     * - Click on `Sign In\Enter` button
//     * - Verify you can see appropriate error message
//     *                      `Hmm, we don't recognize that email. Please try again.`
//     *
//     * @param userEmail
//     * @param userPassword
//     * @throws Exception
//     */
//    @Test(dataProvider = "notValidDataProvider")
//    public void negativeLoginTest(String userEmail, String userPassword) throws Exception {
//        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");
//
//        LinkedinLoginSubmitPage linkedinSubmitPage = linkedinLoginPage.login(userEmail, userPassword);
//
//        Assert.assertTrue(linkedinSubmitPage.isPageLoaded(), "Submit page is loaded");
//
//        Assert.assertEquals(linkedinSubmitPage.getErrorMessageForUserName(), "Hmm, we don't recognize that email. Please try again.");
//    }
}
