package footer;

import base.BasePage;
import base.BaseTest;
import data.External_URLs;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.footer.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.footer.aboutUs.AboutUsHomePage;
import pageObjects.footer.aboutUs.LeadershipTeamPage;
import pageObjects.footer.aboutUs.ServicesPage;
import pageObjects.footer.aboutUs.SupportPage;
import pageObjects.locations.LocationsHomePage;
import pageObjects.news.NewsHomePage;


public class FooterGeneralTest extends BaseTest {
    SupportPage supportPage = new SupportPage(getDriver());
    PartnersPage partnersPage = new PartnersPage(getDriver());
    ServicesPage servicesPage = new ServicesPage(getDriver());
    NewsHomePage newsHomePage = new NewsHomePage(getDriver());
    ContactUsPage contactUsPage = new ContactUsPage(getDriver());
    AboutUsHomePage aboutUsHomePage = new AboutUsHomePage(getDriver());
    CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    LocationsHomePage locationsHomePage = new LocationsHomePage(getDriver());
    FooterGeneralPage footerGeneralPage = new FooterGeneralPage(getDriver());
    LeadershipTeamPage leadershipTeamPage = new LeadershipTeamPage(getDriver());

    //Contact us section
    @Test
    public void contactSalesLinkOpensContactUsPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickContactSalesLink();
        Assert.assertTrue(contactUsPage.isContactUsMainTitlePresent());
    }

    @Test
    public void communityPortalLinkOpensCommunityPortalPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickCommunityPortalLink();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(External_URLs.COMMUNITY_PORTAL_URL.URL()));
    }

    @Test
    public void locationsLinkOpensLocationPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickLocationsLink();
        Assert.assertTrue(locationsHomePage.isLocationsMainHeaderPresent());
    }

    //About Unit4
    @Test
    public void theCompanyLinkOpensAboutUsPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickCompanyLink();
        Assert.assertTrue(aboutUsHomePage.isAboutUsPageMainHeaderPresent());
    }

    @Test
    public void leadershipLinkLeadershipTeamPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickLeadershipLink();
        Assert.assertTrue(leadershipTeamPage.isLeadershipTeamMainHeaderPresent());
    }

    @Test
    public void partnersLinkOpensLocationPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickPartnersLink();
        Assert.assertTrue(partnersPage.isPartnersPageMainHeaderPresent());
    }

    @Test
    public void newsLinkOpensNewsHomePage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickNewsLink();
        Assert.assertTrue(newsHomePage.isNewsHomePageMainHeaderPresent());
    }

    @Test
    public void careersLinkOpens_Page() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickCareersLink();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(External_URLs.CAREERS_URL.URL()));
    }

    @Test
    public void servicesLinkOpensServicesPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickServicesLink();
        Assert.assertTrue(servicesPage.isServicesPageMainHeaderPresent());
    }

    @Test
    public void supportLinkOpensSupportPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickSupportLink();
        Assert.assertTrue(supportPage.isSupportPageMainHeaderPresent());
    }

    @Test
    public void privacyAndTrustLinkOpensExtPrivacyPolicyPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickPrivacyLink();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(External_URLs.PRIVACY_AND_TRUST_URL.URL()));
    }

    //very bottom links
    @Test
    public void termsAndConditionsOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickTermsAndConditions();
        BasePage.goSleep(2);
        Assert.assertTrue(BasePage.isCurrentUrlContains(URLs.PRIVACY_POLICY.STAGE()));
    }

    @Test
    public void disclaimerOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickDisclaimer();
        BasePage.goSleep(2);
        Assert.assertTrue(BasePage.isCurrentUrlContains(URLs.DISCLAIMER.STAGE()));
    }

    @Test
    public void cookiesOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickCookies();
        BasePage.goSleep(2);
        Assert.assertTrue(BasePage.isCurrentUrlContains(URLs.COOKIES.STAGE()));
    }

    @Test
    public void modernSlaveryOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickModernSlavery();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains("Modern-Slavery"));
    }

    @Test
    public void trademarksOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickTrademarks();
        BasePage.goSleep(2);
        Assert.assertTrue(BasePage.isCurrentUrlContains(URLs.TRADEMARKS.STAGE()));
    }

    @Test
    public void sitemapOpensRightPage() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickSitemap();
        BasePage.goSleep(2);
        Assert.assertTrue(BasePage.isCurrentUrlContains(URLs.SITEMAP.STAGE()));
    }

    //Social media
    @Test
    public void linkOpensFacebook() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickFacebookIcon();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(External_URLs.FACEBOOK.URL()));
    }

    @Test
    public void linkOpensLinkedIn() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickLinkedInIcon();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(External_URLs.LINKEDIN.URL()));
    }

    @Test
    public void linkOpensTwitter() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickTwitterIcon();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(External_URLs.TWITTER.URL()));
    }

    @Test
    public void linkOpensInstagram() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        cookiesPanelPage.acceptCookies();
        footerGeneralPage.clickInstagramIcon();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(External_URLs.INSTAGRAM.URL()));
    }

}
