package industriesTests;


import base.*;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.industries.NonprofitPage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.HumanCapitalManagementPage;

public class NonprofitTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private NonprofitPage nonprofitPage = new NonprofitPage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());


    @Test(priority = 1)
    public void checkAllTitlesPresent() {

        BasePage.openURL(Urls.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        Assert.assertTrue(nonprofitPage.isMainTitlePresent());
        Assert.assertTrue(nonprofitPage.isWarChildPresent());
        Assert.assertTrue(nonprofitPage.isLearnMoreBtnPresent());
        Assert.assertTrue(nonprofitPage.isCustomerSuccessTitle());
        Assert.assertTrue(nonprofitPage.isBreakFreeTitlePresent());
        Assert.assertTrue(nonprofitPage.isYourPartnerInNonprofitTitlePresent());
        Assert.assertTrue(nonprofitPage.isYourNewPeopleExperienceTitlePresent());

    }

    @Test(priority = 2)
    public void checkNonProfitCrumb() {
        Assert.assertTrue(breadCrumbsBasePage.isNonProfitCrumbVisible());
    }

    @Test(priority = 3)
    public void checkAllTitlesText() {
        Assert.assertEquals(nonprofitPage.getMainTitleText(), "Nonprofit");
        Assert.assertEquals(nonprofitPage.getYourPartnerInNonprofitTitleText(), "Your Partner in Nonprofit Program Excellence");
        Assert.assertEquals(nonprofitPage.getBreakFreeTitleText(), "Break free from legacy systems");
        Assert.assertEquals(nonprofitPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(nonprofitPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
        Assert.assertEquals(nonprofitPage.getWarChildTitleText(), "Customer Overview: War Child");
    }

    @Test(priority = 4)
    public void checkPanelTitlesPresent() {
        Assert.assertTrue(nonprofitPage.isMakeDecisionsSectionTitlePresent());
        Assert.assertTrue(nonprofitPage.isDeliverMoreSectionTitlePresent());
        Assert.assertTrue(nonprofitPage.isOptimizeFundingSectionTitlePresent());
        Assert.assertTrue(nonprofitPage.isImproveComplianceSectionTitlePresent());
    }

    @Test(priority = 5)
    public void openRequestDemoViaHeader() {
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test(priority = 6)
    public void openRequestDemoViaSection() {
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test(priority = 7)
    public void checkReadMoreOpensERPPage() {
        BasePage.openURL(Urls.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        nonprofitPage.clickReadMoreAboutERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }

    @Test(priority = 8)
    public void checkReadMoreOpensFinancialPlanningPage() {
        BasePage.openURL(Urls.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        nonprofitPage.clickReadMoreAboutFinancialPlanning();
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test(priority = 9)
    public void checkReadMoreOpensHumanCapitalPage() {
        BasePage.openURL(Urls.INDUSTRIES_NONPROFIT.URL());
        homePage.acceptCookies();
        nonprofitPage.clickReadMoreAboutHumanCapital();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }
}
