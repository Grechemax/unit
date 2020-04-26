package footer;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.HomePage;
import pageObjects.footer.ContactUsPage;

public class ContactUsTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    ContactUsPage contactUsPage = new ContactUsPage(getDriver());
    CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());


    @Test(groups = {"Sanity"})
    public void checkContactUsPageCrumb() {
        BasePage.openURL(URLs.CONTACT_US.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isContactUsCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void goHomeViaCrumb() {
        BasePage.openURL(URLs.CONTACT_US.URL());
        cookiesPanelPage.acceptCookies();
        breadCrumbsBasePage.goToHomePageViaBreadCrumb();
        Assert.assertTrue(homePage.isMainHeaderPresent());
    }

    @Test(groups = {"Sanity"})
    public void compareLocationsNamesWithPages() {
        BasePage.openURL(URLs.CONTACT_US.URL());
        cookiesPanelPage.acceptCookies();
        contactUsPage.compareLocationsNamesWithPages();
    }
}
