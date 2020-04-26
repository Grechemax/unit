package industries;

import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.CityOfPortPage;
import pageObjects.industries.PublicSectorPage;
import pageObjects.news.NewsHomePage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.HumanCapitalManagementPage;

public class PublicSectorTest extends BaseTest {
    private NewsHomePage newsHomePage = new NewsHomePage(getDriver());
    private CityOfPortPage cityOfPortPage = new CityOfPortPage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    private PublicSectorPage publicSectorPage = new PublicSectorPage(getDriver());
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());

    @Test(groups = {"Sanity"})
    public void checkAllTitlesPresent() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(publicSectorPage.isMainTitlePresent());
        Assert.assertTrue(publicSectorPage.isLearnMoreBtnPresent());
        Assert.assertTrue(publicSectorPage.isCustomerSuccessTitle());
        Assert.assertTrue(publicSectorPage.isCityOfPortTitleTitle());
        Assert.assertTrue(publicSectorPage.isBreakFreeTitlePresent());
        Assert.assertTrue(publicSectorPage.isYourNewPeopleExperienceTitlePresent());
        Assert.assertTrue(publicSectorPage.isYourPartnerInPublicServiceTitlePresent());

    }

    @Test(groups = {"Sanity"})
    public void checkPublicSectorCrumb() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isPublicSectorCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void checkAllTitlesText() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertEquals(publicSectorPage.getMainTitleText(), "Public Sector");
        Assert.assertEquals(publicSectorPage.getYourPartnerInPublicServiceTitleText(), "Your Partner in Public Service Excellence");
        Assert.assertEquals(publicSectorPage.getBreakFreeTitleText(), "Break Free from Legacy Systems");
        Assert.assertEquals(publicSectorPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(publicSectorPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
        Assert.assertEquals(publicSectorPage.getCityOfPortTitleText(), "Customer Overview: City of Port Coquitlam");
    }

    @Test(groups = {"Sanity"})
    public void checkPanelTitlesPresent() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(publicSectorPage.isImproveServicesSectionTitlePresent());
        Assert.assertTrue(publicSectorPage.isAchieveEfficiencySectionTitlePresent());
        Assert.assertTrue(publicSectorPage.isEmpowerEmployeesSectionTitlePresent());
        Assert.assertTrue(publicSectorPage.isDeliverTransparencySectionTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaHeader() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensERPPage() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        publicSectorPage.clickReadMoreAboutERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }


    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensFinancialPlanningPage() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        publicSectorPage.clickReadMoreAboutFinancialPlanning();
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensHumanCapitalPage() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        publicSectorPage.clickReadMoreAboutHumanCapital();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }

    // Customer Overview: City of Port
    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensCityOfPortPage() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        publicSectorPage.clickReadMoreAboutCityOfPort();
        Assert.assertTrue(cityOfPortPage.isCityOfPortMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCityOfPortCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void checkReadOurCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        publicSectorPage.clickSeeMoreCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void checkSeeAllNewsOpensNewsPage() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        publicSectorPage.clickSeeAllNews();
        Assert.assertTrue(newsHomePage.isNewsHomePageMainHeaderPresent());
        Assert.assertTrue(breadCrumbsBasePage.isNewsHomePageCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void learnMoreOpensPDF() {
        BasePage.openURL(URLs.INDUSTRIES_PUBLIC_SECTOR.URL());
        cookiesPanelPage.acceptCookies();
        publicSectorPage.clickLearnMore();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }
}
