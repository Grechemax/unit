package productsPageTests;


import base.BasePage;
import base.BaseTest;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.products.HumanCapitalManagementPage;

public class HumanCapitalManagementTest extends BaseTest {
    HomePage homePage;
    HumanCapitalManagementPage humanCapitalManagementPage;


    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage = new HomePage(getDriver());
        humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
        homePage.goToHumanCapitalManagement();
        homePage.acceptCookies();

        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isEnergizeYourPeopleTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isHumanCapitalManagementDeliversTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isCreateBetterWayTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isCityOfPortTitlePresent());
        Assert.assertTrue(humanCapitalManagementPage.isTrustedOrganizationsTitlePresent());
    }

    @Test
    public void checkAllTitlesText() {
        Assert.assertEquals(humanCapitalManagementPage.getMainTitleText(), "Unit4 Human Capital Management");
        Assert.assertEquals(humanCapitalManagementPage.getEnergizeYourPeopleTitleText(), "Energize Your People");
        Assert.assertEquals(humanCapitalManagementPage.getHumanCapitalManagementDeliversTitleText(), "Unit4 Human Capital Management Delivers");
        Assert.assertEquals(humanCapitalManagementPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(humanCapitalManagementPage.getCityOfPortTitleTitleText(), "City of Port Coquitlam");
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
}
