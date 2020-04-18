package homePageTests;

import base.BasePage;
import base.BaseTest;
import data.URLs;
import org.testng.annotations.Test;


public class CheckHomePageLinksTest extends BaseTest {

    @Test
    public void checkHomePageLinks() {
        BasePage.checkLinks(URLs.HOME_PAGE.URL());

    }
}
