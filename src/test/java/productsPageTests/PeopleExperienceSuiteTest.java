package productsPageTests;

import base.*;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.products.PeopleExperienceSuitePage;
import pageObjects.products.StudentManagementPage;

public class PeopleExperienceSuiteTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private PeopleExperienceSuitePage peopleExperienceSuitePage = new PeopleExperienceSuitePage(getDriver());

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        headerBasePage.goToThePeopleExperienceSuite();
        homePage.acceptCookies();
        Assert.assertTrue(peopleExperienceSuitePage.isMainTitlePresent());
        Assert.assertTrue(peopleExperienceSuitePage.isWhyUnit4ButtonPresent());
        Assert.assertTrue(peopleExperienceSuitePage.isPeopleExperienceTitlePresent());
        Assert.assertTrue(peopleExperienceSuitePage.isBuiltOnUnit4TitleTitlePresent());
        Assert.assertTrue(peopleExperienceSuitePage.isBackedByUnit4TitlePresent());
    }

    @Test
    public void checkPeopleExperienceSuitePageBreadCrumb() {
        Assert.assertTrue(breadCrumbsBasePage.isPeopleExperienceSuiteCrumbVisible());
    }

    @Test
    public void erpReadMoreOpensRightPage() {
        peopleExperienceSuitePage.goToEnterpriseResourcePlanningPage();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }

    @Test
    public void financialPlanningReadMoreOpensRightPage() {
        headerBasePage.goToThePeopleExperienceSuite();
        peopleExperienceSuitePage.goToFinancialPlanningPage();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test
    public void humanCapitalManagementReadMoreOpensRightPage() {
        headerBasePage.goToThePeopleExperienceSuite();
        peopleExperienceSuitePage.goToHumanCapitalManagementPage();
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }

    @Test
    public void studentManagementReadMoreOpensRightPage() {
        headerBasePage.goToThePeopleExperienceSuite();
        peopleExperienceSuitePage.goToStudentManagementPage();
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
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }
}
