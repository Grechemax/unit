package pageObjects.cookies;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CookiesPanelPage extends BasePage {
    private By acceptCookiesButton = By.xpath("//button[contains(text(), 'Accept Cookies')]");
    private By cookieSettingsButton = By.xpath("//button[contains(text(), 'Cookie Settings')]");
    private By saveSettingsButton = By.xpath("//button[contains(text(), 'Save Settings')]");
    private By allowAllButton = By.xpath("//button[contains(text(), 'Allow All')]");
    private By cookiePolicyLink = By.xpath("//a[contains(text(), 'Cookie policy')]");
    private By oneTrustLink = By.xpath("//div[contains(@title, 'OneTrust')]");
    private By cookieSettingsModalWindowHeader = By.xpath("//*[@id='optanon-popup-body-right']/p");

    public CookiesPanelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        if (isElementPresentWithTimer(acceptCookiesButton, 30)) {
            Reporter.log("Accepting cookies");
            clickOnElementUsingJS(acceptCookiesButton);
        }
    }

    public void clickCookieSettings() {
        waitForElementWithWaitTime(cookiePolicyLink, 60);
        Reporter.log("Clicking 'Cookie Settings'");
        clickOnElementUsingJS(cookieSettingsButton);
    }

    public void clickCookiePolicy() {
        waitForElementWithWaitTime(cookiePolicyLink, 60);
        Reporter.log("Clicking 'Cookie policy'");
        clickOnElementUsingJS(cookiePolicyLink);
    }

    public void clickSaveSettingsButton() {
        waitForElementWithWaitTime(saveSettingsButton, 60);
        Reporter.log("Clicking 'Save Settings' button");
        clickOnElementUsingJS(saveSettingsButton);
    }

    public void clickAllowAllButton() {
        waitForElementWithWaitTime(allowAllButton, 60);
        Reporter.log("Clicking 'Allow All' button");
        clickOnElementUsingJS(allowAllButton);
    }

    public void clickOneTrust() {
        waitForElementWithWaitTime(oneTrustLink, 60);
        Reporter.log("Clicking 'OneTrust' link");
        clickOnElementUsingJS(oneTrustLink);
    }

    public boolean isCookiesSettingsModalPresent() {
        waitForElementWithWaitTime(cookieSettingsModalWindowHeader, 60);
        Reporter.log("'Cookie Settings' modal window is present");
        return isElementPresent(cookieSettingsModalWindowHeader);
    }

    public boolean isModalAbsent() {
        waitUntilElementAbsent(findElement(cookieSettingsModalWindowHeader));
        Reporter.log("'Cookie Settings' modal window is closed");
        return isElementPresent(cookieSettingsModalWindowHeader);
    }
}
