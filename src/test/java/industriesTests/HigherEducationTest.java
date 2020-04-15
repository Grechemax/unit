package industriesTests;

import base.*;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.industries.HigherEducationPage;


public class HigherEducationTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private HigherEducationPage higherEducationPage = new HigherEducationPage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.INDUSTRIES_HIGH_EDUCATION.URL());
        homePage.acceptCookies();

        Assert.assertTrue(higherEducationPage.isMainTitlePresent());
        Assert.assertTrue(higherEducationPage.isYourPartnerInEducationTitle());
        Assert.assertTrue(higherEducationPage.isBreakFreeTitle());
        Assert.assertTrue(higherEducationPage.isNewPeopleExperienceTitle());
        Assert.assertTrue(higherEducationPage.isCustomerSuccessTitle());
        Assert.assertTrue(higherEducationPage.isManchesterUniversityTitlePresent());
    }

    @Test
    public void checkHigherEducationCrumb() {
        Assert.assertTrue(breadCrumbsBasePage.isHigherEducationCrumbVisible());
    }

    @Test
    public void checkAllTitlesText() {
        Assert.assertEquals(higherEducationPage.getMainTitleText(), "Higher Education");
        Assert.assertEquals(higherEducationPage.getBreakFreeTitleText(), "Break free from legacy systems");
        Assert.assertEquals(higherEducationPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
        Assert.assertEquals(higherEducationPage.getManchesterUniversityTitleText(), "Customer Overview: Manchester Metropolitan University");
        Assert.assertEquals(higherEducationPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(higherEducationPage.getYourPartnerInEducationTitleText(), "Your Partner in Higher Education Excellence");
    }


    @Test
    public void checkPanelTitlesPresent() {
        Assert.assertTrue(higherEducationPage.isAccelerateGrowthSectionTitlePresent());
        Assert.assertTrue(higherEducationPage.isBoostStudentsSuccessSectionTitlePresent());
        Assert.assertTrue(higherEducationPage.isImproveIndustrialEffectivenessSectionTitlePresent());
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
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

}
