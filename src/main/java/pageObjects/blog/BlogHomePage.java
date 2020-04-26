package pageObjects.blog;

import base.BreadCrumbsBasePage;
import base.Reporter;
import base.SearchFilterBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlogHomePage extends SearchFilterBasePage {
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());

    private By readMoreButton = By.xpath("//p//*[contains(text(), 'Read more')]");
    private By blogHomeMainTitle = By.xpath("//h1"); // Title can be variable

    private By authorMikeEttling = By.xpath("//a[contains(text(), 'Mike Ettling')]");
    private By authorGrahamKimberley = By.xpath("//a[contains(text(), 'Graham Kimberley')]");
    private By authorJulieKnight = By.xpath("//a[contains(text(), 'Julie Knight')]");
    private By authorNickSchiavi = By.xpath("//a[contains(text(), 'Nick Schiavi')]");
    private By authorJeroenFigee = By.xpath("//a[contains(text(), 'Jeroen Figee')]");
    private By successfulSubscriptionMessage = By.xpath("//div[@aria-label='Status message']");



    //Newsletter form
    private By joinButton = By.xpath("//input[contains(@value, 'Join')]");
    private By emailInput = By.xpath("//*[@id='edit-email']");
    private By confirmSubscriptionCheckbox = By.xpath("//*[@id='email-subscription-form']/div[2]/input");
    private By newsletterFormTitle = By.xpath("//h3[contains(text(), 'Subscribe and stay ahead of the curve')]");
    private By emailRequiredError = By.xpath("//*[@id='edit-email-error']");
    private By emailInvalidError = By.xpath("//*[@id='edit-email-error' and contains(text(), 'Enter Email does not')]");
    private By confirmPrivacyError = By.xpath("//*[@id='edit-email-error']");


    public BlogHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isBlogHomeMainTitlePresent() {
        Reporter.log("verify that 'Blog' home page main title is present");
        waitForElement(blogHomeMainTitle);
        return isElementPresent(blogHomeMainTitle);
    }

    public void clickShowMoreToLoadMoreBlogItems() {
        Reporter.log("clicking 'Show more' on Blog Page to show more blog items");
        clickShowMoreUntilVisible();
    }

    public String getBlogHomePageMainTitle() {
        Reporter.log("getting text of main title of Blog Page");
        waitForElement(blogHomeMainTitle);
        By title = By.xpath("//div[@class='container']//h1//span");
        waitForElementWithWaitTime(title, 45);
        return getElementText(blogHomeMainTitle);
    }

    public void clickReadMoreButton() {
        Reporter.log("clicking 'Read more' button");
        waitForElement(readMoreButton);
        clickOnElementUsingJS(readMoreButton);
    }

    //Authors
    public void clickMikeEttling() {
        Reporter.log("opening article written by Mike Ettling");
        waitForElement(authorMikeEttling);
        clickOnElement(authorMikeEttling);
    }

    public void clickGrahamKimberley() {
        Reporter.log("opening article written by Graham Kimberley");
        waitForElement(authorGrahamKimberley);
        clickOnElementUsingJS(authorGrahamKimberley);
    }

    public void clickJeroenFigee() {
        Reporter.log("opening article written by Jeroen Figee");
        waitForElement(authorJeroenFigee);
        clickOnElement(authorJeroenFigee);
    }

    public void clickNickSchiavi() {
        Reporter.log("opening article written by Nick Schiavi");
        waitForElement(authorNickSchiavi);
        clickOnElement(authorNickSchiavi);
    }

    public void clickJulieKnight() {
        Reporter.log("opening article written by Julie Knight");
        waitForElement(authorJulieKnight);
        clickOnElement(authorJulieKnight);
    }

    //Newsletter form
    public boolean isNewsletterTitlePresent() {
        waitForElement(newsletterFormTitle);
        Reporter.log("check if title of Newsletter is present");
        return isElementPresent(newsletterFormTitle);
    }

    public boolean isEmailRequiredErrorPresent() {
        Reporter.log("check if email 'Required' error is present");
        return isElementPresent(emailRequiredError);
    }

    public boolean isEmailInvalidErrorPresent() {
        Reporter.log("'Enter Email does not contain a valid email.' error is present");
        return isElementPresentWithTimer(emailInvalidError, 5);
    }

    public boolean isConfirmPrivacyErrorPresent() {
        Reporter.log("check if confirm privacy error is present");
        return isElementPresent(confirmPrivacyError);
    }

    public boolean isSuccessfulSubscriptionMessagePresent() {
        waitForElement(successfulSubscriptionMessage);
        Reporter.log("'You are subscribed' message is present");
        return isElementPresent(successfulSubscriptionMessage);
    }

    public void clickJoinButton() {
        Reporter.log("clicking 'Join' button");
        clickOnElement(joinButton);
    }

    public void clickPolicyAgreement() {
        Reporter.log("accepting privacy policy");
        clickOnElementUsingJS(confirmSubscriptionCheckbox);
    }

    public void enterEmail(String email) {
        Reporter.log("inputting email");
        findElement(emailInput).sendKeys(email);
    }


    public void comparePopularPostsNamesWithPages() {
        int elementQuantity = getDriver().findElements(By.xpath("//ul[@class='blogposts-list']/li")).size();
        String element = "//ul[@class='blogposts-list']/li[%s]//h3//span";

        for (int i = 1; i <= elementQuantity; i++) {
            By item = By.xpath(String.format(element, i));

            String postTitle = getElementText(item);
            Reporter.log("Comparing name of Popular Posts with name " + postTitle + " with title of opened page");
            scrollToElement(item);
            clickOnElementUsingJS(item);
            By title = By.xpath("//div[@class='container']//h1//span");
            waitForElement(title);
            String currentBreadCrumb = getElementText(title);
            Reporter.log("Verify that you are on page with title '"+postTitle+"'");
            Assert.assertEquals(postTitle, currentBreadCrumb);
            openURL("https://stg.unit4.com/blog");
            Assert.assertTrue(isBlogHomeMainTitlePresent());
        }
    }
    private By showMoreButton = By.xpath("//*[contains(text(), 'Show more')]");

    public void checkAllBlogs(){
        int j = 0;
        scrollToBottom(700);
        for (int i =1; i<7; i++){

            By blog = By.xpath("(//div[@class='tile-group-tile-wrap']//h3//span)["+i+"]");

            waitForElement(blog);
            moveToElement(blog);
            String s = getElementText(blog);
            Reporter.log("Opening blog with name '"+s+"'");
            goSleep(5);
            clickOnElementUsingJS(blog);
            By title = By.xpath("//div[@class='container']//h1//span");
            waitForElement(title);
            moveToElement(title);
            goSleep(5);
            Reporter.log("Verify that you are on page with title '"+s+"'");
            Assert.assertEquals(s,getElementText(title));

            if (i == 6){
                Reporter.log("**Navigating to the next blog page**");
                goSleep(10);
                i = 1;
                j++;
            }

            switch (j){
                case 0:
                    openURL("https://stg.unit4.com/blog");
                    break;
                case 1:

                    openURL("https://stg.unit4.com/blog?page=1");
                    break;
                case 2:
                    openURL("https://stg.unit4.com/blog?page=2");
                    break;
            }
            goSleep(5);
            if (j==3){
                return;
            }
        }

    }
}
