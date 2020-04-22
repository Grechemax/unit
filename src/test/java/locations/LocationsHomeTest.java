package locations;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import base.Reporter;
import data.URLs;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.locations.LocationsHomePage;

public class LocationsHomeTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    LocationsHomePage locationsHomePage = new LocationsHomePage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());


    @Test
    public void compareLocationsNamesWithPages() {
        BasePage.openURL(URLs.LOCATIONS.URL());
        homePage.acceptCookies();
        locationsHomePage.compareLocationsNamesWithPages();
    }

    @Test
    public void checkLocationsHomeBreadCrumbs() {
        BasePage.openURL(URLs.LOCATIONS.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isLocationsCrumbVisible());
        breadCrumbsBasePage.goToHomePageViaBreadCrumb();
        Assert.assertTrue(homePage.isMainHeaderPresent());
    }
}
