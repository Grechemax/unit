package homePageTests;

import base.BasePage;
import base.BreadCrumbsBasePage;
import data.External_URLs;
import data.URLs;
import org.testng.Assert;
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
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private StudentManagementPage studentManagementPage = new StudentManagementPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());


    @Test
    public void homePageTest() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        Assert.assertTrue(homePage.isMainLogoPresent());
        Assert.assertEquals(homePage.getMainUpperHeaderText(), "A better experience 4U");
        Assert.assertEquals(homePage.getCenterHeaderText(), "Our suite of People Experience solutions will free your people to focus on what matters: their success and yours.");
    }

    @Test
    public void checkReadMoreOpensERPPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickReadMoreAboutERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
    }

    @Test
    public void checkReadMoreOpensFinancialPlanningPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickReadMoreAboutFinancialPlanning();
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensHumanCapitalPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickReadMoreAboutHumanCapital();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }


    @Test
    public void checkReadMoreOpensStudentManagementPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickReadMoreAboutStudentManagement();
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensWarChildPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickReadMoreAboutWarChild();
        Assert.assertTrue(warChildPage.isWarChildMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isWarChildCrumbVisible());
    }

    @Test
    public void checkReadOurCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickReadCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    @Test
    public void checkButtonOpensWhyPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickWhyButton();
        Assert.assertTrue(whyUnit4Page.isWhyUni4MainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isWhyUnit4CrumbVisible());
    }

    //The latest news
    @Test
    public void checkFirstNewsBlockOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        String newsItemHeader = homePage.getFirstBlockNewsTitle();
        homePage.clickFirstBlockNews();
        String openedPageBredCrumb = breadCrumbsBasePage.getCurrentBreadCrumb();
        Assert.assertEquals(newsItemHeader, openedPageBredCrumb);
    }

    @Test
    public void checkSecondNewsBlockOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        String newsItemHeader = homePage.getSecondBlockNewsTitle();
        homePage.clickSecondBlockNews();
        String openedPageBredCrumb = breadCrumbsBasePage.getCurrentBreadCrumb();
        Assert.assertEquals(newsItemHeader, openedPageBredCrumb);
    }


    @Test
    public void checkThirdNewsBlockOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        String newsItemHeader = homePage.getThirdBlockNewsTitle();
        homePage.clickThirdBlockNews();
        String openedPageBredCrumb = breadCrumbsBasePage.getCurrentBreadCrumb();
        Assert.assertEquals(newsItemHeader, openedPageBredCrumb);
    }


    @Test
    public void checkSeeAllNewsOpensNewsPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickSeeAllNews();
        Assert.assertTrue(newsHomePage.isNewsHomePageMainHeaderPresent());
        Assert.assertTrue(breadCrumbsBasePage.isNewsHomePageCrumbVisible());
    }

    @Test
    public void downloadReportOpensDownloadFormPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickDownloadReport();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(External_URLs.DOWNLOAD_REPORT.URL()));
    }
}
