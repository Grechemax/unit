package products;

import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.FHstPoltenPage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.FinancialsPage;
import pageObjects.products.HumanCapitalManagementPage;

public class FinancialPlanningTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private FHstPoltenPage fHstPoltenPage = new FHstPoltenPage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());

    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());

    private FinancialsPage financialsPage = new FinancialsPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();

        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(financialPlanningPage.isGainMeaningfulInsightsTitlePresent());
        Assert.assertTrue(financialPlanningPage.isFinancialPlanningTitlePresent());
        Assert.assertTrue(financialPlanningPage.isCreateBetterWayTitleTitlePresent());
        Assert.assertTrue(financialPlanningPage.isCustomerStoryPresent());
        Assert.assertTrue(financialPlanningPage.isTrustedOrganizationsTitlePresent());
    }

    @Test
    public void checkAllTitlesText() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertEquals(financialPlanningPage.getAustrianUniversityTitleText(), "Customer Overview: FH St Pölten");
        Assert.assertEquals(financialPlanningPage.getMainTitleText(), "Unit4 Financial Planning & Analysis");
        Assert.assertEquals(financialPlanningPage.getMeaningfulInsightsTitleText(), "Gain Meaningful Insights");
        Assert.assertEquals(financialPlanningPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(financialPlanningPage.getFinancialPlanningTitleText(), "Unit4 Financial Planning & Analysis Delivers");
        Assert.assertEquals(financialPlanningPage.getTrustedOrganizationsTitleText(), "Trusted worldwide by organizations that serve people");
    }

    @Test
    public void checkPanelTitlesPresent() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(financialPlanningPage.isIfrs16SectionHeaderPresent());
        Assert.assertTrue(financialPlanningPage.isSalesPlanningSideHeaderPresent());
        Assert.assertTrue(financialPlanningPage.isFinancialPlanningSideHeaderPresent());
        Assert.assertTrue(financialPlanningPage.isPeoplePlanningSectionHeaderPresent());
        Assert.assertTrue(financialPlanningPage.isAnalyticsReportingSectionHeaderPresent());
        Assert.assertTrue(financialPlanningPage.isCorporatePerformanceSectionHeaderPresent());
        Assert.assertTrue(financialPlanningPage.isFinalConsolidationSectionHeaderPresent());
    }

    @Test
    public void checkFinancialPlanningCrumb() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test()
    public void openRequestDemoViaHeader() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test()
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test
    public void checkReadMoreOpensPDFPage() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }

    @Test
    public void checkSeeMoreOpensCustomersPage() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        financialPlanningPage.clickSeeMoreCustomersStories();
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
    }

    //Looking for one of our other Unit4 solutions?
    @Test
    public void checkLinkOpensERPPage() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        financialPlanningPage.clickERPLink();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
    }

    @Test
    public void checkLinkOpensFinancialPlanningPage() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        financialPlanningPage.clickFPALink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
    }

    @Test
    public void checkLinkOpensHumanCapitalManagementPage() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        financialPlanningPage.clickHCMLink();
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
    }

    @Test
    public void checkLinkOpensFinancialsPage() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        financialPlanningPage.clickFinancialsLink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialsCrumbVisible());
        Assert.assertTrue(financialsPage.isFinancialsPageMainTitlePresent());
    }

    @Test
    public void downloadPDFOpensPDF() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        financialPlanningPage.clickDownloadBrochure();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }

    @Test
    public void downloadResearchBundleOpensRouteToFPAPage() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        financialPlanningPage.clickDownloadResearchBundle();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains("TheroutetoFPAleadership"));
    }

    @Test
    public void returnToHomePageViaLogo() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        financialPlanningPage.clickMainLogo();
        Assert.assertTrue(homePage.isMainHeaderPresent());
    }
}
