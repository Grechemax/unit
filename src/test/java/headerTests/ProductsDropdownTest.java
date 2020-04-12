package headerTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.Urls;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class ProductsDropdownTest extends BaseTest {
    private HeaderBasePage headerBasePage;

    @Test
    public void checkProductsDropdown() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        headerBasePage = new HeaderBasePage(getDriver());
        headerBasePage.checkIndustriesItems();
    }

    @Test
    public void checkPeopleExperienceSuiteLink() {

    }
}
