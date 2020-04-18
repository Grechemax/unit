package headerTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.URLs;
import org.testng.annotations.Test;

public class ResourcesDropdownTest extends BaseTest {
    private HeaderBasePage headerBasePage;

    @Test
    public void checkResourcesDropdown() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        headerBasePage = new HeaderBasePage(getDriver());
        headerBasePage.checkResourcesItems();
    }
}
