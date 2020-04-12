package homePageTests;

import base.BasePage;
import data.Urls;
import pageObjects.HomePage;
import base.BaseTest;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {
    private HomePage homePage;


    @Test
    public void homePageTest() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage = new HomePage(getDriver());
        homePage.acceptCookies();
        homePage.checkLogoPresence();
        homePage.checkMainUpperHeader();
        homePage.checkCenterHeader();
    }
}
