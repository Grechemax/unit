package homePageTests;

import base.BasePage;
import base.BreadCrumbsBasePage;
import data.Urls;
import org.testng.Assert;
import pageObjects.HomePage;
import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.WarChildPage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.HumanCapitalManagementPage;
import pageObjects.products.StudentManagementPage;


public class HomePageTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private WarChildPage warChildPage = new WarChildPage(getDriver());
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
//        homePage.acceptCookies();
        homePage.clickReadMoreAboutERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
    }

    @Test
    public void checkReadMoreOpensFinancialPlanningPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
//        homePage.acceptCookies();
        homePage.clickReadMoreAboutFinancialPlanning();
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensHumanCapitalPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
//        homePage.acceptCookies();
        homePage.clickReadMoreAboutHumanCapital();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }


    @Test
    public void checkReadMoreOpensStudentManagementPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
//        homePage.acceptCookies();
        homePage.clickReadMoreAboutStudentManagement();
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensWarChildPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage.clickReadMoreAboutWarChild();
        Assert.assertTrue(warChildPage.isWarChildMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isWarChildCrumbVisible());
    }

    @Test
    public void checkReadOurCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
//        homePage.acceptCookies();
        homePage.clickReadCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }


}
