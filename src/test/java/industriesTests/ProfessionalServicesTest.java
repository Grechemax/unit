package industriesTests;

import base.*;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.StanleySecurityPage;
import pageObjects.industries.ProfessionalServicesPage;
import pageObjects.news.NewsHomePage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.HumanCapitalManagementPage;
import pageObjects.products.PeopleExperienceSuitePage;

public class ProfessionalServicesTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private NewsHomePage newsHomePage = new NewsHomePage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private StanleySecurityPage stanleySecurityPage = new StanleySecurityPage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private ProfessionalServicesPage professionalServicesPage = new ProfessionalServicesPage(getDriver());
    private PeopleExperienceSuitePage peopleExperienceSuitePage = new PeopleExperienceSuitePage(getDriver());
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
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isProfessionalServicesCrumbVisible());
    }

    @Test
    public void checkAllTitlesText() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        Assert.assertEquals(professionalServicesPage.getMainTitleText(), "Professional Services Organizations");
        Assert.assertEquals(professionalServicesPage.getYourPartnerInOperationalExcellenceTitleText(), "Your Partner in Delivering Excellence");
        Assert.assertEquals(professionalServicesPage.getCrackProductivityCodeTitleText(), "Crack the Productivity Code");
        Assert.assertEquals(professionalServicesPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(professionalServicesPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
        Assert.assertEquals(professionalServicesPage.getStanleySecurityTitleText(), "Customer Overview: Stanley Security");
    }

    @Test
    public void checkPanelTitlesPresent() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        Assert.assertTrue(professionalServicesPage.isDriveProjectSectionTitlePresent());
        Assert.assertTrue(professionalServicesPage.isOptimizeResourceSectionTitlePresent());
        Assert.assertTrue(professionalServicesPage.isBillWithPrecisionSectionTitlePresent());
        Assert.assertTrue(professionalServicesPage.isWinBusinessSectionTitlePresent());
    }

    @Test
    public void openRequestDemoViaHeader() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test
    public void openRequestDemoViaSection() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }


    //Your New Unit4 People Experience Suite
    @Test
    public void checkLearnMoreBtnOpensPeopleExperienceSuitePage() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        professionalServicesPage.clickLearnMoreAboutPplExperienceSuiteBtn();
        Assert.assertTrue(peopleExperienceSuitePage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isPeopleExperienceSuiteCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensERPPage() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        professionalServicesPage.clickReadMoreAboutERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
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



    // Customer Overview: War Stanley
    @Test
    public void checkReadMoreOpensStanleySecurityPage() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        professionalServicesPage.clickReadMoreAboutStanleySecurity();
        Assert.assertTrue(breadCrumbsBasePage.isStanleySecurityCrumbVisible());
        Assert.assertTrue(stanleySecurityPage.isStanleySecurityPageMainTitlePresent());
    }

    @Test
    public void checkReadOurCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        homePage.clickReadCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    @Test
    public void checkSeeAllNewsOpensNewsPage() {
        BasePage.openURL(Urls.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        homePage.acceptCookies();
        professionalServicesPage.clickSeeAllNews();
        Assert.assertTrue(newsHomePage.isNewsMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isNewsHomePageCrumbVisible());
    }

}
