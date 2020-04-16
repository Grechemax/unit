package pageObjects;

import base.BasePage;

import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePage extends BasePage {
    private By siteLogo = By.xpath("//a[contains(@class, 'site-logo')]");
    private By whyButton = By.xpath("//p/a[contains(text(), 'Why Unit4')]");
    private By seeAllNews = By.xpath("//a[contains(text(), 'See all news')]");
    private By mainUpperHeader = By.xpath("//h1[contains(@class, 'section-title h1')]");
    private By erpReadMore = By.xpath("//section[2]//*[contains(text(), 'Read more')]");
    private By magnifierIconToSubmit = By.xpath("//*[@id='site-search-button-desktop']");
    private By leaveMessageMinimized = By.xpath("//p[contains(text(), 'Leave a message')]");
    private By readMoreWarChild = By.xpath("//section[8]//a[contains(text(), 'Read more')]");
    private By centerHeader = By.xpath("//h2[contains(@class, 'section-title text-center')]");
    private By acceptCookiesButton = By.xpath("//button[contains(text(), 'Accept Cookies')]");
    private By humanCapitalReadMore = By.xpath("//section[4]//*[contains(text(), 'Read more')]");
    private By leaveMessageFormHeader = By.xpath("//h1[contains(text(), 'Welcome to LiveChat')]");
    private By studentManagementReadMore = By.xpath("//section[5]//*[contains(text(), 'Read more')]");
    private By financialPlanningReadMore = By.xpath("//section[3]//*[contains(text(), 'Read more')]");
    private By readMoreCustomersStories = By.xpath("//a[contains(text(), 'Read our customer stories')]");

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkHomePageLinks(String page) {
        BasePage.checkLinks(page);
    }

    public void acceptCookies() {
        if (isElementPresent(acceptCookiesButton)) {
            Reporter.log("accepting cookies");
            clickOnElementUsingJS(acceptCookiesButton);
        }
    }

    public void checkLogoPresence() {
        Reporter.log("site logo is present");
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


    public void openLeaveMessageForm() {
        scrollToElement(centerHeader);
        clickOnElement(leaveMessageMinimized);
    }

    public void checkLeaveMessageFormText() {
        String displayedLeaveMessageFormHeader = getElementText(leaveMessageFormHeader);
        Assert.assertEquals(displayedLeaveMessageFormHeader, "Welcome to LiveChat");
    }

    public void clickReadMoreAboutERP() {
        Reporter.log("clicking read more about 'Enterprise Resource Planning'");
        clickOnElement(erpReadMore);
    }

    public void clickReadMoreAboutFinancialPlanning() {
        Reporter.log("clicking read more about 'Financial Planning'");
        clickOnElement(financialPlanningReadMore);
    }

    public void clickReadMoreAboutHumanCapital() {
        Reporter.log("clicking read more about 'Human Capital'");
        clickOnElement(humanCapitalReadMore);
    }

    public void clickReadMoreAboutStudentManagement() {
        Reporter.log("clicking read more about 'Students Management'");
        clickOnElement(studentManagementReadMore);
    }

    public void clickReadCustomersStories() {
        Reporter.log("clicking 'See more customer success stories in 'Trusted by public sector organizations worldwide' section");
        clickOnElement(readMoreCustomersStories);
    }

    public void clickReadMoreAboutWarChild() {
        Reporter.log("clicking read more in 'Customer Overview: War Child' block");
        clickOnElement(readMoreWarChild);
    }

    public void clickWhyButton() {
        Reporter.log("clicking read more in 'Customer Overview: War Child' block");
        clickOnElement(whyButton);
    }

    public void clickSeeAllNews() {
        Reporter.log("clicking 'See all news'");
        clickOnElement(seeAllNews);
    }
}
