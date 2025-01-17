package pageObjects.industries;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PublicSectorPage extends BasePage {
    private By mainTitle = By.xpath("//h1[contains(text(), 'Public Sector')]");
    private By learnMoreButton = By.xpath("//section[1]//a[contains(text(), 'Learn more')]");
    private By yourPartnerInPublicServiceTitle = By.xpath("//section[2]/div/div[1]/h2");
    private By breakFreeTitle = By.xpath("//section[3]/div/div/div[1]/h3");
    private By yourNewPeopleExperienceTitle = By.xpath("//section[4]/div/div[1]/h2");
    private By customersSuccessStoriesTitle = By.xpath("//section[5]/div/div/h2");
    private By cityOfPortTitle = By.xpath("//h3[contains(text(), 'City of Port Coquitlam')]");

    private By achieveEfficiencyPanelItem = By.xpath("//a[@id='tab-link-4676']");
    private By deliverTransparencyPanelItem = By.xpath("//a[@id='tab-link-4691']");
    private By empowerEmployeesPanelItem = By.xpath("//a[@id='tab-link-4701']");
    private By improveServicesPanelItem = By.xpath("//a[@id='tab-link-4711']");


    private By achieveEfficiencySectionTitle = By.xpath("//*[@id='tab-content-4676']/div[1]/div/h3");
    private By deliverTransparencySectionTitle = By.xpath("//*[@id='tab-content-4691']/div[1]/div/h3");
    private By empowerEmployeesSectionTitle = By.xpath("//*[@id='tab-content-4701']/div[1]/div/h3");
    private By improveServicesSectionTitle = By.xpath("//*[@id='tab-content-4711']/div[1]/div/h3");

    private By readMoreCustomersStories = By.xpath("//a[contains(text(), 'See more customer stories')]");

    private By erpReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][1]//*[contains(text(), 'Read more')]");
    private By financialPlanningReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][2]//*[contains(text(), 'Read more')]");
    private By humanCapitalReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][3]//*[contains(text(), 'Read more')]");
    private By cityOfPortReadMore = By.xpath("//section[6]//a[contains(text(), 'Read more')]");
    private By seeAllNews = By.xpath("//a[contains(text(), 'See all news')]");


    public PublicSectorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isMainTitlePresent() {
        waitForElement(mainTitle);
        Reporter.log("Main title is present");
        return isElementPresent(mainTitle);
    }

    public boolean isLearnMoreBtnPresent() {
        Reporter.log("'Learn more' button is present");
        return isElementPresent(learnMoreButton);
    }

    public boolean isYourPartnerInPublicServiceTitlePresent() {
        Reporter.log("'Your Partner in Public Service Excellence' is present");
        return isElementPresent(yourPartnerInPublicServiceTitle);
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

    public boolean isCityOfPortTitleTitle() {
        Reporter.log("'City of Port Coquitlam' Title is present");
        return isElementPresent(cityOfPortTitle);
    }

    public String getMainTitleText() {
        return getElementText(mainTitle);
    }

    public String getYourPartnerInPublicServiceTitleText() {
        return getElementText(yourPartnerInPublicServiceTitle);
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

    public String getCityOfPortTitleText() {
        return getElementText(cityOfPortTitle);
    }


    public boolean isAchieveEfficiencySectionTitlePresent() {
        clickOnElementUsingJS(achieveEfficiencyPanelItem);
        waitForPresenceOfElement(findElement(achieveEfficiencySectionTitle));
        Reporter.log("'Achieve Operational Efficiency' is present");
        return isElementPresent(achieveEfficiencySectionTitle);
    }

    public boolean isDeliverTransparencySectionTitlePresent() {
        clickOnElementUsingJS(deliverTransparencyPanelItem);
        waitForPresenceOfElement(findElement(deliverTransparencySectionTitle));
        Reporter.log("'Deliver Transparency' is present");
        return isElementPresent(deliverTransparencySectionTitle);
    }

    public boolean isEmpowerEmployeesSectionTitlePresent() {
        clickOnElementUsingJS(empowerEmployeesPanelItem);
        waitForPresenceOfElement(findElement(empowerEmployeesSectionTitle));
        Reporter.log("'Empower Employees' is present");
        return isElementPresent(empowerEmployeesSectionTitle);
    }

    public boolean isImproveServicesSectionTitlePresent() {
        clickOnElementUsingJS(improveServicesPanelItem);
        waitForPresenceOfElement(findElement(improveServicesSectionTitle));
        Reporter.log("'Improve Citizen Services' is present");
        return isElementPresent(improveServicesSectionTitle);
    }

    public void clickReadMoreAboutERP() {
        scrollToElement(yourNewPeopleExperienceTitle);
        Reporter.log("clicking 'Read more' in 'ERP' block");
        clickOnElement(erpReadMore);
    }

    public void clickReadMoreAboutFinancialPlanning() {
        Reporter.log("clicking 'Read more' in 'Financial Capital' block");
        clickOnElement(financialPlanningReadMore);
    }

    public void clickReadMoreAboutHumanCapital() {
        Reporter.log("clicking 'Read more' in 'Human Capital' block");
        clickOnElement(humanCapitalReadMore);
    }

    public void clickReadMoreAboutCityOfPort() {
        Reporter.log("clicking 'Read more' in Customer Success Stories 'City of Port' block");
        clickOnElement(cityOfPortReadMore);
    }

    public void clickSeeMoreCustomersStories() {
        Reporter.log("clicking 'See more customer success stories' in 'Trusted by public sector organizations worldwide' section");
        clickOnElement(readMoreCustomersStories);
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
