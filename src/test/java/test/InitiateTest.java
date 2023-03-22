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
    public void initiate_test() throws IOException, InterruptedException {
        FirstPage firstPage = new FirstPage(driver);
        firstPage.runTheWebSite();
    }
}
