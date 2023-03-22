package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;

    @BeforeTest
    @Parameters({ "browser" })
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("security.sandbox.content.level", 5);
//            profile.setPreference("browser.privatebrowsing.autostart", true);
            profile.setPreference("dom.disable_beforeunload", true);
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C://Program Files//Google//Chrome//Application//chrome.exe");
            options.addArguments("--start-maximized");
//            options.addArguments("incognito");
            options.addArguments("chrome.switches", "--disable-extensions");
            driver = new ChromeDriver(options);
        } else {
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}
