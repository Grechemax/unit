package homePageTests;

import base.BasePage;
import base.BreadCrumbsBasePage;
import data.Urls;
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

import javax.enterprise.inject.New;


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
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.checkLogoPresence();
        homePage.checkMainUpperHeader();
        homePage.checkCenterHeader();
    }

    @Test
    public void checkReadMoreOpensERPPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickReadMoreAboutERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
    }

    @Test
    public void checkReadMoreOpensFinancialPlanningPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickReadMoreAboutFinancialPlanning();
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensHumanCapitalPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickReadMoreAboutHumanCapital();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }


    @Test
    public void checkReadMoreOpensStudentManagementPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickReadMoreAboutStudentManagement();
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensWarChildPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickReadMoreAboutWarChild();
        Assert.assertTrue(warChildPage.isWarChildMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isWarChildCrumbVisible());
    }

    @Test
    public void checkReadOurCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickReadCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    @Test
    public void checkButtonOpensWhyPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickWhyButton();
        Assert.assertTrue(whyUnit4Page.isWhyUni4MainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isWhyUnit4CrumbVisible());
    }

    @Test
    public void checkSeeAllNewsOpensNewsPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage.acceptCookies();
        homePage.clickSeeAllNews();
        Assert.assertTrue(newsHomePage.isNewsMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isNewsHomePageCrumbVisible());
    }
}
