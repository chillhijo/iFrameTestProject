package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.MainGame;

public class TestGame {

    WebDriver driver;

    @BeforeTest
    public void startTheBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C://Program Files//Google//Chrome//Application//chrome.exe");
        options.addArguments("--start-maximized");
        options.addArguments("chrome.switches", "--disable-extensions");
        driver = new ChromeDriver(options);
        driver.get("https://nrgs-b2b.greentube.com/Nrgs/B2B/Adapter/UnibetIframe/v1/games/launch/game?channel=Desktop&useRealmoney=false&lang=hr&region=MT&gameID=102");
    }

    @AfterTest
    public void closeTheBrowser() {driver.quit();}

    @Test
    public void test() throws InterruptedException {
        MainGame mainGame = new MainGame(driver);
        mainGame.waitPageToLoad();
        mainGame.numberOfIFrame();
        mainGame.locateIFrame();
        mainGame.switchToFirstIFrame();
        mainGame.checkIsThereTitleElement();
        mainGame.getText();
    }
}
