package test;

import base.TestBase;
import org.testng.annotations.Test;
import page.FirstPage;

import java.io.IOException;

public class InitiateTest extends TestBase {

    public InitiateTest() {
        super();
    }

    @Test
    public void count_iFrames_test() throws InterruptedException {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.countIFramesOnPage();
    }

    @Test (priority = 1)
    public void index_iFrame_test1() throws IOException, InterruptedException {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.switchToFrameWithFrameIndex();
    }

    @Test (priority = 2)
    public void id_iFrame_test2() throws IOException, InterruptedException {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.switchToFrameWithFrameIndex();
    }

    @Test (priority = 3)
    public void webElement_iFrame_test3() throws IOException, InterruptedException {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.switchToFrameWithFrameIndex();
    }
}
