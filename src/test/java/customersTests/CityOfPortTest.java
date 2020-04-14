package customersTests;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.customers.CityOfPortPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.products.EnterpriseResourcePlanningPage;


public class CityOfPortTest extends BaseTest {
    HomePage homePage;
    CityOfPortPage cityOfPortPage;
    CustomersHomePage customersHomePage;
    BreadCrumbsBasePage breadCrumbsBasePage;
    EnterpriseResourcePlanningPage enterpriseResourcePlanningPage;

    @Test
    public void checkAllTitles() {
        BasePage.openURL(Urls.CUSTOMERS.URL());
        homePage = new HomePage(getDriver());
        cityOfPortPage = new CityOfPortPage(getDriver());
        customersHomePage = new CustomersHomePage(getDriver());
        enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());
//        homePage.acceptCookies();
        customersHomePage.goToCityOfPortBlock();
        Assert.assertTrue(cityOfPortPage.isCityOfPortMainTitlePresent());
        Assert.assertTrue(cityOfPortPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(cityOfPortPage.isChallengeTitlePresented());
        Assert.assertTrue(cityOfPortPage.isERPTitlePresent());
        Assert.assertTrue(cityOfPortPage.isImpactsTitlePresent());
    }

    @Test
    public void checkReadMoreOpensRightPage() {
        breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
        cityOfPortPage.clickReadMoreButton();
        Assert.assertTrue(enterpriseResourcePlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }

}
