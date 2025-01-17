package pageObjects.industries;

import base.BasePage;
import base.BreadCrumbsBasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProfessionalServicesPage extends BasePage {
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private By professionalServiceMainTitle = By.xpath("//h1[contains(text(), 'Professional Services')]");
    private By yourPartnerInDeliveringExcellenceTitle = By.xpath("//h2[contains(text(), 'Your Partner in Delivering Excellence')]");
    private By crackProductivityCodeTitle = By.xpath("//h2[contains(text(), 'Crack the Productivity Code')]");
    private By yourNewPeopleExperienceTitle = By.xpath("//h2[contains(text(), 'Your New Unit4 People Experience Suite')]");
    private By customersSuccessStoriesTitle = By.xpath("//h2[contains(text(), 'Customer Success Stories')]");
    private By customersStoryTitle = By.xpath("//h3[contains(text(), 'Customers Story ')]");
    private By customersStoryReadMoreButton = By.xpath("//section[6]//a[contains(text(), 'Read more')]");
    private By readMoreCustomersStories = By.xpath("//a[contains(text(), 'Read our customer stories')]");

    private By driveProjectPanelItem = By.xpath("//a[@id='tab-link-1966']");
    private By optimizeResourcePanelItem = By.xpath("//a[@id='tab-link-1976']");
    private By billWithPrecisionPanelItem = By.xpath("//a[@id='tab-link-1986']");
    private By winBusinessPanelItem = By.xpath("//a[@id='tab-link-1996']");

    private By driveProjectSectionTitle = By.xpath("//*[@id='tab-content-1966']/div[1]/div/h3");
    private By optimizeResourceSectionTitle = By.xpath("//*[@id='tab-content-1976']/div[1]/div/h3");
    private By billWithPrecisionSectionTitle = By.xpath("//*[@id='tab-content-1986']/div[1]/div/h3");
    private By winBusinessSectionTitle = By.xpath("//*[@id='tab-content-1996']/div[1]/div/h3");

    private By erpReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][1]//*[contains(text(), 'Read more')]");
    private By financialPlanningReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][2]//*[contains(text(), 'Read more')]");
    private By humanCapitalReadMore = By.xpath("//*[contains(@class, 'tiles-info-body')]//*[contains(@class, 'tiles-info-tile-holder')][3]//*[contains(text(), 'Read more')]");

    private By peopleExperienceReadMore = By.xpath("//*[contains(text(), 'Learn more about our People')]");
    private By seeAllNews = By.xpath("//a[contains(text(), 'See all news')]");


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

    public boolean isCustomersStoryTitlePresent() {
        Reporter.log("'Customer Story: Magnox' Title is present");
        return isElementPresent(customersStoryTitle);
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

    public void clickReadMoreAboutERP() {
        scrollToElement(yourNewPeopleExperienceTitle);
        clickOnElement(erpReadMore);
        Reporter.log("clicking read more in 'ERP' block");
    }

    public void clickReadMoreAboutFinancialPlanning() {
        Reporter.log("clicking read more in 'Financial Capital' block");
        clickOnElement(financialPlanningReadMore);
    }

    public void clickReadMoreAboutHumanCapital() {
        Reporter.log("clicking read more in 'Human Capital' block");
        clickOnElement(humanCapitalReadMore);
    }

    public void clickLearnMoreAboutPplExperienceSuiteBtn() {
        Reporter.log("clicking 'Learn more about our People Experience Suite' button");
        scrollToElement(yourNewPeopleExperienceTitle);
        clickOnElement(peopleExperienceReadMore);
    }

    public void clickReadMoreAboutCustomersStory() {
        Reporter.log("clicking 'Read more' in 'Customer Overview: ...' section");
        clickOnElement(customersStoryReadMoreButton);
    }

    public void clickSeeAllNews() {
        Reporter.log("clicking 'See all news'");
        clickOnElement(seeAllNews);
    }

    public void compareNewsArticleNamesWithPages() {
        String newsElement = "//div[contains(@class, 'swiper-container')]/ul/li[%s]//h3/span";

        for (int i = 1; i <= 3; i++) {
            By item = By.xpath(String.format(newsElement, i));
            Reporter.log("Comparing name of News Block #" + i + " with title of opened page");
            String postTitle = getElementText(item);
            System.out.println(postTitle);
            clickOnElement(item);
            String currentBreadCrumb = breadCrumbsBasePage.getCurrentBreadCrumb();
            Assert.assertEquals(postTitle, currentBreadCrumb);
            getDriver().navigate().back();
            Assert.assertTrue(isMainTitlePresent());
        }
    }

    public void clickReadCustomersStories() {
        Reporter.log("clicking 'Read our customer stories' in 'Trusted by public sector organizations worldwide' section");
        clickOnElement(readMoreCustomersStories);
    }
}
