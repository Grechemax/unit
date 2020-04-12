package headerTests;

import base.BasePage;
import base.BaseTest;
import data.Urls;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class ResourcesDropdownTest extends BaseTest {
    private HomePage homePage;

    @Test
    public void checkResourcesDropdown() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage = new HomePage(getDriver());
        homePage.checkResourcesItems();
    }
}
