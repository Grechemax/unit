package products;


import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.CityOfPortPage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.FinancialsPage;
import pageObjects.products.HumanCapitalManagementPage;

public class HumanCapitalManagementTest extends BaseTest {
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private CityOfPortPage cityOfPortPage = new CityOfPortPage(getDriver());
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
        BasePage.openURL(URLs.PRODUCTS_HUMAN_CAPITAL.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isEnergizeYourPeopleTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isHumanCapitalManagementDeliversTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isCreateBetterWayTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isCityOfPortTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isTrustedOrganizationsTitlePresent());
    }

    @Test
    public void checkHumanCapitalPageBreadCrumb() {
        BasePage.openURL(URLs.PRODUCTS_HUMAN_CAPITAL.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }

    @Test
    public void checkAllTitlesText() {
        BasePage.openURL(URLs.PRODUCTS_HUMAN_CAPITAL.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertEquals(humanCapitalManagementPage.getMainTitleText(), "Unit4 Human Capital Management");
        Assert.assertEquals(humanCapitalManagementPage.getEnergizeYourPeopleTitleText(), "Energize Your People");
        Assert.assertEquals(humanCapitalManagementPage.getHumanCapitalManagementDeliversTitleText(), "Unit4 Human Capital Management Delivers");
        Assert.assertEquals(humanCapitalManagementPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(humanCapitalManagementPage.getCityOfPortTitleTitleText(), "Customer Story: LGSS");
        Assert.assertEquals(humanCapitalManagementPage.getTrustedOrganisationsTitleText(), "Trusted worldwide by organizations that serve people");
    }

    @Test
    public void checkPanelTitlesPresent() {
        BasePage.openURL(URLs.PRODUCTS_HUMAN_CAPITAL.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(humanCapitalManagementPage.isHRSectionTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isRecruitmentSectionTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isPeoplePlanningSectionTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isPayrollManagementSectionTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isTalentManagement_LearningSectionTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isTalentManagement_PerformanceSectionTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isTalentManagement_EngagementSectionTitlePresent());


    }

    @Test()
    public void openRequestDemoViaHeader() {
        BasePage.openURL(URLs.PRODUCTS_HUMAN_CAPITAL.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test()
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.PRODUCTS_HUMAN_CAPITAL.URL());
        cookiesPanelPage.acceptCookies();
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    // Customer Overview: City of Port
//    @Test
//    public void checkReadMoreOpensCityOfPortPage() {
//        BasePage.openURL(URLs.PRODUCTS_HUMAN_CAPITAL.URL());
//        cookiesPanelPage.acceptCookies();
//        humanCapitalManagementPage.clickReadMoreAboutCityOfPort();
//        Assert.assertTrue(cityOfPortPage.isCityOfPortMainTitlePresent());
//        Assert.assertTrue(breadCrumbsBasePage.isCityOfPortCrumbVisible());
//    }

    @Test
    public void checkReadOurCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(URLs.PRODUCTS_HUMAN_CAPITAL.URL());
        cookiesPanelPage.acceptCookies();
        humanCapitalManagementPage.clickSeeMoreCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    //Looking for one of our other Unit4 solutions?
    @Test
    public void checkLinkOpensERPPage() {
        BasePage.openURL(URLs.PRODUCTS_HUMAN_CAPITAL.URL());
        cookiesPanelPage.acceptCookies();
        humanCapitalManagementPage.clickERPLink();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
    }

    @Test
    public void checkLinkOpensFinancialPlanningPage() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        humanCapitalManagementPage.clickFPALink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
    }

    @Test
    public void checkLinkOpensHumanCapitalManagementPage() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        humanCapitalManagementPage.clickHCMLink();
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
    }

    @Test
    public void checkLinkOpensFinancialsPage() {
        BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
        cookiesPanelPage.acceptCookies();
        humanCapitalManagementPage.clickFinancialsLink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialsCrumbVisible());
        Assert.assertTrue(financialsPage.isFinancialsPageMainTitlePresent());
    }

        @Test
        public void downloadPDFOpensPDF() {
            BasePage.openURL(URLs.PRODUCTS_ERP.URL());
            cookiesPanelPage.acceptCookies();
            humanCapitalManagementPage.clickDownloadProductBrochureBtn();
            BasePage.switchToLastTab();
            Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
        }

//        @Test
//        public void downloadTheReportButtonOpensPage() {
//            BasePage.openURL(URLs.PRODUCTS_FINANCIAL_PLANNING.URL());
//            cookiesPanelPage.acceptCookies();
//            humanCapitalManagementPage.clickDownloadTheReportBtn();
//            BasePage.switchToLastTab();
//            Assert.assertTrue(BasePage.isCurrentUrlContains("employee-engagement-trends"));
//        }
}
