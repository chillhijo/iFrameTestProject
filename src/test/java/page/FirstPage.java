package page;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstPage extends PageBase {

    public FirstPage(WebDriver driver) {
        super(driver);
        driver.get("https://nrgs-b2b.greentube.com/Nrgs/B2B/Adapter/UnibetIframe/v1/games/launch/game?channel=Desktop&useRealmoney=false&lang=hr&region=MT&gameID=102");
    }

    @FindBy(xpath = "//iframe[@id='game']")
    private WebElement idOfFrame;

    public void runTheWebSite() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOfFrame));
        Thread.sleep(20000);
        driver.switchTo().frame(idOfFrame);

        WebElement titleElement = driver.findElement(By.tagName("title"));
        String pageTitle = titleElement.getAttribute("textContent");
        System.out.println("Page title is: " + pageTitle);
    }

}
