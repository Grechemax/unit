package productsPageTests;

import base.*;
import data.Urls;
import net.bytebuddy.asm.Advice;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.ManchesterUniversityPage;
import pageObjects.industries.PublicSectorPage;
import pageObjects.news.NewsHomePage;
import pageObjects.products.*;

public class StudentManagementTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private ManchesterUniversityPage manchesterUniversityPage = new ManchesterUniversityPage(getDriver());
    private StudentManagementPage studentManagementPage = new StudentManagementPage(getDriver());

    private FinancialsPage financialsPage = new FinancialsPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.PRODUCTS_STUDENT_MANAGEMENT.URL());
        homePage.acceptCookies();
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
        Assert.assertTrue(studentManagementPage.isSupportGrowthTitlePresent());
        Assert.assertTrue(studentManagementPage.isStudentsManagementTitlePresent());
        Assert.assertTrue(studentManagementPage.isCreateBetterWayTitlePresent());
        Assert.assertTrue(studentManagementPage.isManchesterUniversityTitlePresent());
        Assert.assertTrue(studentManagementPage.isTrustedOrganizationsTitlePresent());
    }

    @Test
    public void checkAllTitlesText() {
        BasePage.openURL(Urls.PRODUCTS_STUDENT_MANAGEMENT.URL());
        homePage.acceptCookies();
        Assert.assertEquals(studentManagementPage.getMainTitleText(), "Unit4 Student Management");
        Assert.assertEquals(studentManagementPage.getSupportGrowthInLearningTitleText(), "Support Growth in Learning");
        Assert.assertEquals(studentManagementPage.getStudentsManagementDeliversTitleText(), "Unit4 Student Management Delivers");
        Assert.assertEquals(studentManagementPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(studentManagementPage.getManchesterUniversityTitleText(), "Customer Overview: Manchester Metropolitan University");
        Assert.assertEquals(studentManagementPage.getTrustedOrganisationsTitleText(), "Trusted worldwide by organizations that serve students");
    }

    @Test
    public void checkPanelTitlesPresent() {
        BasePage.openURL(Urls.PRODUCTS_STUDENT_MANAGEMENT.URL());
        homePage.acceptCookies();
        Assert.assertTrue(studentManagementPage.isAdmissionsSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isAcademicsSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isBillingSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isCommunicationSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isReportingSectionTitlePresent());
    }

    @Test
    public void checkStudentManagementPageBreadCrumb() {
        BasePage.openURL(Urls.PRODUCTS_STUDENT_MANAGEMENT.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
    }

    @Test()
    public void openRequestDemoViaHeader() {
        BasePage.openURL(Urls.PRODUCTS_STUDENT_MANAGEMENT.URL());
        homePage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test()
    public void openRequestDemoViaSection() {
        BasePage.openURL(Urls.PRODUCTS_STUDENT_MANAGEMENT.URL());
        homePage.acceptCookies();
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }


    @Test
    public void checkSeeMoreCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(Urls.PRODUCTS_STUDENT_MANAGEMENT.URL());
        homePage.acceptCookies();
        studentManagementPage.clickSeeMoreCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    // Customer Overview: Manchester
    @Test
    public void checkReadMoreOpensManchesterUniversityPage() {
        BasePage.openURL(Urls.PRODUCTS_STUDENT_MANAGEMENT.URL());
        homePage.acceptCookies();
        studentManagementPage.clickReadMoreAboutManchesterUniversity();
        Assert.assertTrue(breadCrumbsBasePage.isManchesterCrumbVisible());
        Assert.assertTrue(manchesterUniversityPage.isManchesterMainTitlePresent());
    }

    //Looking for one of our other Unit4 solutions?
    @Test
    public void checkLinkOpensERPPage() {
        BasePage.openURL(Urls.PRODUCTS_STUDENT_MANAGEMENT.URL());
        homePage.acceptCookies();
        studentManagementPage.clickERPLink();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
    }

    @Test
    public void checkLinkOpensFinancialPlanningPage() {
        BasePage.openURL(Urls.PRODUCTS_STUDENT_MANAGEMENT.URL());
        homePage.acceptCookies();
        studentManagementPage.clickFPALink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
    }

    @Test
    public void checkLinkOpensHumanCapitalManagementPage() {
        BasePage.openURL(Urls.PRODUCTS_STUDENT_MANAGEMENT.URL());
        homePage.acceptCookies();
        studentManagementPage.clickHCMLink();
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
    }

    @Test
    public void checkLinkOpensFinancialsPage() {
        BasePage.openURL(Urls.PRODUCTS_STUDENT_MANAGEMENT.URL());
        homePage.acceptCookies();
        studentManagementPage.clickFinancialsLink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialsCrumbVisible());
        Assert.assertTrue(financialsPage.isFinancialsPageMainTitlePresent());
    }

}

