package industriesTests;

import base.BasePage;
import base.BaseTest;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.industries.ProfessionalServicesPage;
import pageObjects.industries.PublicSectorPage;

public class PublicSectorTest extends BaseTest {
    private PublicSectorPage publicSectorPage;

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        HomePage homePage = new HomePage(getDriver());
        publicSectorPage = new PublicSectorPage(getDriver());
        homePage.goToPublicSector();

        Assert.assertTrue(publicSectorPage.isMainTitlePresent());
        Assert.assertTrue(publicSectorPage.isDownLoadPDFPresent());
        Assert.assertTrue(publicSectorPage.isCustomerSuccessTitle());
        Assert.assertTrue(publicSectorPage.isCityOfPortTitleTitle());
        Assert.assertTrue(publicSectorPage.isBreakFreeTitlePresent());
        Assert.assertTrue(publicSectorPage.isYourNewPeopleExperienceTitlePresent());
        Assert.assertTrue(publicSectorPage.isYourPartnerInPublicServiceTitlePresent());

    }

    @Test
    public void checkAllTitlesText() {
        Assert.assertEquals(publicSectorPage.getMainTitleText(), "Public Sector");
        Assert.assertEquals(publicSectorPage.getYourPartnerInPublicServiceTitleText(), "Your Partner in Public Service Excellence");
        Assert.assertEquals(publicSectorPage.getBreakFreeTitleText(), "Break Free from Legacy Systems");
        Assert.assertEquals(publicSectorPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(publicSectorPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
        Assert.assertEquals(publicSectorPage.getCityOfPortTitleText(), "City of Port Coquitlam");
    }

    @Test
    public void checkPanelTitlesPresent() {
        Assert.assertTrue(publicSectorPage.isImproveServicesSectionTitlePresent());
        Assert.assertTrue(publicSectorPage.isAchieveEfficiencySectionTitlePresent());
        Assert.assertTrue(publicSectorPage.isEmpowerEmployeesSectionTitlePresent());
        Assert.assertTrue(publicSectorPage.isDeliverTransparencySectionTitlePresent());
    }

}
