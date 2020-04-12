package pageObjects;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePage extends BasePage {
    private By acceptCookiesButton = By.xpath("//button[contains(text(), 'Accept Cookies')]");
    private By mainUpperHeader = By.xpath("//h1[contains(@class, 'section-title h1')]");
    private By centerHeader = By.xpath("//h2[contains(@class, 'section-title text-center')]");
    private By siteLogo = By.xpath("//a[contains(@class, 'site-logo')]");
    private By magnifierIconToOpenSearch = By.xpath("//button[contains(@class, 'search-button-open')]");
    private By searchInput = By.xpath("//input[contains(@placeholder, 'Enter search')]");
    private By leaveMessageMinimized = By.xpath("//p[contains(text(), 'Leave a message')]");
    private By leaveMessageFormHeader = By.xpath("//h1[contains(text(), 'Welcome to LiveChat')]");
    private By magnifierIconToSubmit = By.xpath("//*[@id='site-search-button-desktop']");


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkHomePageLinks(String page) {
        BasePage.checkLinks(page);
    }

    public void acceptCookies() {
        waitForElementClickable(acceptCookiesButton);
        clickOnElementUsingJS(acceptCookiesButton);
    }

    public void checkLogoPresence() {
        isElementPresent(siteLogo);
    }

    public void checkMainUpperHeader() {
        String displayedMainUpperHeader = getElementText(mainUpperHeader);
        Assert.assertEquals(displayedMainUpperHeader, "A better experience 4U");
    }

    public void checkCenterHeader() {
        String displayedCenterHeader = getElementText(centerHeader);
        Assert.assertEquals(displayedCenterHeader, "Our suite of People Experience solutions will free your people to focus on what matters: their success and yours.");
    }


    public void doSearch(String query) {
        clickOnElement(magnifierIconToOpenSearch);
        getDriver().findElement(searchInput).sendKeys(query);
        getDriver().findElement(searchInput).sendKeys(Keys.RETURN);
    }

    public void openLeaveMessageForm() {
        scrollToElement(centerHeader);
        clickOnElement(leaveMessageMinimized);
    }

    public void checkLeaveMessageFormText() {
        String displayedLeaveMessageFormHeader = getElementText(leaveMessageFormHeader);
        Assert.assertEquals(displayedLeaveMessageFormHeader, "Welcome to LiveChat");
    }


}
