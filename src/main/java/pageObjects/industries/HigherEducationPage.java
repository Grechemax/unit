package pageObjects.industries;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HigherEducationPage extends BasePage {
    private By mainTitle = By.xpath("//h1[contains(@class, 'section-title')]");
    private By yourPartnerInEducationTitle = By.xpath("//section[2]/div/div[1]/h2");
    private By breakFreeTitle = By.xpath("//section[3]/div/div/div[1]/h3");
    private By yourNewPeopleExperienceTitle = By.xpath("//section[4]/div/div[1]/h2");
    private By customersSuccessStoriesTitle = By.xpath("//section[5]/div/div/h1");
    private By manchesterUniversityTitle = By.xpath("//section[6]/div/div/div[2]/div[1]/h3");

    private By boostStudentsSuccessPanelItem = By.xpath("//a[@id='tab-link-3131']");
    private By accelerateGrowthPanelItem = By.xpath("//a[@id='tab-link-3256']");
    private By improveIndustrialEffectivenessPanelItem = By.xpath("//a[@id='tab-link-3281']");

    private By boostStudentsSuccessSectionTitle = By.xpath("//*[@id='tab-content-3131']/div[1]/div/h3");
    private By accelerateGrowthSectionTitle = By.xpath("//*[@id='tab-content-3256']/div[1]/div/h3");
    private By improveIndustrialEffectivenessSectionTitle = By.xpath("//*[@id='tab-content-3281']/div[1]/div/h3");
    private By manchesterUniversityReadMore = By.xpath("//section[6]//a");

    //Your New Unit4 People Experience Suite
    private By erpReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][1]//*[contains(text(), 'Read more')]");
    private By studentManagementReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][2]//*[contains(text(), 'Read more')]");
    private By financialPlanningReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][3]//*[contains(text(), 'Read more')]");
    private By humanCapitalReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][4]//*[contains(text(), 'Read more')]");

    private By seeMoreCustomersStories = By.xpath("//a[contains(text(), 'customer stories')]");

    public HigherEducationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isMainTitlePresent() {
        waitForElement(mainTitle);
        Reporter.log("Main title is present");
        return isElementPresent(mainTitle);
    }

    public boolean isYourPartnerInEducationTitle() {
        waitForElement(yourPartnerInEducationTitle);
        Reporter.log("Your Partner In Education Title is present");
        return isElementPresent(yourPartnerInEducationTitle);
    }

    public boolean isBreakFreeTitle() {
        waitForElement(breakFreeTitle);
        Reporter.log("Break Free Title is present");
        return isElementPresent(breakFreeTitle);
    }

    public boolean isNewPeopleExperienceTitle() {
        waitForElement(yourNewPeopleExperienceTitle);
        Reporter.log("Your New Unit4 People Experience Suite Title is present");
        return isElementPresent(yourNewPeopleExperienceTitle);
    }

    public boolean isCustomerSuccessTitle() {
        waitForElement(customersSuccessStoriesTitle);
        Reporter.log("'Customer Success Stories' Title is present");
        return isElementPresent(customersSuccessStoriesTitle);
    }

    public boolean isManchesterUniversityTitlePresent() {
        Reporter.log("Manchester University title is present");
        return isElementPresent(manchesterUniversityTitle);
    }

    public String getMainTitleText() {
        return getElementText(mainTitle);
    }

    public String getYourPartnerInEducationTitleText() {
        return getElementText(yourPartnerInEducationTitle);
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

    public String getManchesterUniversityTitleText() {
        return getElementText(manchesterUniversityTitle);
    }


    public boolean isBoostStudentsSuccessSectionTitlePresent() {
        clickOnElementUsingJS(boostStudentsSuccessPanelItem);
        waitForPresenceOfElement(findElement(boostStudentsSuccessSectionTitle));
        Reporter.log("Boost Student Success Header is present");
        return isElementPresent(boostStudentsSuccessSectionTitle);
    }

    public boolean isAccelerateGrowthSectionTitlePresent() {
        clickOnElementUsingJS(accelerateGrowthPanelItem);
        waitForPresenceOfElement(findElement(accelerateGrowthSectionTitle));
        Reporter.log("Accelerate Growth Header is present");
        return isElementPresent(accelerateGrowthSectionTitle);
    }


    public boolean isImproveIndustrialEffectivenessSectionTitlePresent() {
        clickOnElementUsingJS(improveIndustrialEffectivenessPanelItem);
        waitForPresenceOfElement(findElement(improveIndustrialEffectivenessSectionTitle));
        Reporter.log("improve Industrial Effectiveness Header is present");
        return isElementPresent(improveIndustrialEffectivenessSectionTitle);
    }
//Your New Unit4 People Experience Suite
    public void clickReadMoreAboutERP() {
        scrollToElement(yourNewPeopleExperienceTitle);
        clickOnElement(erpReadMore);
        Reporter.log("clicking read more in 'ERP' block");
    }

    public void clickReadMoreAboutStudentManagement() {
        Reporter.log("clicking read more about 'Students Management'");
        clickOnElement(studentManagementReadMore);
    }

    public void clickReadMoreAboutFinancialPlanning() {
        Reporter.log("clicking read more in 'Financial Capital' block");
        clickOnElement(financialPlanningReadMore);
    }

    public void clickReadMoreAboutHumanCapital() {
        Reporter.log("clicking read more in 'Human Capital' block");
        clickOnElement(humanCapitalReadMore);
    }


    public void clickReadMoreAboutManchesterUniversity() {
        Reporter.log("clicking 'Read more' in 'Customer Overview: Manchester Metropolitan University' section");
        clickOnElement(manchesterUniversityReadMore);
    }

    public void clickSeeMoreCustomersStories() {
        Reporter.log("clicking 'See more customer success stories in 'Trusted by public sector organizations worldwide' section");
        clickOnElement(seeMoreCustomersStories);
    }
}
