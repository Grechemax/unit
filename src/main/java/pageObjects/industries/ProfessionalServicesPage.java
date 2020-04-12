package pageObjects.industries;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfessionalServicesPage extends BasePage {
    private By mainTitle = By.xpath("//h1[contains(@class, 'section-title')]");
    private By yourPartnerInOperationalExcellenceTitle = By.xpath("//section[2]/div/div[1]/h2");
    private By crackingProductivityTitle = By.xpath("//section[3]/div/div/div[1]/h2");
    private By yourNewPeopleExperienceTitle = By.xpath("//*[contains(text(), 'The Unit4 People Experience Suite will humanize')]");
    private By customersSuccessStoriesTitle = By.xpath("//section[5]/div/div/h2");
    private By stanleySecurityTitle = By.xpath("//section[6]/div/div/div[2]/div[1]/h3");

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
        waitForElement(mainTitle);
        Reporter.log("Main title is present");
        return isElementPresent(mainTitle);
    }

    public boolean isYourPartnerInOperationalExcellenceTitlePresent() {
        Reporter.log("'Your Partner In Operational Excellence' is present");
        return isElementPresent(yourPartnerInOperationalExcellenceTitle);
    }

    public boolean isCrackingProductivityTitlePresent() {
        Reporter.log("'Cracking Productivity' is present");
        return isElementPresent(crackingProductivityTitle);
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
        return getElementText(mainTitle);
    }

    public String getYourPartnerInOperationalExcellenceTitleText() {
        return getElementText(yourPartnerInOperationalExcellenceTitle);
    }

    public String getCrackingProductivityTitleText() {
        return getElementText(crackingProductivityTitle);
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
