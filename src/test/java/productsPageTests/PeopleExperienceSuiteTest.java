package productsPageTests;

import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.products.PeopleExperienceSuitePage;

public class PeopleExperienceSuiteTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private PeopleExperienceSuitePage peopleExperienceSuitePage = new PeopleExperienceSuitePage(getDriver());

    @Test
    public void checkAllTitlesPresent() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        homePage.acceptCookies();
        Assert.assertTrue(peopleExperienceSuitePage.isMainTitlePresent());
        Assert.assertTrue(peopleExperienceSuitePage.isWhyUnit4ButtonPresent());
        Assert.assertTrue(peopleExperienceSuitePage.isPeopleExperienceTitlePresent());
        Assert.assertTrue(peopleExperienceSuitePage.isBuiltOnUnit4TitleTitlePresent());
        Assert.assertTrue(peopleExperienceSuitePage.isBackedByUnit4TitlePresent());
    }

    @Test
    public void checkPeopleExperienceSuitePageBreadCrumb() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isPeopleExperienceSuiteCrumbVisible());
    }

    @Test
    public void erpReadMoreOpensRightPage() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        homePage.acceptCookies();
        peopleExperienceSuitePage.goToEnterpriseResourcePlanningPage();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }

    @Test
    public void financialPlanningReadMoreOpensRightPage() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        homePage.acceptCookies();
        peopleExperienceSuitePage.goToFinancialPlanningPage();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test
    public void humanCapitalManagementReadMoreOpensRightPage() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        homePage.acceptCookies();
        peopleExperienceSuitePage.goToHumanCapitalManagementPage();
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }

    @Test
    public void studentManagementReadMoreOpensRightPage() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        homePage.acceptCookies();
        peopleExperienceSuitePage.goToStudentManagementPage();
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
    }

    @Test()
    public void openRequestDemoViaHeader() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        homePage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test()
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        homePage.acceptCookies();

        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }
}
