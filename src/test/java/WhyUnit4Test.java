import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import pageObjects.industries.IndustriesHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.WhyUnit4Page;
import pageObjects.products.PeopleExperienceSuitePage;

public class WhyUnit4Test extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    WhyUnit4Page whyUnit4Page = new WhyUnit4Page(getDriver());
    IndustriesHomePage industriesHomePage = new IndustriesHomePage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    PeopleExperienceSuitePage peopleExperienceSuitePage = new PeopleExperienceSuitePage(getDriver());


    @Test
    public void checkPageTitle() {
        BasePage.openURL(URLs.WHY_UNIT4.URL());
        whyUnit4Page.isWhyUni4MainTitlePresent();
    }

    @Test
    public void checkWhyUnit4BreadCrumb() {
        BasePage.openURL(URLs.WHY_UNIT4.URL());
        Assert.assertTrue(breadCrumbsBasePage.isWhyUnit4CrumbVisible());
    }

    @Test
    public void readMoreWhatSoftwareOpensPeopleExperienceSuitePage() {
        BasePage.openURL(URLs.WHY_UNIT4.URL());
        whyUnit4Page.clickReadMoreWhatSoftware();
        Assert.assertTrue(breadCrumbsBasePage.isPeopleExperienceSuiteCrumbVisible());
        Assert.assertTrue(peopleExperienceSuitePage.isMainTitlePresent());
    }

    @Test
    public void readSeeHowWeServeOpensIndustriesPage() {
        BasePage.openURL(URLs.WHY_UNIT4.URL());
        whyUnit4Page.clickReadSeeHowWeServe();
        Assert.assertTrue(breadCrumbsBasePage.isIndustriesHomeCrumbVisible());
        Assert.assertTrue(industriesHomePage.isIndustriesHomeMainTitlePresent());
    }

    @Test
    public void downloadReportOpensDownloadFormPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        whyUnit4Page.clickDownloadReport();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains("Report"));
    }

    @Test
    public void downloadPDF1OpensCorrectPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        whyUnit4Page.clickDownloadPDF1();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }

    @Test
    public void downloadPDF2OpensCorrectPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        whyUnit4Page.clickDownloadPDF2();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains("Next-Level-ERP"));
    }

    @Test
    public void downloadPDF3OpensCorrectPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        whyUnit4Page.clickDownloadPDF3();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains("Hot-Companies"));
    }
}
