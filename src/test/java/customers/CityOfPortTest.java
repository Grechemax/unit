package customers;

import base.BasePage;
import base.BaseTest;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.customers.CityOfPortPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.industries.HigherEducationPage;
import pageObjects.products.EnterpriseResourcePlanningPage;


public class CityOfPortTest extends BaseTest {
    CityOfPortPage cityOfPortPage;
    CustomersHomePage customersHomePage;
    EnterpriseResourcePlanningPage enterpriseResourcePlanningPage;

    @Test
    public void checkReadMoreOpensRightPage() {
        BasePage.openURL(Urls.CUSTOMERS.URL());
        cityOfPortPage = new CityOfPortPage(getDriver());
        customersHomePage = new CustomersHomePage(getDriver());
        enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());
        customersHomePage.goToCityOfPortBlock();
        cityOfPortPage.clickReadMoreButton();
        Assert.assertTrue(enterpriseResourcePlanningPage.isMainTitlePresent());
    }
}
