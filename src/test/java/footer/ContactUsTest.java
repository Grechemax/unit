package footer;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class ContactUsTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());


    @Test
    public void checkContactUsPageCrumb() {
        BasePage.openURL(URLs.CONTACT_US.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isContactUsCrumbVisible());
    }

    @Test
    public void goHomeViaCrumb() {
        BasePage.openURL(URLs.CONTACT_US.URL());
        homePage.acceptCookies();
        breadCrumbsBasePage.goToHomePageViaBreadCrumb();
        Assert.assertTrue(homePage.isMainHeaderPresent());
    }
}
