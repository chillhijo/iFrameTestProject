package page;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FirstPage extends PageBase {

    public FirstPage(WebDriver driver) {
        super(driver);
        driver.get("https://nrgs-b2b.greentube.com/Nrgs/B2B/Adapter/UnibetIframe/v1/games/launch/game?channel=Desktop&useRealmoney=false&lang=hr&region=MT&gameID=102");
    }

    public void countIFramesOnPage() throws InterruptedException {
        Thread.sleep(10000);

        int numberOfIFramesInPage = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames on page is: " + numberOfIFramesInPage);

        WebElement gameFrame1 = driver.findElement(By.id("game"));

        driver.switchTo().frame(gameFrame1);

        List<WebElement> elements = driver.findElements(By.xpath("//*"));
        for (WebElement element : elements) {
            System.out.println(element.getTagName());
        }

        WebElement titleElement = driver.findElement(By.tagName("title"));
        String pageTitle = titleElement.getTagName();
        String pageTitleText = driver.getTitle();
        System.out.println("Element tag name is: " + pageTitle);
        System.out.println("Element text is: " + pageTitleText);
    }

    public void switchToFrameWithFrameIndex() throws InterruptedException {
        Thread.sleep(20000);
        driver.switchTo().frame(0);

        WebElement titleElement = driver.findElement(By.tagName("head"));
        String pageTitle = titleElement.getText();
        System.out.println("Page title is: " + pageTitle);
    }

    public void switchToFrameWithFrameId() throws InterruptedException {
        Thread.sleep(20000);
        driver.switchTo().frame("name");

        WebElement titleElement = driver.findElement(By.tagName("title"));
        String pageTitle = titleElement.getText();
        System.out.println("Page title is: " + pageTitle);
    }

    public void switchToFrameByWebElement() throws InterruptedException {
        Thread.sleep(20000);

        WebElement gameFrame = driver.findElement(By.id("game"));

        driver.switchTo().frame(gameFrame);

        WebElement titleElement = driver.findElement(By.tagName("title"));
        String pageTitle = titleElement.getText();
        System.out.println("Page title is: " + pageTitle);
    }

}
