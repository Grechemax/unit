package industriesTests;

import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.CityOfPortPage;
import pageObjects.industries.PublicSectorPage;
import pageObjects.news.NewsHomePage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.HumanCapitalManagementPage;

public class PublicSectorTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private NewsHomePage newsHomePage = new NewsHomePage(getDriver());
    private CityOfPortPage cityOfPortPage = new CityOfPortPage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private PublicSectorPage publicSectorPage = new PublicSectorPage(getDriver());
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        homePage.acceptCookies();
        Assert.assertTrue(publicSectorPage.isMainTitlePresent());
        Assert.assertTrue(publicSectorPage.isLearnMoreBtnPresent());
        Assert.assertTrue(publicSectorPage.isCustomerSuccessTitle());
        Assert.assertTrue(publicSectorPage.isCityOfPortTitleTitle());
        Assert.assertTrue(publicSectorPage.isBreakFreeTitlePresent());
        Assert.assertTrue(publicSectorPage.isYourNewPeopleExperienceTitlePresent());
        Assert.assertTrue(publicSectorPage.isYourPartnerInPublicServiceTitlePresent());

    }

    @Test
    public void checkPublicSectorCrumb() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isPublicSectorCrumbVisible());
    }

    @Test
    public void checkAllTitlesText() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        homePage.acceptCookies();
        Assert.assertEquals(publicSectorPage.getMainTitleText(), "Public Sector");
        Assert.assertEquals(publicSectorPage.getYourPartnerInPublicServiceTitleText(), "Your Partner in Public Service Excellence");
        Assert.assertEquals(publicSectorPage.getBreakFreeTitleText(), "Break Free from Legacy Systems");
        Assert.assertEquals(publicSectorPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(publicSectorPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
        Assert.assertEquals(publicSectorPage.getCityOfPortTitleText(), "Customer Overview: City of Port Coquitlam");
    }

    @Test
    public void checkPanelTitlesPresent() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        homePage.acceptCookies();
        Assert.assertTrue(publicSectorPage.isImproveServicesSectionTitlePresent());
        Assert.assertTrue(publicSectorPage.isAchieveEfficiencySectionTitlePresent());
        Assert.assertTrue(publicSectorPage.isEmpowerEmployeesSectionTitlePresent());
        Assert.assertTrue(publicSectorPage.isDeliverTransparencySectionTitlePresent());
    }

    @Test
    public void openRequestDemoViaHeader() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        homePage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        homePage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test
    public void checkReadMoreOpensERPPage() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        homePage.acceptCookies();
        publicSectorPage.clickReadMoreAboutERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }


    @Test
    public void checkReadMoreOpensFinancialPlanningPage() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        homePage.acceptCookies();
        publicSectorPage.clickReadMoreAboutFinancialPlanning();
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensHumanCapitalPage() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        homePage.acceptCookies();
        publicSectorPage.clickReadMoreAboutHumanCapital();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }

    // Customer Overview: City of Port
    @Test
    public void checkReadMoreOpensCityOfPortPage() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        homePage.acceptCookies();
        publicSectorPage.clickReadMoreAboutCityOfPort();
        Assert.assertTrue(cityOfPortPage.isCityOfPortMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCityOfPortCrumbVisible());
    }

    @Test
    public void checkReadOurCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        homePage.acceptCookies();
        publicSectorPage.clickSeeMoreCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    @Test
    public void checkSeeAllNewsOpensNewsPage() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        homePage.acceptCookies();
        publicSectorPage.clickSeeAllNews();
        Assert.assertTrue(newsHomePage.isNewsHomePageMainHeaderPresent());
        Assert.assertTrue(breadCrumbsBasePage.isNewsHomePageCrumbVisible());
    }
}
