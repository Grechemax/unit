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
}
