package productsPageTests;

import base.*;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.products.EnterpriseResourcePlanningPage;


public class EnterpriseResourcePlanningTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage =  new EnterpriseResourcePlanningPage(getDriver());

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isWarChildPresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isExperienceSuiteTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isCreateBetterWayTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isElevateYourBusinessTitlePresent());
    }

    @Test
    public void checkERPPageBreadCrumb() {
        BasePage.openURL(Urls.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }

    @Test
    public void checkAllTitlesText() {
        BasePage.openURL(Urls.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        Assert.assertEquals(enterpriseResourcePlanningPage.getWarChildTitleText(), "Customer Overview: War Child");
        Assert.assertEquals(enterpriseResourcePlanningPage.getMainTitleText(), "Unit4 Enterprise Resource Planning");
        Assert.assertEquals(enterpriseResourcePlanningPage.getElevateYourBusinessTitleText(), "Elevate Your Business");
        Assert.assertEquals(enterpriseResourcePlanningPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(enterpriseResourcePlanningPage.getExperienceSuiteTitleText(), "Unit4 ERP Delivers");
    }


    @Test
    public void checkPanelTitlesPresent() {
        BasePage.openURL(Urls.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        Assert.assertTrue(enterpriseResourcePlanningPage.isHRSectionTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isFinancialManagementHeaderPresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isProjectManagementSectionTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isOperationalReportingSectionTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isProcurementManagementSectionTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isFieldServiceManagementSectionTitlePresent());
    }

    @Test()
    public void openRequestDemoViaHeader() {
        BasePage.openURL(Urls.PRODUCTS_ERP.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test()
    public void openRequestDemoViaSection() {
        BasePage.openURL(Urls.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }
}

