import base.BasePage;
import base.BaseTest;
import data.External_URLs;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesHomePage;
import pageObjects.cookies.CookiesPanelPage;

public class CookiesPanelTest extends BaseTest {
    CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    CookiesHomePage cookiesHomePage = new CookiesHomePage(getDriver());

    @Test
    public void cookiesPolicyOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.clickCookiePolicy();
        Assert.assertTrue(cookiesHomePage.isCookiesHomePageMainHeaderPresent());
    }

    @Test
    public void clickingCookiesSettingsOpensModalWindow() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.clickCookieSettings();
        Assert.assertTrue(cookiesPanelPage.isCookiesSettingsModalPresent());
    }

    @Test
    public void clickingSaveSettingsClosesModalWindow() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.clickCookieSettings();
        cookiesPanelPage.clickSaveSettingsButton();
        Assert.assertTrue(cookiesPanelPage.isModalAbsent());
    }

    @Test
    public void clickingAllowAllClosesModalWindow() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.clickCookieSettings();
        cookiesPanelPage.clickAllowAllButton();
        Assert.assertTrue(cookiesPanelPage.isModalAbsent());
    }

    @Test
    public void oneTrustLinkOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.clickCookieSettings();
        cookiesPanelPage.clickOneTrust();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(External_URLs.ONE_TRUST.URL()));
    }
}
