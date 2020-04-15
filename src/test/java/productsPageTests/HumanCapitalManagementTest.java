package productsPageTests;


import base.*;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.products.HumanCapitalManagementPage;

public class HumanCapitalManagementTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());


    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        headerBasePage.goToHumanCapitalManagement();
        homePage.acceptCookies();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isEnergizeYourPeopleTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isHumanCapitalManagementDeliversTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isCreateBetterWayTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isCityOfPortTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isTrustedOrganizationsTitlePresent());
    }

    @Test
    public void checkHumanCapitalPageBreadCrumb() {
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }

    @Test
    public void checkAllTitlesText() {
        Assert.assertEquals(humanCapitalManagementPage.getMainTitleText(), "Unit4 Human Capital Management");
        Assert.assertEquals(humanCapitalManagementPage.getEnergizeYourPeopleTitleText(), "Energize Your People");
        Assert.assertEquals(humanCapitalManagementPage.getHumanCapitalManagementDeliversTitleText(), "Unit4 Human Capital Management Delivers");
        Assert.assertEquals(humanCapitalManagementPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(humanCapitalManagementPage.getCityOfPortTitleTitleText(), "Customer Overview: City of Port Coquitlam");
        Assert.assertEquals(humanCapitalManagementPage.getTrustedOrganisationsTitleText(), "Trusted worldwide by organizations that serve people");
    }

    @Test
    public void checkPanelTitlesPresent() {
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
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test()
    public void openRequestDemoViaSection() {
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }
}
