package headerTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.URLs;
import org.testng.annotations.Test;

public class ProductsDropdownTest extends BaseTest {
    private HeaderBasePage headerBasePage;

    @Test
    public void checkProductsDropdown() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        headerBasePage = new HeaderBasePage(getDriver());
        headerBasePage.checkProductsItems();
    }

    @Test
    public void checkPeopleExperienceSuiteLink() {

    }
}
