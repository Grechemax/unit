package products;

import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.ManchesterUniversityPage;
import pageObjects.products.*;

public class StudentManagementTest extends BaseTest {
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
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

    @Test(groups = {"Sanity"})
    public void checkAllTitlesPresent() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
        Assert.assertTrue(studentManagementPage.isSupportGrowthTitlePresent());
        Assert.assertTrue(studentManagementPage.isStudentsManagementTitlePresent());
        Assert.assertTrue(studentManagementPage.isCreateBetterWayTitlePresent());
        Assert.assertTrue(studentManagementPage.isManchesterUniversityTitlePresent());
        Assert.assertTrue(studentManagementPage.isTrustedOrganizationsTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkAllTitlesText() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertEquals(studentManagementPage.getMainTitleText(), "Unit4 Student Management");
        Assert.assertEquals(studentManagementPage.getSupportGrowthInLearningTitleText(), "Support Growth in Learning");
        Assert.assertEquals(studentManagementPage.getStudentsManagementDeliversTitleText(), "Unit4 Student Management Delivers");
        Assert.assertEquals(studentManagementPage.getCreateBetterWayTitleText(), "Create a Better Way to Work");
        Assert.assertEquals(studentManagementPage.getManchesterUniversityTitleText(), "Customer Overview: Manchester Metropolitan University");
        Assert.assertEquals(studentManagementPage.getTrustedOrganisationsTitleText(), "Trusted worldwide by organizations that serve students");
    }

    @Test(groups = {"Sanity"})
    public void checkPanelTitlesPresent() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(studentManagementPage.isAdmissionsSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isAcademicsSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isBillingSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isCommunicationSectionTitlePresent());
        Assert.assertTrue(studentManagementPage.isReportingSectionTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkStudentManagementPageBreadCrumb() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaHeader() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }


    @Test(groups = {"Sanity"})
    public void checkSeeMoreCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        studentManagementPage.clickSeeMoreCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }

    // Customer Overview: Manchester
    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensManchesterUniversityPage() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        studentManagementPage.clickReadMoreAboutManchesterUniversity();
        Assert.assertTrue(breadCrumbsBasePage.isManchesterCrumbVisible());
        Assert.assertTrue(manchesterUniversityPage.isManchesterMainTitlePresent());
    }

    //Looking for one of our other Unit4 solutions?
    @Test(groups = {"Sanity"})
    public void checkLinkOpensERPPage() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        studentManagementPage.clickERPLink();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkLinkOpensFinancialPlanningPage() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        studentManagementPage.clickFPALink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkLinkOpensHumanCapitalManagementPage() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        studentManagementPage.clickHCMLink();
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkLinkOpensFinancialsPage() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        studentManagementPage.clickFinancialsLink();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialsCrumbVisible());
        Assert.assertTrue(financialsPage.isFinancialsPageMainTitlePresent());
    }


    @Test(groups = {"Sanity"})
    public void downloadPDFOpensPDF() {
        BasePage.openURL(URLs.PRODUCTS_STUDENT_MANAGEMENT.URL());
        cookiesPanelPage.acceptCookies();
        studentManagementPage.clickDownloadBrochure();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }

}

