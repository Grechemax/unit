package industriesTests;

import base.*;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.industries.NonprofitPage;
import pageObjects.industries.ProfessionalServicesPage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.HumanCapitalManagementPage;

public class ProfessionalServicesTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private ProfessionalServicesPage professionalServicesPage = new ProfessionalServicesPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        Assert.assertTrue(professionalServicesPage.isMainTitlePresent());
        Assert.assertTrue(professionalServicesPage.isYourPartnerInDeliveringExcellenceTitlePresent());
        Assert.assertTrue(professionalServicesPage.isCrackProductivityCodeTitlePresent());
        Assert.assertTrue(professionalServicesPage.isYourNewPeopleExperienceTitlePresent());
        Assert.assertTrue(professionalServicesPage.isCustomerSuccessTitle());
        Assert.assertTrue(professionalServicesPage.isStanleySecurityTitlePresent());

    }

    @Test
    public void checkProfessionalServicesCrumb() {
        Assert.assertTrue(breadCrumbsBasePage.isProfessionalServicesCrumbVisible());
    }

    @Test
    public void checkAllTitlesText() {
        Assert.assertEquals(professionalServicesPage.getMainTitleText(), "Professional Services Organizations");
        Assert.assertEquals(professionalServicesPage.getYourPartnerInOperationalExcellenceTitleText(), "Your Partner in Delivering Excellence");
        Assert.assertEquals(professionalServicesPage.getCrackProductivityCodeTitleText(), "Crack the Productivity Code");
        Assert.assertEquals(professionalServicesPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(professionalServicesPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
        Assert.assertEquals(professionalServicesPage.getStanleySecurityTitleText(), "Customer Overview: Stanley Security");
    }

    @Test
    public void checkPanelTitlesPresent() {
        Assert.assertTrue(professionalServicesPage.isDriveProjectSectionTitlePresent());
        Assert.assertTrue(professionalServicesPage.isOptimizeResourceSectionTitlePresent());
        Assert.assertTrue(professionalServicesPage.isBillWithPrecisionSectionTitlePresent());
        Assert.assertTrue(professionalServicesPage.isWinBusinessSectionTitlePresent());
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

    @Test
    public void checkReadMoreOpensERPPage() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        professionalServicesPage.clickReadMoreAboutERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }


    @Test
    public void checkReadMoreOpensFinancialPlanningPage() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        professionalServicesPage.clickReadMoreAboutFinancialPlanning();
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensHumanCapitalPage() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        professionalServicesPage.clickReadMoreAboutHumanCapital();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }
}
