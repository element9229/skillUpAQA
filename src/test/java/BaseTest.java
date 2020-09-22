import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.ConfigProperties;

public class BaseTest {

    public WebDriver driver;

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
    }
//        String webUrl = ConfigProperties.getProperty("webUrl");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//
//        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
//        driver = new ChromeDriver(options);
//        driver.get(webUrl);

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.quit();
    }
}
