import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LinkedInLoginPage;
import utils.ConfigProperties;

public class BaseTest {

    private static final int secondsToWait = 10;
    public WebDriver driver;
    public LinkedInLoginPage linkedInLoginPage;

    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethod (@Optional("Chrome") String browserName) throws Exception {

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
        driver.get(ConfigProperties.getProperty("webUrl"));
        linkedInLoginPage = new LinkedInLoginPage(driver, new WebDriverWait(driver, secondsToWait));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.quit();
    }
}
