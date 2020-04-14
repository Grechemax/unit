package industriesTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.industries.ProfessionalServicesPage;

public class ProfessionalServicesTest extends BaseTest {
    private ProfessionalServicesPage professionalServicesPage;

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
        professionalServicesPage = new ProfessionalServicesPage(getDriver());
        headerBasePage.goToProfessionalServices();

        Assert.assertTrue(professionalServicesPage.isMainTitlePresent());
        Assert.assertTrue(professionalServicesPage.isYourPartnerInDeliveringExcellenceTitlePresent());
        Assert.assertTrue(professionalServicesPage.isCrackProductivityCodeTitlePresent());
        Assert.assertTrue(professionalServicesPage.isYourNewPeopleExperienceTitlePresent());
        Assert.assertTrue(professionalServicesPage.isCustomerSuccessTitle());
        Assert.assertTrue(professionalServicesPage.isStanleySecurityTitlePresent());

    }

    @Test
    public void checkAllTitlesText() {
        Assert.assertEquals(professionalServicesPage.getMainTitleText(), "Professional Services Organizations");
        Assert.assertEquals(professionalServicesPage.getYourPartnerInOperationalExcellenceTitleText(), "Your Partner in Delivering Excellence");
        Assert.assertEquals(professionalServicesPage.getCrackProductivityCodeTitleText(), "Crack the Productivity Code");
        Assert.assertEquals(professionalServicesPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(professionalServicesPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
        Assert.assertEquals(professionalServicesPage.getStanleySecurityTitleText(), "Stanley Security");
    }

    @Test
    public void checkPanelTitlesPresent() {
        Assert.assertTrue(professionalServicesPage.isDriveProjectSectionTitlePresent());
        Assert.assertTrue(professionalServicesPage.isOptimizeResourceSectionTitlePresent());
        Assert.assertTrue(professionalServicesPage.isBillWithPrecisionSectionTitlePresent());
        Assert.assertTrue(professionalServicesPage.isWinBusinessSectionTitlePresent());
    }

}
