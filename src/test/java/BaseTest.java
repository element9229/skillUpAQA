import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LinkedinLoginPage;
import utils.ConfigProperties;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    private static final int secondsToWait = 10;
    public WebDriver driver;
    public LinkedinLoginPage linkedinLoginPage;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class.getName());

    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethod(@Optional("Chrome") String browserName) throws Exception {

        logger.info("Start init driver");

        switch (browserName) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                break;
        }

        logger.info("End init driver");

        driver.get(ConfigProperties.getProperty("webUrl"));
        linkedinLoginPage = new LinkedinLoginPage(driver, new WebDriverWait(driver, secondsToWait));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {

        String path = String.format("./screenshots/%s.png", result.getName() + result.getStartMillis());
        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(path), true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        driver.quit();
    }

}
