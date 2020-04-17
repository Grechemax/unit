import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import base.FooterBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ContactUsPage;
import pageObjects.HomePage;

public class ContactUsTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    ContactUsPage contactUsPage = new ContactUsPage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    FooterBasePage footerBasePage = new FooterBasePage(getDriver());


    @Test
    public void checkContactUsPageCrumb() {
        BasePage.openURL(Urls.CONTACT_US.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isContactUsCrumbVisible());
    }

    @Test
    public void goHomeViaCrumb() {
        BasePage.openURL(Urls.CONTACT_US.URL());
        homePage.acceptCookies();
//        Assert.assertTrue(breadCrumbsBasePage.isContactUsCrumbVisible());
        breadCrumbsBasePage.goToHomePageViaBreadCrumb();
        Assert.assertTrue(homePage.isMainHeaderPresent());
    }
}
