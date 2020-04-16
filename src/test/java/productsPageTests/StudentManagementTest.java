package productsPageTests;

import base.*;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.news.NewsHomePage;
import pageObjects.products.HumanCapitalManagementPage;
import pageObjects.products.StudentManagementPage;

public class StudentManagementTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private NewsHomePage newsHomePage = new NewsHomePage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private StudentManagementPage studentManagementPage = new StudentManagementPage(getDriver());

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



}

