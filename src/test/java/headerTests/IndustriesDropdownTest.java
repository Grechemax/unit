package headerTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.URLs;
import org.testng.annotations.Test;

public class IndustriesDropdownTest extends BaseTest {
    HeaderBasePage headerBasePage;

    @Test
    public void checkIndustriesDropdown() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        headerBasePage = new HeaderBasePage(getDriver());
        headerBasePage.checkIndustriesItems();
    }


}
