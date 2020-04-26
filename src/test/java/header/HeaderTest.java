package header;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.External_URLs;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.HomePage;
import pageObjects.WhyUnit4Page;
import pageObjects.blog.BlogHomePage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.events.EventsHomePage;
import pageObjects.industries.*;
import pageObjects.library.LibraryHomePage;
import pageObjects.products.*;

public class HeaderTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    WhyUnit4Page whyUnit4Page = new WhyUnit4Page(getDriver());
    BlogHomePage blogHomePage = new BlogHomePage(getDriver());
    NonprofitPage nonprofitPage = new NonprofitPage(getDriver());
    EventsHomePage eventsHomePage = new EventsHomePage(getDriver());
    HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    LibraryHomePage libraryHomePage = new LibraryHomePage(getDriver());
    CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    PublicSectorPage publicSectorPage = new PublicSectorPage(getDriver());
    CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    IndustriesHomePage industriesHomePage = new IndustriesHomePage(getDriver());
    HigherEducationPage higherEducationPage = new HigherEducationPage(getDriver());
    StudentManagementPage studentManagementPage = new StudentManagementPage(getDriver());
    FinancialPlanningPage financialPlanningPage = new FinancialPlanningPage(getDriver());
    ProfessionalServicesPage professionalServicesPage = new ProfessionalServicesPage(getDriver());
    PeopleExperienceSuitePage peopleExperienceSuitePage = new PeopleExperienceSuitePage(getDriver());
    HumanCapitalManagementPage humanCapitalManagementPage = new HumanCapitalManagementPage(getDriver());
    EnterpriseResourcePlanningPage enterpriseResourcePlanningPage = new EnterpriseResourcePlanningPage(getDriver());


    //Products
    @Test(groups = {"Sanity"})
    public void erpDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToERP();
        Assert.assertTrue(enterpriseResourcePlanningPage.isERPMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void financialPlanningDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToFinancialPlanning();
        Assert.assertTrue(financialPlanningPage.isMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void humanCapitalDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToHumanCapital();
        Assert.assertTrue(humanCapitalManagementPage.isMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void studentManagementDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToStudentsManagement();
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
    }


    @Test(groups = {"Sanity"})
    public void peopleExperienceSuiteDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToPeopleExperience();
        Assert.assertTrue(peopleExperienceSuitePage.isMainTitlePresent());
    }

    //Industries
    @Test(groups = {"Sanity"})
    public void higherEducationDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToHigherEducation();
        Assert.assertTrue(higherEducationPage.isMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void nonprofitDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToNonprofit();
        Assert.assertTrue(nonprofitPage.isNonprofitMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void professionalServicesDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToProfessionalServices();
        Assert.assertTrue(professionalServicesPage.isMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void publicSectorDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToPublicSector();
        Assert.assertTrue(publicSectorPage.isMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void industriesDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToIndustriesHome();
        Assert.assertTrue(industriesHomePage.isIndustriesHomeMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void customersHeaderItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToCustomersHome();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void blogDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToBlog();
        Assert.assertTrue(blogHomePage.isBlogHomeMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void eventsDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToEvents();
        Assert.assertTrue(eventsHomePage.isEventsHomeMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void libraryDropdownItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToLibrary();
        Assert.assertTrue(libraryHomePage.isLibraryHomeMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void whyUnit4HeaderItemOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.goToWhyUnit4();
        Assert.assertTrue(whyUnit4Page.isWhyUni4MainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void isHeaderPresentAfterScroll() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        BasePage.scrollToBottom(2000);
        Assert.assertTrue(homePage.isMainLogoPresent());
    }

    @Test(groups = {"Sanity"})
    public void communityOpensCommunityPortal() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.clickCommunityHeaderItem();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(External_URLs.COMMUNITY_PORTAL_URL.URL()));
    }

}
