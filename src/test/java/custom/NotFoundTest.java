package custom;

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


    @Test(groups = {"Sanity"})
    public void checkPageTitle() {
        BasePage.openURL(URLs.WRONG_URL.URL());
        notFoundPage.isNonFoundMainTitlePresent();
    }

    @Test(groups = {"Sanity"})
    public void takeMeHomeBtnOpensHomePage() {
        BasePage.openURL(URLs.WRONG_URL.URL());
        notFoundPage.clickTakeMeHomeBtn();
        Assert.assertTrue(homePage.isMainHeaderPresent());
    }

}
