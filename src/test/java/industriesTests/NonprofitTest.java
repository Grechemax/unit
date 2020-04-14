package industriesTests;


import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.industries.NonprofitPage;

public class NonprofitTest extends BaseTest {
    private NonprofitPage nonprofitPage;

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
        nonprofitPage = new NonprofitPage(getDriver());
        headerBasePage.goToNonProfit();

        Assert.assertTrue(nonprofitPage.isMainTitlePresent());
        Assert.assertTrue(nonprofitPage.isWarChildPresent());
        Assert.assertTrue(nonprofitPage.isLearnMoreBtnPresent());
        Assert.assertTrue(nonprofitPage.isCustomerSuccessTitle());
        Assert.assertTrue(nonprofitPage.isBreakFreeTitlePresent());
        Assert.assertTrue(nonprofitPage.isYourPartnerInNonprofitTitlePresent());
        Assert.assertTrue(nonprofitPage.isYourNewPeopleExperienceTitlePresent());

    }

    @Test
    public void checkAllTitlesText() {
        Assert.assertEquals(nonprofitPage.getMainTitleText(), "Nonprofit");
        Assert.assertEquals(nonprofitPage.getYourPartnerInNonprofitTitleText(), "Your Partner in Nonprofit Program Excellence");
        Assert.assertEquals(nonprofitPage.getBreakFreeTitleText(), "Break free from legacy systems");
        Assert.assertEquals(nonprofitPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(nonprofitPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
        Assert.assertEquals(nonprofitPage.getWarChildTitleText(), "War Child");
    }

    @Test
    public void checkPanelTitlesPresent() {
        Assert.assertTrue(nonprofitPage.isMakeDecisionsSectionTitlePresent());
        Assert.assertTrue(nonprofitPage.isDeliverMoreSectionTitlePresent());
        Assert.assertTrue(nonprofitPage.isOptimizeFundingSectionTitlePresent());
        Assert.assertTrue(nonprofitPage.isImproveComplianceSectionTitlePresent());
    }
}
