package industriesTests;

import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.ManchesterUniversityPage;
import pageObjects.industries.HigherEducationPage;
import pageObjects.products.EnterpriseResourcePlanningPage;
import pageObjects.products.FinancialPlanningPage;
import pageObjects.products.HumanCapitalManagementPage;
import pageObjects.products.StudentManagementPage;


public class HigherEducationTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private HigherEducationPage higherEducationPage = new HigherEducationPage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private StudentManagementPage studentManagementPage = new StudentManagementPage(getDriver());
    private FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    private ManchesterUniversityPage manchesterUniversityPage = new ManchesterUniversityPage(getDriver());
    private HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    private EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(URLs.INDUSTRIES_HIGHER_EDUCATION.URL());
        homePage.acceptCookies();
        Assert.assertTrue(higherEducationPage.isMainTitlePresent());
        Assert.assertTrue(higherEducationPage.isYourPartnerInEducationTitle());
        Assert.assertTrue(higherEducationPage.isBreakFreeTitle());
        Assert.assertTrue(higherEducationPage.isNewPeopleExperienceTitle());
        Assert.assertTrue(higherEducationPage.isCustomerSuccessTitle());
        Assert.assertTrue(higherEducationPage.isManchesterUniversityTitlePresent());
    }

    @Test
    public void checkHigherEducationCrumb() {
        BasePage.openURL(URLs.INDUSTRIES_HIGHER_EDUCATION.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isHigherEducationCrumbVisible());
    }

    @Test
    public void checkAllTitlesText() {
        BasePage.openURL(URLs.INDUSTRIES_HIGHER_EDUCATION.URL());
        homePage.acceptCookies();
        Assert.assertEquals(higherEducationPage.getMainTitleText(), "Higher Education");
        Assert.assertEquals(higherEducationPage.getBreakFreeTitleText(), "Break free from legacy systems");
        Assert.assertEquals(higherEducationPage.getCustomersSuccessStoriesTitleText(), "Customer Success Stories");
        Assert.assertEquals(higherEducationPage.getManchesterUniversityTitleText(), "Customer Overview: Manchester Metropolitan University");
        Assert.assertEquals(higherEducationPage.getYourNewPeopleExperienceTitleText(), "Your New Unit4 People Experience Suite");
        Assert.assertEquals(higherEducationPage.getYourPartnerInEducationTitleText(), "Your Partner in Higher Education Excellence");
    }


    @Test
    public void checkPanelTitlesPresent() {
        BasePage.openURL(URLs.INDUSTRIES_HIGHER_EDUCATION.URL());
        homePage.acceptCookies();
        Assert.assertTrue(higherEducationPage.isAccelerateGrowthSectionTitlePresent());
        Assert.assertTrue(higherEducationPage.isBoostStudentsSuccessSectionTitlePresent());
        Assert.assertTrue(higherEducationPage.isImproveIndustrialEffectivenessSectionTitlePresent());
    }

    @Test
    public void openRequestDemoViaHeader() {
        BasePage.openURL(URLs.INDUSTRIES_HIGHER_EDUCATION.URL());
        homePage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.INDUSTRIES_HIGHER_EDUCATION.URL());
        homePage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    //Your New Unit4 People Experience Suite
    @Test
    public void checkReadMoreOpensERPPage() {
        BasePage.openURL(URLs.INDUSTRIES_HIGHER_EDUCATION.URL());
        homePage.acceptCookies();
        higherEducationPage.clickReadMoreAboutERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensStudentManagementPage() {
        BasePage.openURL(URLs.INDUSTRIES_HIGHER_EDUCATION.URL());
        homePage.acceptCookies();
        higherEducationPage.clickReadMoreAboutStudentManagement();
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensFinancialPlanningPage() {
        BasePage.openURL(URLs.INDUSTRIES_HIGHER_EDUCATION.URL());
        homePage.acceptCookies();
        higherEducationPage.clickReadMoreAboutFinancialPlanning();
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensHumanCapitalPage() {
        BasePage.openURL(URLs.INDUSTRIES_HIGHER_EDUCATION.URL());
        homePage.acceptCookies();
        higherEducationPage.clickReadMoreAboutHumanCapital();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }

    // Customer Overview: Manchester
    @Test
    public void checkReadMoreOpensManchesterUniversityPage() {
        BasePage.openURL(URLs.INDUSTRIES_HIGHER_EDUCATION.URL());
        homePage.acceptCookies();
        higherEducationPage.clickReadMoreAboutManchesterUniversity();
        Assert.assertTrue(breadCrumbsBasePage.isManchesterCrumbVisible());
        Assert.assertTrue(manchesterUniversityPage.isManchesterMainTitlePresent());
    }

    @Test
    public void checkSeeMoreCustomersStoriesOpensCustomersPage() {
        BasePage.openURL(URLs.INDUSTRIES_HIGHER_EDUCATION.URL());
        homePage.acceptCookies();
        higherEducationPage.clickSeeMoreCustomersStories();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isCustomersCrumbVisible());
    }
}
