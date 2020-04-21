package pageObjects.industries;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NonprofitPage extends BasePage {
    private By mainTitle = By.xpath("//h1[contains(@class, 'section-title')]");
    private By learnMoreBtn = By.xpath("//section[1]//a[contains(text(), 'Learn more')]");
    private By yourPartnerInNonprofitTitle = By.xpath("//section[2]/div/div[1]/h2");
    private By breakFreeTitle = By.xpath("//section[3]/div/div/div[1]/h2");
    private By yourNewPeopleExperienceTitle = By.xpath("//section[4]/div/div[1]/h3");
    private By customersSuccessStoriesTitle = By.xpath("//section[5]/div/div/h2");
    private By warChildTitle = By.xpath("//h3[contains(text(), 'War Child')]");

    private By deliverMorePanelItem = By.xpath("//a[@id='tab-link-3551']");
    private By optimizeFundingPanelItem = By.xpath("//a[@id='tab-link-3561']");
    private By makeDecisionsPanelItem = By.xpath("//a[@id='tab-link-3571']");
    private By improveCompliancePanelItem = By.xpath("//a[@id='tab-link-3581']");

    private By deliverMoreSectionTitle = By.xpath("//*[@id='tab-content-3551']/div[1]/div/h3");
    private By optimizeFundingSectionTitle = By.xpath("//*[@id='tab-content-3561']/div[1]/div/h3");
    private By makeDecisionsSectionTitle = By.xpath("//*[@id='tab-content-3571']/div[1]/div/h3");
    private By improveComplianceSectionTitle = By.xpath("//*[@id='tab-content-3581']/div[1]/div/h3");

    private By erpReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][1]//*[contains(text(), 'Read more')]");
    private By financialPlanningReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][2]//*[contains(text(), 'Read more')]");
    private By humanCapitalReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][3]//*[contains(text(), 'Read more')]");
    private By warChildReadMore = By.xpath("//section[6]//a[contains(text(), 'Read more')]");
    private By seeMoreCustomersStories = By.xpath("//a[contains(text(), 'customer stories')]");
    private By seeAllNews = By.xpath("//a[contains(text(), 'See all news')]");
    private By learnMoreButton = By.xpath("//a[contains(text(), 'Learn more')]");


    public NonprofitPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isNonprofitMainTitlePresent() {
        waitForElement(mainTitle);
        Reporter.log("Main title is present");
        return isElementPresent(mainTitle);
    }

    public boolean isLearnMoreBtnPresent() {
        Reporter.log("'Lear more button' is present");
        return isElementPresent(learnMoreBtn);
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

    public void clickReadMoreAboutERP() {
        scrollToElement(yourNewPeopleExperienceTitle);
        Reporter.log("clicking read more in 'ERP' block");
        clickOnElement(erpReadMore);
    }

    public void clickReadMoreAboutFinancialPlanning() {
        Reporter.log("clicking read more in 'Financial Capital' block");
        clickOnElementUsingJS(financialPlanningReadMore);
    }

    public void clickReadMoreAboutHumanCapital() {
        Reporter.log("clicking read more in 'Human Capital' block");
        clickOnElementUsingJS(humanCapitalReadMore);
    }

    public void clickReadMoreAboutWarChild() {
        Reporter.log("clicking read more in 'Human Capital' block");
        clickOnElementUsingJS(warChildReadMore);
    }

    public void clickSeeMoreCustomersStories() {
        Reporter.log("clicking 'See more customer success stories in 'Trusted by public sector organizations worldwide' section");
        clickOnElement(seeMoreCustomersStories);
    }

    public void clickSeeAllNews() {
        Reporter.log("clicking 'See all news'");
        clickOnElement(seeAllNews);
    }

    public void clickLearnMore() {
        Reporter.log("clicking 'Learn More' button");
        clickOnElement(learnMoreButton);
    }
}
