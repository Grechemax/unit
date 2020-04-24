package home;

import base.BasePage;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.HomePage;
import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.WhyUnit4Page;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.WarChildPage;
import pageObjects.news.NewsHomePage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.HumanCapitalManagementPage;
import pageObjects.products.StudentManagementPage;


public class HomePageTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private NewsHomePage newsHomePage = new NewsHomePage(getDriver());
    private WarChildPage warChildPage = new WarChildPage(getDriver());
    private WhyUnit4Page whyUnit4Page = new WhyUnit4Page(getDriver());
    private CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private StudentManagementPage studentManagementPage = new StudentManagementPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());


    @Test
    public void homePageTest() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(homePage.isMainLogoPresent());
        Assert.assertEquals(homePage.getMainUpperHeaderText(), "A better experience 4U");
        Assert.assertEquals(homePage.getCenterHeaderText(), "Our suite of People Experience solutions will free your people to focus on what matters: their success and yours.");
    }

    @Test
    public void checkReadMoreOpensERPPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        homePage.clickReadMoreAboutERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
    }

    @Test
    public void checkReadMoreOpensFinancialPlanningPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        homePage.clickReadMoreAboutFinancialPlanning();
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensHumanCapitalPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        homePage.clickReadMoreAboutHumanCapital();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }


    @Test
    public void checkReadMoreOpensStudentManagementPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        homePage.clickReadMoreAboutStudentManagement();
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensWarChildPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        homePage.clickReadMoreAboutWarChild();
        Assert.assertTrue(warChildPage.isWarChildMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isWarChildCrumbVisible());
    }

    @Test
    public void checkReadOurCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        homePage.clickReadCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    @Test
    public void checkWhyUnit4ButtonOpensWhyPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        homePage.clickWhyUnit4Button();
        Assert.assertTrue(whyUnit4Page.isWhyUni4MainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isWhyUnit4CrumbVisible());
    }

    //The latest news
    @Test
    public void compareNewsArticleNamesWithOpenedPages() {
        BasePage.openURL(URLs.INDUSTRIES_PROFESSIONAL_SERVICES.URL());
        cookiesPanelPage.acceptCookies();
        homePage.compareNewsArticleNamesWithPages();
    }


    @Test
    public void checkSeeAllNewsOpensNewsPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        homePage.clickSeeAllNews();
        Assert.assertTrue(newsHomePage.isNewsHomePageMainHeaderPresent());
        Assert.assertTrue(breadCrumbsBasePage.isNewsHomePageCrumbVisible());
    }

    @Test
    public void downloadReportOpensDownloadFormPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        homePage.clickDownloadReport();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains("Report"));
    }
}
