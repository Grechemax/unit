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
    LocationsHomePage locationsHomePage = new LocationsHomePage(getDriver());
    HomePage homePage = new HomePage(getDriver());


    @Test
    public void compareLocationsNamesWithPages() {
        BasePage.openURL(URLs.LOCATIONS.URL());
        homePage.acceptCookies();
        locationsHomePage.compareLocationsNamesWithPages();
    }

}
