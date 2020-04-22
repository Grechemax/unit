package products;

import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.WarChildPage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.FinancialsPage;
import pageObjects.products.HumanCapitalManagementPage;


public class EnterpriseResourcePlanningTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
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

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isWarChildPresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isExperienceSuiteTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isCreateBetterWayTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isElevateYourBusinessTitlePresent());
    }

    @Test
    public void checkERPPageBreadCrumb() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }

    @Test
    public void checkAllTitlesText() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        Assert.assertEquals(enterpriseResourcePlanningPage.getWarChildTitleText(), "Customer Overview: War Child");
        Assert.assertEquals(enterpriseResourcePlanningPage.getMainTitleText(), "Unit4 Enterprise Resource Planning");
        Assert.assertEquals(enterpriseResourcePlanningPage.getElevateYourBusinessTitleText(), "Elevate Your Business");
        Assert.assertEquals(enterpriseResourcePlanningPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(enterpriseResourcePlanningPage.getExperienceSuiteTitleText(), "Unit4 ERP Delivers");
    }


    @Test
    public void checkPanelTitlesPresent() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
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
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test()
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    // Customer Overview: War Child
    @Test
    public void checkReadMoreOpensWarChildPage() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        enterpriseResourcePlanningPage.clickReadMoreAboutWarChild();
        Assert.assertTrue(breadCrumbsBasePage.isWarChildCrumbVisible());
        Assert.assertTrue(warChildPage.isWarChildMainTitlePresent());
    }

    //Read Customers stories
    @Test
    public void checkReadOurCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        enterpriseResourcePlanningPage.clickReadCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    //Looking for one of our other Unit4 solutions?
    @Test
    public void checkLinkOpensERPPage() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        enterpriseResourcePlanningPage.clickERPLink();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
    }

    @Test
    public void checkLinkOpensFinancialPlanningPage() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        enterpriseResourcePlanningPage.clickFPALink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
    }

    @Test
    public void checkLinkOpensHumanCapitalManagementPage() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        enterpriseResourcePlanningPage.clickHCMLink();
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
    }

    @Test
    public void checkLinkOpensFinancialsPage() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        enterpriseResourcePlanningPage.clickFinancialsLink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialsCrumbVisible());
        Assert.assertTrue(financialsPage.isFinancialsPageMainTitlePresent());
    }

    @Test
    public void downloadPDFOpensPDF() {
        BasePage.openURL(URLs.PRODUCTS_ERP.URL());
        homePage.acceptCookies();
        enterpriseResourcePlanningPage.clickDownloadBrochure();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }
}

