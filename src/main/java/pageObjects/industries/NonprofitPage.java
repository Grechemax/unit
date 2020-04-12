package pageObjects.industries;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NonprofitPage extends BasePage {
    private By mainTitle = By.xpath("//h1[contains(@class, 'section-title')]");
    private By downLoadPDF= By.xpath("//a[contains(text(), 'Download PDF')]");
    private By yourPartnerInNonprofitTitle = By.xpath("//section[2]/div/div[1]/h2");
    private By breakFreeTitle = By.xpath("//section[3]/div/div/div[1]/h2");
    private By yourNewPeopleExperienceTitle = By.xpath("//section[4]/div/div[1]/h3");
    private By customersSuccessStoriesTitle = By.xpath("//section[5]/div/div/h2");
    private By warChildTitle = By.xpath("//section[6]/div/div/div[2]/div[1]/h3");

    private By deliverMorePanelItem = By.xpath("//a[@id='tab-link-3551']");
    private By optimizeFundingPanelItem = By.xpath("//a[@id='tab-link-3561']");
    private By makeDecisionsPanelItem = By.xpath("//a[@id='tab-link-3571']");
    private By improveCompliancePanelItem = By.xpath("//a[@id='tab-link-3581']");

    private By deliverMoreSectionTitle = By.xpath("//*[@id='tab-content-3551']/div[1]/div/h3");
    private By optimizeFundingSectionTitle = By.xpath("//*[@id='tab-content-3561']/div[1]/div/h3");
    private By makeDecisionsSectionTitle = By.xpath("//*[@id='tab-content-3571']/div[1]/div/h3");
    private By improveComplianceSectionTitle = By.xpath("//*[@id='tab-content-3581']/div[1]/div/h3");

    public NonprofitPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isMainTitlePresent() {
        waitForElement(mainTitle);
        Reporter.log("Main title is present");
        return isElementPresent(mainTitle);
    }

    public boolean isDownLoadPDFPresent() {
        Reporter.log("'Download PDF button' is present");
        return isElementPresent(downLoadPDF);
    }

    public boolean isYourPartnerInNonprofitTitlePresent() {
        Reporter.log("'Your Partner in Nonprofit Program Excellence' title is present");
        return isElementPresent(yourPartnerInNonprofitTitle);
    }

    public boolean isBreakFreeTitlePresent() {
        Reporter.log("'Break free from legacy systems' title is present");
        return isElementPresent(breakFreeTitle);
    }

    public boolean isYourNewPeopleExperienceTitlePresent() {
        Reporter.log("'Your New Unit4 People Experience Suite' title is present");
        return isElementPresent(yourNewPeopleExperienceTitle);
    }

    public boolean isCustomerSuccessTitle() {
        Reporter.log("'Customer Success Stories' Title is present");
        return isElementPresent(customersSuccessStoriesTitle);
    }

    public boolean isWarChildPresent() {
        Reporter.log("'War Child' title is present");
        return isElementPresent(warChildTitle);
    }




    public String getMainTitleText() {
        return getElementText(mainTitle);
    }

    public String getYourPartnerInNonprofitTitleText() {
        return getElementText(yourPartnerInNonprofitTitle);
    }

    public String getBreakFreeTitleText() {
        return getElementText(breakFreeTitle);
    }

    public String getYourNewPeopleExperienceTitleText() {
        return getElementText(yourNewPeopleExperienceTitle);
    }

    public String getCustomersSuccessStoriesTitleText() {
        return getElementText(customersSuccessStoriesTitle);
    }

    public String getWarChildTitleText() {
        return getElementText(warChildTitle);
    }

    public boolean isDeliverMoreSectionTitlePresent() {
        clickOnElementUsingJS(deliverMorePanelItem);
        waitForPresenceOfElement(findElement(deliverMoreSectionTitle));
        Reporter.log("'Deliver more impact' is present");
        return isElementPresent(deliverMoreSectionTitle);
    }

    public boolean isOptimizeFundingSectionTitlePresent() {
        clickOnElementUsingJS(optimizeFundingPanelItem);
        waitForPresenceOfElement(findElement(optimizeFundingSectionTitle));
        Reporter.log("'Optimize funding allocation' is present");
        return isElementPresent(optimizeFundingSectionTitle);
    }

    public boolean isMakeDecisionsSectionTitlePresent() {
        clickOnElementUsingJS(makeDecisionsPanelItem);
        waitForPresenceOfElement(findElement(makeDecisionsSectionTitle));
        Reporter.log("'Make better decisions' is present");
        return isElementPresent(makeDecisionsSectionTitle);
    }

    public boolean isImproveComplianceSectionTitlePresent() {
        clickOnElementUsingJS(improveCompliancePanelItem);
        waitForPresenceOfElement(findElement(improveComplianceSectionTitle));
        Reporter.log("'Improve compliance & accountability' is present");
        return isElementPresent(improveComplianceSectionTitle);
    }


}
