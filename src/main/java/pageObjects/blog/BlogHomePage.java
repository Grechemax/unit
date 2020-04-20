package pageObjects.blog;

import base.BasePage;
import base.Reporter;
import base.SearchFilterBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BlogHomePage extends SearchFilterBasePage {

    private By readMoreButton = By.xpath("//p//*[contains(text(), 'Read more')]");
    private By blogHomeMainTitle = By.xpath("//h1");

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
        waitForElement(blogHomeMainTitle);
        return isElementPresent(blogHomeMainTitle);
    }

    public void showMoreLoadsMore() {
        Reporter.log("clicking 'Show more' on Blog Page to show more blog items");
        clickShowMoreUntilVisible();
    }

    public String getBlogHomePageMainTitle() {
        Reporter.log("getting text of main title of Blog Page");
        waitForElement(blogHomeMainTitle);
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


}
