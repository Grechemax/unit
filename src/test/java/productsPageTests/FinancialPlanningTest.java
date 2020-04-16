package productsPageTests;

import base.*;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
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
    private FinancialsPage financialsPage = new FinancialsPage(getDriver());
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.PRODUCTS_FINANCIAL_PLANNING.URL());
        homePage.acceptCookies();

        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(financialPlanningPage.isGainMeaningfulInsightsTitlePresent());
        Assert.assertTrue(financialPlanningPage.isFinancialPlanningTitlePresent());
        Assert.assertTrue(financialPlanningPage.isCreateBetterWayTitleTitlePresent());
        Assert.assertTrue(financialPlanningPage.isAustrianUniversityPresent());
        Assert.assertTrue(financialPlanningPage.isTrustedOrganizationsTitlePresent());
    }

    @Test
    public void checkAllTitlesText() {
        BasePage.openURL(Urls.PRODUCTS_FINANCIAL_PLANNING.URL());
        homePage.acceptCookies();
        Assert.assertEquals(financialPlanningPage.getAustrianUniversityTitleText(), "Customer Overview: FH St Pölten");
        Assert.assertEquals(financialPlanningPage.getMainTitleText(), "Unit4 Financial Planning & Analysis");
        Assert.assertEquals(financialPlanningPage.getMeaningfulInsightsTitleText(), "Gain Meaningful Insights");
        Assert.assertEquals(financialPlanningPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(financialPlanningPage.getFinancialPlanningTitleText(), "Unit4 Financial Planning & Analysis Delivers");
        Assert.assertEquals(financialPlanningPage.getTrustedOrganizationsTitleText(), "Trusted worldwide by organizations that serve people");
    }

    @Test
    public void checkPanelTitlesPresent() {
        BasePage.openURL(Urls.PRODUCTS_FINANCIAL_PLANNING.URL());
        homePage.acceptCookies();
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
        BasePage.openURL(Urls.PRODUCTS_FINANCIAL_PLANNING.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test()
    public void openRequestDemoViaHeader() {
        BasePage.openURL(Urls.PRODUCTS_FINANCIAL_PLANNING.URL());
        homePage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test()
    public void openRequestDemoViaSection() {
        BasePage.openURL(Urls.PRODUCTS_FINANCIAL_PLANNING.URL());
        homePage.acceptCookies();
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test
    public void checkReadMoreOpensFHstPoltenPage() {
        BasePage.openURL(Urls.PRODUCTS_FINANCIAL_PLANNING.URL());
        homePage.acceptCookies();
        financialPlanningPage.clickReadMoreAboutFHstPolten();
        Assert.assertTrue(breadCrumbsBasePage.isFHstPoltenCrumbVisible());
        Assert.assertTrue(fHstPoltenPage.isFHPoltenMainTitlePresent());
    }

    @Test
    public void checkSeeMoreOpensCustomersPage() {
        BasePage.openURL(Urls.PRODUCTS_FINANCIAL_PLANNING.URL());
        homePage.acceptCookies();
        financialPlanningPage.clickSeeMoreCustomersStories();
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
    }

    //Looking for one of our other Unit4 solutions?
    @Test
    public void checkSeeMoreOpensERPPage() {
        BasePage.openURL(Urls.PRODUCTS_FINANCIAL_PLANNING.URL());
        homePage.acceptCookies();
        financialPlanningPage.clickERPLink();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
    }

    @Test
    public void checkSeeMoreOpensFinancialPlanningPage() {
        BasePage.openURL(Urls.PRODUCTS_FINANCIAL_PLANNING.URL());
        homePage.acceptCookies();
        financialPlanningPage.clickFPALink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
    }

    @Test
    public void checkSeeMoreOpensHumanCapitalManagementPage() {
        BasePage.openURL(Urls.PRODUCTS_FINANCIAL_PLANNING.URL());
        homePage.acceptCookies();
        financialPlanningPage.clickHCMLink();
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
    }
    @Test
    public void checkSeeMoreOpensFinancialsPage() {
        BasePage.openURL(Urls.PRODUCTS_FINANCIAL_PLANNING.URL());
        homePage.acceptCookies();
        financialPlanningPage.clickFinancialsLink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialsCrumbVisible());
        Assert.assertTrue(financialsPage.isFinancialsPageMainTitlePresent());
    }

}
