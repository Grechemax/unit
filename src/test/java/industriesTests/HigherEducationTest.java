package industriesTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.industries.HigherEducationPage;


public class HigherEducationTest extends BaseTest {
    private HigherEducationPage higherEducationPage;

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
        higherEducationPage = new HigherEducationPage(getDriver());
        headerBasePage.goToHigherEducation();

        Assert.assertTrue(higherEducationPage.isMainTitlePresent());
        Assert.assertTrue(higherEducationPage.isYourPartnerInEducationTitle());
        Assert.assertTrue(higherEducationPage.isBreakFreeTitle());
        Assert.assertTrue(higherEducationPage.isNewPeopleExperienceTitle());
        Assert.assertTrue(higherEducationPage.isCustomerSuccessTitle());
        Assert.assertTrue(higherEducationPage.isManchesterUniversityTitlePresent());
    }

    @Test
    public void checkAllTitlesText() {
        Assert.assertEquals(higherEducationPage.getMainTitleText(), "Higher Education");
        Assert.assertEquals(higherEducationPage.getBreakFreeTitleText(), "Break free from legacy systems");
        Assert.assertEquals(higherEducationPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
        Assert.assertEquals(higherEducationPage.getManchesterUniversityTitleText(), "Manchester Metropolitan University");
        Assert.assertEquals(higherEducationPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(higherEducationPage.getYourPartnerInEducationTitleText(), "Your Partner in Higher Education Excellence");
    }


    @Test
    public void checkPanelTitlesPresent() {
        Assert.assertTrue(higherEducationPage.isAccelerateGrowthSectionTitlePresent());
        Assert.assertTrue(higherEducationPage.isBoostStudentsSuccessSectionTitlePresent());
        Assert.assertTrue(higherEducationPage.isImproveIndustrialEffectivenessSectionTitlePresent());
    }

}
