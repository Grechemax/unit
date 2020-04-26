package products;

import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.WhyUnit4Page;
import pageObjects.products.PeopleExperienceSuitePage;

public class PeopleExperienceSuiteTest extends BaseTest {
    private CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    private WhyUnit4Page whyUnit4Page = new WhyUnit4Page(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());
    private PeopleExperienceSuitePage peopleExperienceSuitePage = new PeopleExperienceSuitePage(getDriver());

    @Test(groups = {"Sanity"})
    public void checkAllTitlesPresent() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(peopleExperienceSuitePage.isMainTitlePresent());
        Assert.assertTrue(peopleExperienceSuitePage.isWhyUnit4ButtonPresent());
        Assert.assertTrue(peopleExperienceSuitePage.isPeopleExperienceTitlePresent());
        Assert.assertTrue(peopleExperienceSuitePage.isBuiltOnUnit4TitleTitlePresent());
        Assert.assertTrue(peopleExperienceSuitePage.isBackedByUnit4TitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkPeopleExperienceSuitePageBreadCrumb() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isPeopleExperienceSuiteCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void erpReadMoreOpensRightPage() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        cookiesPanelPage.acceptCookies();
        peopleExperienceSuitePage.goToEnterpriseResourcePlanningPage();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void financialPlanningReadMoreOpensRightPage() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        cookiesPanelPage.acceptCookies();
        peopleExperienceSuitePage.goToFinancialPlanningPage();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialPlanningCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void humanCapitalManagementReadMoreOpensRightPage() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        cookiesPanelPage.acceptCookies();
        peopleExperienceSuitePage.goToHumanCapitalManagementPage();
        Assert.assertTrue(breadCrumbsBasePage.isHumanCapitalManagementCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void studentManagementReadMoreOpensRightPage() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        cookiesPanelPage.acceptCookies();
        peopleExperienceSuitePage.goToStudentManagementPage();
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaHeader() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        cookiesPanelPage.acceptCookies();

        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test(groups = {"Sanity"})
    public void checkWhyUnit4BtnOpensWhyUnit4Page() {
        BasePage.openURL(URLs.PRODUCTS_PEOPLE_EXPERIENCE.URL());
        cookiesPanelPage.acceptCookies();

        peopleExperienceSuitePage.clickWhyUnit4Button();
        Assert.assertTrue(whyUnit4Page.isWhyUni4MainTitlePresent());
        Assert.assertTrue(breadCrumbsBasePage.isWhyUnit4CrumbVisible());
    }
}
