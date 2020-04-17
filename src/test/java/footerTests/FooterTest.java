package footerTests;

import base.BasePage;
import base.BaseTest;
import base.FooterBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ContactUsPage;
import pageObjects.HomePage;


public class FooterTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    ContactUsPage contactUsPage = new ContactUsPage(getDriver());
    FooterBasePage footerBasePage = new FooterBasePage(getDriver());

    @Test
    public void contactSalesBtnContactUsPage() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage.acceptCookies();
        footerBasePage.clickContactSalesLink();
        Assert.assertTrue(contactUsPage.isContactUsMainTitlePresent());
    }
}
