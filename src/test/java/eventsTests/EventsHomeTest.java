package eventsTests;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class EventsHomeTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());

    @Test
    public void checkEventsHomePageBreadCrumb() {
        BasePage.openURL(URLs.EVENTS.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isEventsCrumbVisible());
        breadCrumbsBasePage.goToHomePageViaBreadCrumb();
        Assert.assertTrue(homePage.isMainHeaderPresent());
    }
}
