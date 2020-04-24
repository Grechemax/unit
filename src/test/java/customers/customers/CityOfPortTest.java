package customers.customers;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.customers.customers.CityOfPortPage;
import pageObjects.products.EnterpriseResourcePlanningPage;


public class CityOfPortTest extends BaseTest {
    CityOfPortPage cityOfPortPage = new CityOfPortPage(getDriver());
    CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());

    @Test
    public void checkAllTitles() {
        BasePage.openURL(URLs.CUSTOMERS_CITY_OF_PORT.URL());
        Assert.assertTrue(cityOfPortPage.isCityOfPortMainTitlePresent());
        Assert.assertTrue(cityOfPortPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(cityOfPortPage.isChallengeTitlePresented());
        Assert.assertTrue(cityOfPortPage.isERPTitlePresent());
        Assert.assertTrue(cityOfPortPage.isImpactsTitlePresent());
    }

    @Test
    public void checkCityOfPortPageBreadCrumb() {
        BasePage.openURL(URLs.CUSTOMERS_CITY_OF_PORT.URL());
        Assert.assertTrue(breadCrumbsBasePage.isCityOfPortCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensRightPage() {
        BasePage.openURL(URLs.CUSTOMERS_CITY_OF_PORT.URL());
        cookiesPanelPage.acceptCookies();
        cityOfPortPage.clickReadMoreButton();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }

    @Test
    public void downloadCaseStudyOpensPDFPage() {
        BasePage.openURL(URLs.CUSTOMERS_CITY_OF_PORT.URL());
        cookiesPanelPage.acceptCookies();
        cityOfPortPage.clickDownloadCaseStudy();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }

}
