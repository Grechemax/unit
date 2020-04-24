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
            Reporter.log("accepting cookies");
            clickOnElementUsingJS(acceptCookiesButton);
        }
    }

    public void clickCookieSettings() {
        waitForElement(cookiePolicyLink);
        Reporter.log("clicking 'Cookie Settings'");
        clickOnElementUsingJS(cookieSettingsButton);
    }

    public void clickCookiePolicy() {
        waitForElement(cookiePolicyLink);
        Reporter.log("clicking 'Cookie policy'");
        clickOnElementUsingJS(cookiePolicyLink);
    }

    public void clickSaveSettingsButton() {
        waitForElement(saveSettingsButton);
        Reporter.log("clicking 'Save Settings' button");
        clickOnElementUsingJS(saveSettingsButton);
    }

    public void clickAllowAllButton() {
        waitForElement(allowAllButton);
        Reporter.log("clicking 'Allow All' button");
        clickOnElementUsingJS(allowAllButton);
    }

    public void clickOneTrust() {
        waitForElement(oneTrustLink);
        Reporter.log("clicking 'OneTrust' link");
        clickOnElementUsingJS(oneTrustLink);
    }

    public boolean isCookiesSettingsModalPresent() {
        waitForElement(cookieSettingsModalWindowHeader);
        Reporter.log("'Cookie Settings' modal window is present");
        return isElementPresent(cookieSettingsModalWindowHeader);
    }

    public boolean isModalAbsent() {
        waitUntilElementAbsent(findElement(cookieSettingsModalWindowHeader));
        Reporter.log("'Cookie Settings' modal window is closed");
        return isElementPresent(cookieSettingsModalWindowHeader);
    }
}
