package products;

import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.WarChildPage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.FinancialsPage;
import pageObjects.products.HumanCapitalManagementPage;


public class EnterpriseResourcePlanningTest extends BaseTest {
    private CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    private WarChildPage warChildPage = new WarChildPage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    private FinancialsPage financialsPage = new FinancialsPage(getDriver());
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());

    @Test(groups = {"Sanity"})
    public void checkAllTitlesPresent() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isWarChildPresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isExperienceSuiteTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isCreateBetterWayTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isElevateYourBusinessTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkERPPageBreadCrumb() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void checkAllTitlesText() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertEquals(enterpriseResourcePlanningPage.getWarChildTitleText(), "Customer Overview: War Child");
        Assert.assertEquals(enterpriseResourcePlanningPage.getMainTitleText(), "Unit4 Enterprise Resource Planning");
        Assert.assertEquals(enterpriseResourcePlanningPage.getElevateYourBusinessTitleText(), "Elevate Your Business");
        Assert.assertEquals(enterpriseResourcePlanningPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(enterpriseResourcePlanningPage.getExperienceSuiteTitleText(), "Unit4 ERP Delivers");
    }


    @Test(groups = {"Sanity"})
    public void checkPanelTitlesPresent() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(enterpriseResourcePlanningPage.isHRSectionTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isFinancialManagementHeaderPresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isProjectManagementSectionTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isOperationalReportingSectionTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isProcurementManagementSectionTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isFieldServiceManagementSectionTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaHeader() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    // Customer Overview: War Child
    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensWarChildPage() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        cookiesPanelPage.acceptCookies();
        enterpriseResourcePlanningPage.clickReadMoreAboutWarChild();
        Assert.assertTrue(breadCrumbsBasePage.isWarChildCrumbVisible());
        Assert.assertTrue(warChildPage.isWarChildMainTitlePresent());
    }

    //Read Customers stories
    @Test(groups = {"Sanity"})
    public void checkReadOurCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        cookiesPanelPage.acceptCookies();
        enterpriseResourcePlanningPage.clickReadCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    //Looking for one of our other Unit4 solutions?
    @Test(groups = {"Sanity"})
    public void checkLinkOpensERPPage() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        cookiesPanelPage.acceptCookies();
        enterpriseResourcePlanningPage.clickERPLink();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkLinkOpensFinancialPlanningPage() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        cookiesPanelPage.acceptCookies();
        enterpriseResourcePlanningPage.clickFPALink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkLinkOpensHumanCapitalManagementPage() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        cookiesPanelPage.acceptCookies();
        enterpriseResourcePlanningPage.clickHCMLink();
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkLinkOpensFinancialsPage() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        cookiesPanelPage.acceptCookies();
        enterpriseResourcePlanningPage.clickFinancialsLink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialsCrumbVisible());
        Assert.assertTrue(financialsPage.isFinancialsPageMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void downloadPDFOpensPDF() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        cookiesPanelPage.acceptCookies();
        enterpriseResourcePlanningPage.clickDownloadBrochure();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }
}

