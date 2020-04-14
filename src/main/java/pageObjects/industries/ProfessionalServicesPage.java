package pageObjects.industries;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfessionalServicesPage extends BasePage {
    private By professionalServiceMainTitle = By.xpath("//h1[contains(text(), 'Professional Services')]");
    private By yourPartnerInDeliveringExcellenceTitle = By.xpath("//h2[contains(text(), 'Your Partner in Delivering Excellence')]");
    private By crackProductivityCodeTitle = By.xpath("//h2[contains(text(), 'Crack the Productivity Code')]");
    private By yourNewPeopleExperienceTitle = By.xpath("//h2[contains(text(), 'Your New Unit4 People Experience Suite')]");
    private By customersSuccessStoriesTitle = By.xpath("//h2[contains(text(), 'Customer Success Stories')]");
    private By stanleySecurityTitle = By.xpath("//h3[contains(text(), 'Stanley Security')]");

    private By driveProjectPanelItem = By.xpath("//a[@id='tab-link-1966']");
    private By optimizeResourcePanelItem = By.xpath("//a[@id='tab-link-1976']");
    private By billWithPrecisionPanelItem = By.xpath("//a[@id='tab-link-1986']");
    private By winBusinessPanelItem = By.xpath("//a[@id='tab-link-1996']");

    private By driveProjectSectionTitle = By.xpath("//*[@id='tab-content-1966']/div[1]/div/h3");
    private By optimizeResourceSectionTitle = By.xpath("//*[@id='tab-content-1976']/div[1]/div/h3");
    private By billWithPrecisionSectionTitle = By.xpath("//*[@id='tab-content-1986']/div[1]/div/h3");
    private By winBusinessSectionTitle = By.xpath("//*[@id='tab-content-1996']/div[1]/div/h3");

    public ProfessionalServicesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isMainTitlePresent() {
        waitForElement(professionalServiceMainTitle);
        Reporter.log("Main title is present");
        return isElementPresent(professionalServiceMainTitle);
    }

    public boolean isYourPartnerInDeliveringExcellenceTitlePresent() {
        Reporter.log("'Your Partner In Delivering Excellence' is present");
        return isElementPresent(yourPartnerInDeliveringExcellenceTitle);
    }

    public boolean isCrackProductivityCodeTitlePresent() {
        Reporter.log("'Crack The Productivity Code' Title is present");
        return isElementPresent(crackProductivityCodeTitle);
    }

    public boolean isYourNewPeopleExperienceTitlePresent() {
        Reporter.log("'yourNewPeopleExperienceTitle' is present");
        return isElementPresent(yourNewPeopleExperienceTitle);
    }

    public boolean isCustomerSuccessTitle() {
        Reporter.log("'Customer Success Stories' Title is present");
        return isElementPresent(customersSuccessStoriesTitle);
    }

    public boolean isStanleySecurityTitlePresent() {
        Reporter.log("'Stanley Security' Title is present");
        return isElementPresent(stanleySecurityTitle);
    }

    public String getMainTitleText() {
        waitForElement(professionalServiceMainTitle);
        return getElementText(professionalServiceMainTitle);
    }

    public String getYourPartnerInOperationalExcellenceTitleText() {
        return getElementText(yourPartnerInDeliveringExcellenceTitle);
    }

    public String getCrackProductivityCodeTitleText() {
        return getElementText(crackProductivityCodeTitle);
    }

    public String getYourNewPeopleExperienceTitleText() {
        return getElementText(yourNewPeopleExperienceTitle);
    }

    public String getCustomersSuccessStoriesTitleText() {
        return getElementText(customersSuccessStoriesTitle);
    }

    public String getStanleySecurityTitleText() {
        return getElementText(stanleySecurityTitle);
    }


    public boolean isDriveProjectSectionTitlePresent() {
        clickOnElementUsingJS(driveProjectPanelItem);
        waitForPresenceOfElement(findElement(driveProjectSectionTitle));
        Reporter.log("'Drive Project Profitability' is present");
        return isElementPresent(driveProjectSectionTitle);
    }


    public boolean isOptimizeResourceSectionTitlePresent() {
        clickOnElementUsingJS(optimizeResourcePanelItem);
        waitForPresenceOfElement(findElement(optimizeResourceSectionTitle));
        Reporter.log("' Optimize Resource Management' is present");
        return isElementPresent(optimizeResourceSectionTitle);
    }


    public boolean isBillWithPrecisionSectionTitlePresent() {
        clickOnElementUsingJS(billWithPrecisionPanelItem);
        waitForPresenceOfElement(findElement(billWithPrecisionSectionTitle));
        Reporter.log("'Bill with Precision' is present");
        return isElementPresent(billWithPrecisionSectionTitle);
    }


    public boolean isWinBusinessSectionTitlePresent() {
        clickOnElementUsingJS(winBusinessPanelItem);
        waitForPresenceOfElement(findElement(winBusinessSectionTitle));
        Reporter.log("'Win the Right Business' is present");
        return isElementPresent(winBusinessSectionTitle);
    }
}
