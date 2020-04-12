package productsPageTests;

import base.BasePage;
import base.BaseTest;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.HomePage;

public class FinancialPlanningTest extends BaseTest {
    HomePage homePage;
    FinancialPlanningPage financialPlanningPage;


    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage = new HomePage(getDriver());
        financialPlanningPage = new FinancialPlanningPage(getDriver());
        homePage.goToFinancialPlaning();
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
        Assert.assertEquals(financialPlanningPage.getAustrianUniversityTitleText(), "FH St Pölten");
        Assert.assertEquals(financialPlanningPage.getMainTitleText(), "Unit4 Financial Planning & Analysis");
        Assert.assertEquals(financialPlanningPage.getMeaningfulInsightsTitleText(), "Gain Meaningful Insights");
        Assert.assertEquals(financialPlanningPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(financialPlanningPage.getFinancialPlanningTitleText(), "Unit4 Financial Planning & Analysis Delivers");
        Assert.assertEquals(financialPlanningPage.getTrustedOrganizationsTitleText(), "Trusted worldwide by organizations that serve people");
    }

    @Test
    public void checkPanelTitlesPresent() {
        Assert.assertTrue(financialPlanningPage.isIfrs16SectionHeaderPresent());
        Assert.assertTrue(financialPlanningPage.isSalesPlanningSideHeaderPresent());
        Assert.assertTrue(financialPlanningPage.isFinancialPlanningSideHeaderPresent());
        Assert.assertTrue(financialPlanningPage.isPeoplePlanningSectionHeaderPresent());
        Assert.assertTrue(financialPlanningPage.isAnalyticsReportingSectionHeaderPresent());
        Assert.assertTrue(financialPlanningPage.isCorporatePerformanceSectionHeaderPresent());
        Assert.assertTrue(financialPlanningPage.isFinalConsolidationSectionHeaderPresent());
    }
}
