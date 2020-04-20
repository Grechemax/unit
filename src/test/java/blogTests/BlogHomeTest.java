package blogTests;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import base.LetsTalkSectionPage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.blog.BlogHomePage;

public class BlogHomeTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    BlogHomePage blogHomePage = new BlogHomePage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());

    @Test
    public void showMoreLoadsMoreBlogItems() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        blogHomePage.showMoreLoadsMore();
    }

    @Test
    public void checkBlogBreadCrumb() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        breadCrumbsBasePage.isBlogHomePageCrumbVisible();
    }

    @Test
    public void readMoreOpensRightPage() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        blogHomePage.clickReadMoreButton();
        Assert.assertEquals(blogHomePage.getBlogHomePageMainTitle(), breadCrumbsBasePage.getCurrentBreadCrumb());
    }

    @Test
    public void openRequestDemoInBlogPageViaSection() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    // Authors
    @Test
    public void openMikeEttlingArticles() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        blogHomePage.clickMikeEttling();
        Assert.assertEquals(breadCrumbsBasePage.getCurrentBreadCrumb(), "Mike Ettling");
    }

    @Test
    public void openGrahamKimberleyArticles() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        blogHomePage.clickGrahamKimberley();
        Assert.assertEquals(breadCrumbsBasePage.getCurrentBreadCrumb(), "Graham Kimberley");
    }

    @Test
    public void openJeroenFigeeArticles() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        blogHomePage.clickJeroenFigee();
        Assert.assertEquals(breadCrumbsBasePage.getCurrentBreadCrumb(), "Jeroen Figee");
    }

    @Test
    public void openNickSchiaviArticles() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        blogHomePage.clickNickSchiavi();
        Assert.assertEquals(breadCrumbsBasePage.getCurrentBreadCrumb(), "Nick Schiavi");
    }

    @Test
    public void openJulieKnightArticles() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        blogHomePage.clickJulieKnight();
        Assert.assertEquals(breadCrumbsBasePage.getCurrentBreadCrumb(), "Julie Knight");
    }

    //Newsletter form
    @Test
    public void checkErrorsAfterEmptyFormSubmitted() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        Assert.assertTrue(blogHomePage.isNewsletterTitlePresent());
        blogHomePage.clickJoinButton();
        Assert.assertTrue(blogHomePage.isEmailRequiredErrorPresent());
        Assert.assertTrue(blogHomePage.isConfirmPrivacyErrorPresent());
    }

    @Test
    public void submitFormWithWrongEmail() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        Assert.assertTrue(blogHomePage.isNewsletterTitlePresent());
        blogHomePage.enterEmail("wrong_shaped@email");
        blogHomePage.clickPolicyAgreement();
        blogHomePage.clickJoinButton();
        Assert.assertTrue(blogHomePage.isEmailInvalidErrorPresent(), "Error about incorrect email should be displayed");
    }

    @Test
    public void submitFormWithValidSpecialCharacters() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        Assert.assertTrue(blogHomePage.isNewsletterTitlePresent());
        blogHomePage.enterEmail("!#$%&'*+-/=?^_`{|}~@mail.com");
        blogHomePage.clickPolicyAgreement();
        blogHomePage.clickJoinButton();
        Assert.assertTrue(blogHomePage.isSuccessfulSubscriptionMessagePresent(), "You are subscribed. message should be displayed");
    }

    @Test
    public void submitFormWithValidEmail() {
        BasePage.openURL(URLs.BLOG.URL());
        homePage.acceptCookies();
        Assert.assertTrue(blogHomePage.isNewsletterTitlePresent());
        blogHomePage.enterEmail("test@email.com");
        blogHomePage.clickPolicyAgreement();
        blogHomePage.clickJoinButton();
        Assert.assertTrue(blogHomePage.isSuccessfulSubscriptionMessagePresent(), "You are subscribed. message should be displayed");
    }
}
