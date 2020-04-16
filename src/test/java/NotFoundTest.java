import base.BasePage;
import base.BaseTest;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.NotFoundPage;


public class NotFoundTest extends BaseTest {
    NotFoundPage notFoundPage = new NotFoundPage(getDriver());
    HomePage homePage = new HomePage(getDriver());


    @Test
    public void siteOpensCustom404Page() {
        BasePage.openURL(Urls.WRONG_URL.URL());
        notFoundPage.isNonFoundMainTitlePresent();
    }

    @Test
    public void siteOpensHomePage() {
        BasePage.openURL(Urls.WRONG_URL.URL());
        notFoundPage.clickTakeMeHomeBtn();
        Assert.assertTrue(homePage.isMainHeaderPresent());
    }

}
