package blog;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import base.LetsTalkSectionPage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.blog.BlogHomePage;

public class BlogHomeTest extends BaseTest {
    CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    BlogHomePage blogHomePage = new BlogHomePage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());

    @Test(groups = {"Sanity"})
    public void showMoreLoadsMoreBlogItems() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        blogHomePage.clickShowMoreToLoadMoreBlogItems();
    }

    @Test(groups = {"Sanity"})
    public void checkBlogBreadCrumb() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        breadCrumbsBasePage.isBlogHomePageCrumbVisible();
    }

    @Test(groups = {"Sanity"})
    public void readMoreOpensRightPage() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        blogHomePage.clickReadMoreButton();
        Assert.assertEquals(blogHomePage.getBlogHomePageMainTitle(), breadCrumbsBasePage.getCurrentBreadCrumb());
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoInBlogPageViaSection() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    // Authors
    @Test(groups = {"Sanity"})
    public void openMikeEttlingArticles() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        blogHomePage.checkAllBlogs();
//        blogHomePage.clickShowMoreUntilVisible();
//        blogHomePage.clickMikeEttling();
//        Assert.assertEquals(breadCrumbsBasePage.getCurrentBreadCrumb(), "Mike Ettling");
    }

//    @Test(groups = {"Sanity"}) ////div[@class='tile-group-tile-wrap']//h3//span    //div[@class='container']//h1//span
    public void openGrahamKimberleyArticles() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        blogHomePage.clickShowMoreUntilVisible();
        blogHomePage.clickGrahamKimberley();
        Assert.assertEquals(breadCrumbsBasePage.getCurrentBreadCrumb(), "Graham Kimberley");
    }

//    @Test(groups = {"Sanity"})
    public void openJeroenFigeeArticles() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        blogHomePage.clickShowMoreUntilVisible();
        blogHomePage.clickJeroenFigee();
        Assert.assertEquals(breadCrumbsBasePage.getCurrentBreadCrumb(), "Jeroen Figee");
    }

//    @Test(groups = {"Sanity"})
    public void openNickSchiaviArticles() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        blogHomePage.clickShowMoreUntilVisible();
        blogHomePage.clickNickSchiavi();
        Assert.assertEquals(breadCrumbsBasePage.getCurrentBreadCrumb(), "Nick Schiavi");
    }

//    @Test(groups = {"Sanity"})
    public void openJulieKnightArticles() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        blogHomePage.clickShowMoreUntilVisible();
        blogHomePage.clickJulieKnight();
        Assert.assertEquals(breadCrumbsBasePage.getCurrentBreadCrumb(), "Julie Knight");
    }

    //Newsletter form
    @Test(groups = {"Sanity"})
    public void checkErrorsAfterEmptyFormSubmitted() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(blogHomePage.isNewsletterTitlePresent());
        blogHomePage.clickJoinButton();
        Assert.assertTrue(blogHomePage.isEmailRequiredErrorPresent());
        Assert.assertTrue(blogHomePage.isConfirmPrivacyErrorPresent());
    }

    @Test(groups = {"Sanity"})
    public void submitFormWithWrongEmail() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(blogHomePage.isNewsletterTitlePresent());
        blogHomePage.enterEmail("wrong_shaped_email");
        blogHomePage.clickPolicyAgreement();
        blogHomePage.clickJoinButton();
        Assert.assertTrue(blogHomePage.isEmailInvalidErrorPresent(), "Error about incorrect email should be displayed");
    }

    @Test(groups = {"Sanity"})
    public void submitFormWithValidSpecialCharacters() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(blogHomePage.isNewsletterTitlePresent());
        blogHomePage.enterEmail("!#$%&'*+-/=?^_`{|}~@mail.com");
        blogHomePage.clickPolicyAgreement();
        blogHomePage.clickJoinButton();
        BasePage.goSleep(5);
//        Assert.assertTrue(blogHomePage.isSuccessfulSubscriptionMessagePresent(), "You are subscribed. message should be displayed");
    }

    @Test(groups = {"Sanity"})
    public void submitFormWithValidEmail() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(blogHomePage.isNewsletterTitlePresent());
        blogHomePage.enterEmail("test@email.com");
        blogHomePage.clickPolicyAgreement();
        blogHomePage.clickJoinButton();
        BasePage.goSleep(5);
//        Assert.assertTrue(blogHomePage.isSuccessfulSubscriptionMessagePresent(), "You are subscribed. message should be displayed");
    }

    @Test(groups = {"Sanity"})
    public void selectOnlyNonprofit() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(blogHomePage.isBlogHomeMainTitlePresent());
        blogHomePage.clickFilterDropdown();
        blogHomePage.clickNonprofitCheckbox();
        blogHomePage.clickFilterDropdown();
//        Assert.assertTrue(blogHomePage.nonprofitResultsShown(), "Only Nonprofit results are visible");
    }

    @Test(groups = {"Sanity"})
    public void selectOnlyPublicSector() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(blogHomePage.isBlogHomeMainTitlePresent());
        blogHomePage.clickFilterDropdown();
        blogHomePage.clickPublicSectorCheckbox();
        blogHomePage.clickFilterDropdown();
//        Assert.assertTrue(blogHomePage.publicSectorResultsShown(), "Only Public Sector results are visible");
    }

    @Test(groups = {"Sanity"})
    public void comparePopularPostsNamesWithPages() {
        BasePage.openURL(URLs.BLOG.URL());
        cookiesPanelPage.acceptCookies();
        blogHomePage.comparePopularPostsNamesWithPages();
    }


}
