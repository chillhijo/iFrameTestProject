package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.w3c.dom.Document;

import java.util.List;

public class MainGame {

    WebDriver driver;

    public MainGame(WebDriver driver) {
        this.driver = driver;
    }


    public void waitPageToLoad() throws InterruptedException {
        String expectedUrl = "https://nrgs-b2b.greentube.com/Nrgs/B2B/Adapter/UnibetIframe/v1/games/launch/game?channel=Desktop&useRealmoney=false&lang=hr&region=MT&gameID=102";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println(expectedUrl);
        System.out.println(actualUrl);
        Thread.sleep(11000);
    }

    public void numberOfIFrame() {
        int numberOfIFrames = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames is:" + numberOfIFrames);
    }

    public void locateIFrame() {
        WebElement firstFrame = driver.findElement(By.tagName("iframe"));
        System.out.println("This element is shown: " + firstFrame.isDisplayed());
    }

    public void switchToFirstIFrame() {
        driver.switchTo().frame(0);
    }

    public void checkIsThereTitleElement() {
        List<WebElement> titleElement = driver.findElements(By.tagName("title"));
        if (titleElement.size() > 0) {
            System.out.println("Title element is found on the page");
        }
        else {
            System.out.println("Title element is not found on the page");
        }
    }

    public void getText() {
        WebElement titleText = driver.findElement(By.xpath("/html/head/title"));
        System.out.println("Title tag name is: " + titleText.getTagName());
        System.out.println("Title text is: " + titleText.getAttribute("text"));

    }
}

