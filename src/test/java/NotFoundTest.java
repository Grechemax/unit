import base.BasePage;
import base.BaseTest;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.NotFoundPage;


public class NotFoundTest extends BaseTest {
    NotFoundPage notFoundPage = new NotFoundPage(getDriver());
    HomePage homePage = new HomePage(getDriver());


    @Test
    public void siteOpensCustom404Page() {
        BasePage.openURL(URLs.WRONG_URL.URL());
        notFoundPage.isNonFoundMainTitlePresent();
    }

    @Test
    public void siteOpensHomePage() {
        BasePage.openURL(URLs.WRONG_URL.URL());
        notFoundPage.clickTakeMeHomeBtn();
        Assert.assertTrue(homePage.isMainHeaderPresent());
    }

}
