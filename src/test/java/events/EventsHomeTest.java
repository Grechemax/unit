package events;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.events.EventsHomePage;

public class EventsHomeTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    EventsHomePage eventsHomePage = new EventsHomePage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());

    @Test
    public void checkEventsHomePageBreadCrumb() {
        BasePage.openURL(URLs.EVENTS.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isEventsCrumbVisible());
        breadCrumbsBasePage.goToHomePageViaBreadCrumb();
        Assert.assertTrue(homePage.isMainHeaderPresent());
    }

    @Test
    public void showMoreLoadsMoreEventItems() {
        BasePage.openURL(URLs.EVENTS.URL());
        homePage.acceptCookies();
        eventsHomePage.clickShowMoreToLoadMoreEventsItems();
    }
}
