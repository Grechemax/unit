package locations;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.HomePage;
import pageObjects.locations.LocationsHomePage;

public class LocationsHomeTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    LocationsHomePage locationsHomePage = new LocationsHomePage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());


    @Test
    public void compareLocationsNamesWithPages() {
        BasePage.openURL(URLs.LOCATIONS.URL());
        cookiesPanelPage.acceptCookies();
        locationsHomePage.compareLocationsNamesWithPages();
    }

    @Test
    public void checkLocationsHomeBreadCrumbs() {
        BasePage.openURL(URLs.LOCATIONS.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isLocationsCrumbVisible());
        breadCrumbsBasePage.goToHomePageViaBreadCrumb();
        Assert.assertTrue(homePage.isMainHeaderPresent());
    }

    @Test
    public void showMoreLoadsMoreLocationItems() {
        BasePage.openURL(URLs.LOCATIONS.URL());
        cookiesPanelPage.acceptCookies();
        locationsHomePage.clickShowMoreToLoadMoreLocationItems();
    }
}
