package productsPageTests;

import base.*;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.products.HumanCapitalManagementPage;
import pageObjects.products.StudentManagementPage;

public class StudentManagementTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    StudentManagementPage studentManagementPage = new StudentManagementPage(getDriver());

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.goToStudentManagement();
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
        Assert.assertTrue(studentManagementPage.isSupportGrowthTitlePresent());
        Assert.assertTrue(studentManagementPage.isStudentsManagementTitlePresent());
        Assert.assertTrue(studentManagementPage.isCreateBetterWayTitlePresent());
        Assert.assertTrue(studentManagementPage.isManchesterUniversityTitlePresent());
        Assert.assertTrue(studentManagementPage.isTrustedOrganizationsTitlePresent());
    }

    @Test
    public void checkAllTitlesText() {
        Assert.assertEquals(studentManagementPage.getMainTitleText(), "Unit4 Student Management");
        Assert.assertEquals(studentManagementPage.getSupportGrowthInLearningTitleText(), "Support Growth in Learning");
        Assert.assertEquals(studentManagementPage.getStudentsManagementDeliversTitleText(), "Unit4 Student Management Delivers");
        Assert.assertEquals(studentManagementPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(studentManagementPage.getManchesterUniversityTitleText(), "Customer Overview: Manchester Metropolitan University");
        Assert.assertEquals(studentManagementPage.getTrustedOrganisationsTitleText(), "Trusted worldwide by organizations that serve students");
    }

    @Test
    public void checkPanelTitlesPresent() {
        Assert.assertTrue(studentManagementPage.isAdmissionsSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isAcademicsSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isBillingSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isCommunicationSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isReportingSectionTitlePresent());
    }

    @Test
    public void checkStudentManagementPageBreadCrumb() {
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
    }

    @Test()
    public void openRequestDemoViaHeader() {
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test()
    public void openRequestDemoViaSection() {
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

}

