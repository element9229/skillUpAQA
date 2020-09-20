import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigProperties;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws Exception{
        String webUrl = ConfigProperties.getProperty("webUrl");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get(webUrl);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
