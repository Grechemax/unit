package industries;


import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.news.NewsHomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.WarChildPage;
import pageObjects.industries.NonprofitPage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.HumanCapitalManagementPage;

public class NonprofitTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private NewsHomePage newsHomePage = new NewsHomePage(getDriver());
    private NonprofitPage nonprofitPage = new NonprofitPage(getDriver());
    private WarChildPage warChildPage = new WarChildPage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());


    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        Assert.assertTrue(nonprofitPage.isNonprofitMainTitlePresent());
        Assert.assertTrue(nonprofitPage.isWarChildPresent());
        Assert.assertTrue(nonprofitPage.isLearnMoreBtnPresent());
        Assert.assertTrue(nonprofitPage.isCustomerSuccessTitle());
        Assert.assertTrue(nonprofitPage.isBreakFreeTitlePresent());
        Assert.assertTrue(nonprofitPage.isYourPartnerInNonprofitTitlePresent());
        Assert.assertTrue(nonprofitPage.isYourNewPeopleExperienceTitlePresent());

    }

    @Test
    public void checkNonProfitCrumb() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isNonProfitCrumbVisible());
    }

    @Test
    public void checkAllTitlesText() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        Assert.assertEquals(nonprofitPage.getMainTitleText(), "Nonprofit");
        Assert.assertEquals(nonprofitPage.getYourPartnerInNonprofitTitleText(), "Your Partner in Nonprofit Program Excellence");
        Assert.assertEquals(nonprofitPage.getBreakFreeTitleText(), "Break free from legacy systems");
        Assert.assertEquals(nonprofitPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(nonprofitPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
        Assert.assertEquals(nonprofitPage.getWarChildTitleText(), "Customer Overview: War Child");
    }

    @Test
    public void checkPanelTitlesPresent() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        Assert.assertTrue(nonprofitPage.isMakeDecisionsSectionTitlePresent());
        Assert.assertTrue(nonprofitPage.isDeliverMoreSectionTitlePresent());
        Assert.assertTrue(nonprofitPage.isOptimizeFundingSectionTitlePresent());
        Assert.assertTrue(nonprofitPage.isImproveComplianceSectionTitlePresent());
    }

    @Test
    public void openRequestDemoViaHeader() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    //Your New Unit4 People Experience Suite
    @Test
    public void checkReadMoreOpensERPPage() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        nonprofitPage.clickReadMoreAboutERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensFinancialPlanningPage() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        nonprofitPage.clickReadMoreAboutFinancialPlanning();
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensHumanCapitalPage() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        nonprofitPage.clickReadMoreAboutHumanCapital();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }

    // Customer Overview: War Child
    @Test
    public void checkReadMoreOpensWarChildPage() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        nonprofitPage.clickReadMoreAboutWarChild();
        Assert.assertTrue(breadCrumbsBasePage.isWarChildCrumbVisible());
        Assert.assertTrue(warChildPage.isWarChildMainTitlePresent());
    }

    @Test
    public void checkSeeMoreCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        nonprofitPage.clickSeeMoreCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    @Test
    public void checkSeeAllNewsOpensNewsPage() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        nonprofitPage.clickSeeAllNews();
        Assert.assertTrue(newsHomePage.isNewsHomePageMainHeaderPresent());
        Assert.assertTrue(breadCrumbsBasePage.isNewsHomePageCrumbVisible());
    }

    @Test
    public void learnMoreOpensPDF() {
        BasePage.openURL(URLs.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        nonprofitPage.clickLearnMore();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }
}
