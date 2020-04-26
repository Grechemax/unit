package events;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.HomePage;
import pageObjects.events.EventsHomePage;

public class EventsHomeTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    EventsHomePage eventsHomePage = new EventsHomePage(getDriver());
    CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());

    @Test(groups = {"Sanity"})
    public void checkEventsHomePageBreadCrumb() {
        BasePage.openURL(URLs.EVENTS.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isEventsCrumbVisible());
        breadCrumbsBasePage.goToHomePageViaBreadCrumb();
        Assert.assertTrue(homePage.isMainHeaderPresent());
    }

    @Test(groups = {"Sanity"})
    public void showMoreLoadsMoreEventItems() {
        BasePage.openURL(URLs.EVENTS.URL());
        cookiesPanelPage.acceptCookies();
        eventsHomePage.clickShowMoreToLoadMoreEventsItems();
    }
}
