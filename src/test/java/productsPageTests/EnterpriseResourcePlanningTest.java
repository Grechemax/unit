package productsPageTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.products.EnterpriseResourcePlanningPage;


public class EnterpriseResourcePlanningTest extends BaseTest {
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage;

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
        enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());
        headerBasePage.goToEnterpriseResourcePlaning();

        Assert.assertTrue(enterpriseResourcePlanningPage.isMainTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isWarChildPresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isExperienceSuiteTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isCreateBetterWayTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isElevateYourBusinessTitlePresent());
    }

    @Test
    public void checkAllTitlesText() {
        Assert.assertEquals(enterpriseResourcePlanningPage.getWarChildTitleText(), "War Child");
        Assert.assertEquals(enterpriseResourcePlanningPage.getMainTitleText(), "Unit4 Enterprise Resource Planning");
        Assert.assertEquals(enterpriseResourcePlanningPage.getElevateYourBusinessTitleText(), "Elevate Your Business");
        Assert.assertEquals(enterpriseResourcePlanningPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(enterpriseResourcePlanningPage.getExperienceSuiteTitleText(), "The Unit4 People Experience Suite will humanize how your vital work gets done.");
    }


    @Test
    public void checkPanelTitlesPresent() {
        Assert.assertTrue(enterpriseResourcePlanningPage.isHRSectionTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isFinancialManagementHeaderPresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isProjectManagementSectionTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isOperationalReportingSectionTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isProcurementManagementSectionTitlePresent());
        Assert.assertTrue(enterpriseResourcePlanningPage.isFieldServiceManagementSectionTitlePresent());
    }
}

