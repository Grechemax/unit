import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.Urls;
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
    public void siteOpensCustom404Page() {
        BasePage.openURL(Urls.WHY_UNIT4.URL());
        whyUnit4Page.isWhyUni4MainTitlePresent();
    }

    @Test
    public void checkWhyUnit4BreadCrumb() {
        BasePage.openURL(Urls.WHY_UNIT4.URL());
        Assert.assertTrue(breadCrumbsBasePage.isWhyUnit4CrumbVisible());
    }

    @Test
    public void readMoreWhatSoftwareOpensPeopleExperienceSuitePage() {
        BasePage.openURL(Urls.WHY_UNIT4.URL());
        whyUnit4Page.clickReadMoreWhatSoftware();
        Assert.assertTrue(breadCrumbsBasePage.isPeopleExperienceSuiteCrumbVisible());
        Assert.assertTrue(peopleExperienceSuitePage.isMainTitlePresent());
    }

    @Test
    public void readSeeHowWeServeOpensIndustriesPage() {
        BasePage.openURL(Urls.WHY_UNIT4.URL());
        whyUnit4Page.clickReadSeeHowWeServe();
        Assert.assertTrue(breadCrumbsBasePage.isIndustriesHomeCrumbVisible());
        Assert.assertTrue(industriesHomePage.isIndustriesHomeMainTitlePresent());
    }
}
