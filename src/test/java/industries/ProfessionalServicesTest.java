package industries;

import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
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
    private CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
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

    @Test(groups = {"Sanity"})
    public void checkAllTitlesPresent() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(professionalServicesPage.isMainTitlePresent());
        Assert.assertTrue(professionalServicesPage.isYourPartnerInDeliveringExcellenceTitlePresent());
        Assert.assertTrue(professionalServicesPage.isCrackProductivityCodeTitlePresent());
        Assert.assertTrue(professionalServicesPage.isYourNewPeopleExperienceTitlePresent());
        Assert.assertTrue(professionalServicesPage.isCustomerSuccessTitle());
        Assert.assertTrue(professionalServicesPage.isCustomersStoryTitlePresent());

    }

    @Test(groups = {"Sanity"})
    public void checkProfessionalServicesCrumb() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isProfessionalServicesCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void checkAllTitlesText() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertEquals(professionalServicesPage.getMainTitleText(), "Professional Services Organizations");
        Assert.assertEquals(professionalServicesPage.getYourPartnerInOperationalExcellenceTitleText(), "Your Partner in Delivering Excellence");
        Assert.assertEquals(professionalServicesPage.getCrackProductivityCodeTitleText(), "Crack the Productivity Code");
        Assert.assertEquals(professionalServicesPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(professionalServicesPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
    }

    @Test(groups = {"Sanity"})
    public void checkPanelTitlesPresent() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(professionalServicesPage.isDriveProjectSectionTitlePresent());
        Assert.assertTrue(professionalServicesPage.isOptimizeResourceSectionTitlePresent());
        Assert.assertTrue(professionalServicesPage.isBillWithPrecisionSectionTitlePresent());
        Assert.assertTrue(professionalServicesPage.isWinBusinessSectionTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaHeader() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }


    //Your New Unit4 People Experience Suite
    @Test(groups = {"Sanity"})
    public void checkLearnMoreBtnOpensPeopleExperienceSuitePage() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        professionalServicesPage.clickLearnMoreAboutPplExperienceSuiteBtn();
        Assert.assertTrue(peopleExperienceSuitePage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isPeopleExperienceSuiteCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensERPPage() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        professionalServicesPage.clickReadMoreAboutERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }


    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensFinancialPlanningPage() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        professionalServicesPage.clickReadMoreAboutFinancialPlanning();
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensHumanCapitalPage() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        professionalServicesPage.clickReadMoreAboutHumanCapital();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }


    // Customer Overview: War Stanley
    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensPDFPage() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        professionalServicesPage.clickReadMoreAboutCustomersStory();
        Assert.assertTrue(breadCrumbsBasePage.isStanleySecurityCrumbVisible());
        Assert.assertTrue(stanleySecurityPage.isStanleySecurityPageMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkReadOurCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        professionalServicesPage.clickReadCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void checkSeeAllNewsOpensNewsPage() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        professionalServicesPage.clickSeeAllNews();
        Assert.assertTrue(newsHomePage.isNewsHomePageMainHeaderPresent());
        Assert.assertTrue(breadCrumbsBasePage.isNewsHomePageCrumbVisible());
    }


    //The latest news
    @Test(groups = {"Sanity"})
    public void compareNewsArticleNamesWithOpenedPages() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        professionalServicesPage.compareNewsArticleNamesWithPages();
    }
}
