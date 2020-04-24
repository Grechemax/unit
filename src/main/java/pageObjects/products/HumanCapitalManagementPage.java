package pageObjects.products;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HumanCapitalManagementPage extends BasePage {
    private By mainTitle = By.xpath("//h1[@class='section-title']");
    private By downloadBrochure = By.xpath("//a[contains(text(), 'Download product brochure')]");
    private By energizeYourPeopleTitle = By.xpath("//section[2]/div/div[1]/h2");
    private By humanCapitalManagementDeliversTitle = By.xpath("//section[3]/div/div[1]/h2");
    private By createBetterWayTitle = By.xpath("//section[4]/div/div/div[1]/h3");
    private By customerStoryTitle = By.xpath("//section[5]//*[contains(text(), 'Customer Story')]");
    private By trustedOrganizationsTitle = By.xpath("//section[6]/div/div/h2");

    private By payrollManagementPanelItem = By.xpath("//a[@id='tab-link-5616']");
    private By hrManagementPanelItem = By.xpath("//a[@id='tab-link-5626']");
    private By talentManagement_Performance_PanelItem = By.xpath("//a[@id='tab-link-5636']");
    private By talentManagement_Engagement_PanelItem = By.xpath("//a[@id='tab-link-5646']");
    private By talentManagement_Learning_PanelItem = By.xpath("//a[@id='tab-link-5656']");
    private By peoplePlanningPanelItem = By.xpath("//a[@id='tab-link-5666']");
    private By recruitmentPanelItem = By.xpath("//a[@id='tab-link-5676']");

    private By payrollManagementSectionTitle = By.xpath("//div[@id='tab-content-5616']/div[1]/div/h3");
    private By hrManagementSectionTitle = By.xpath("//div[@id='tab-content-5626']/div[1]/div/h3");
    private By talentManagement_Performance_SectionTitle = By.xpath("//div[@id='tab-content-5636']/div[1]/div/h3");
    private By talentManagement_Engagement_SectionTitle = By.xpath("//div[@id='tab-content-5646']/div[1]/div/h3");
    private By talentManagement_Learning_SectionTitle = By.xpath("//div[@id='tab-content-5656']/div[1]/div/h3");
    private By peoplePlanningSectionTitle = By.xpath("//div[@id='tab-content-5666']/div[1]/div/h3");
    private By recruitmentSectionTitle = By.xpath("//div[@id='tab-content-5676']/div[1]/div/h3");
    private By cityOfPortReadMore = By.xpath("//section[5]//a[contains(text(), 'Read more')]");
    private By seeMoreCustomersStories = By.xpath("//a[contains(text(), 'See more customer stories')]");
    private By downloadReportButton = By.xpath("//strong[contains(text(), '//a[contains(text(), 'Download the report')]");

    //Looking for one of our other Unit4 solutions?
    private By financialsLink = By.xpath("//strong[contains(text(), 'Unit4 Financials')]");
    private By erpLink = By.xpath("//strong[contains(text(), 'Unit4 Enterprise Resource Planning')]");
    private By humanCapitalManagementLink = By.xpath("//strong[contains(text(), 'Unit4 Human Capital Management')]");
    private By financialPlanningLink = By.xpath("//strong[contains(text(), 'Unit4 Financial Planning & Analysis')]");


    public HumanCapitalManagementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isMainTitlePresent() {
        waitForElement(mainTitle);
        Reporter.log("Main title is present");
        return isElementPresent(mainTitle);
    }

    public boolean isEnergizeYourPeopleTitlePresent() {
        Reporter.log("Energize your people title is present");
        return isElementPresent(energizeYourPeopleTitle);
    }

    public boolean isHumanCapitalManagementDeliversTitlePresent() {
        Reporter.log("Human Capital Management Delivers Title is present");
        return isElementPresent(humanCapitalManagementDeliversTitle);
    }

    public boolean isCreateBetterWayTitlePresent() {
        Reporter.log("Create better way title is present");
        return isElementPresent(createBetterWayTitle);
    }

    public boolean isCityOfPortTitlePresent() {
        Reporter.log("City of port title is present");
        return isElementPresent(customerStoryTitle);
    }

    public boolean isTrustedOrganizationsTitlePresent() {
        Reporter.log("Trusted organisations title is present");
        return isElementPresent(trustedOrganizationsTitle);
    }


    public String getMainTitleText() {
        return getElementText(mainTitle);
    }

    public String getEnergizeYourPeopleTitleText() {
        return getElementText(energizeYourPeopleTitle);
    }


    public String getHumanCapitalManagementDeliversTitleText() {
        return getElementText(humanCapitalManagementDeliversTitle);
    }

    public String getCreateBetterWayTitleText() {
        return getElementText(createBetterWayTitle);
    }

    public String getCityOfPortTitleTitleText() {
        return getElementText(customerStoryTitle);
    }

    public String getTrustedOrganisationsTitleText() {
        return getElementText(trustedOrganizationsTitle);
    }


    public boolean isPayrollManagementSectionTitlePresent() {
        clickOnElementUsingJS(payrollManagementPanelItem);
        waitForPresenceOfElement(findElement(payrollManagementSectionTitle));
        Reporter.log("Payroll Management Header is present");
        return isElementPresent(payrollManagementSectionTitle);
    }

    public boolean isHRSectionTitlePresent() {
        clickOnElementUsingJS(hrManagementPanelItem);
        waitForPresenceOfElement(findElement(hrManagementSectionTitle));
        Reporter.log("HR Management Header is present");
        return isElementPresent(hrManagementSectionTitle);
    }

    public boolean isTalentManagement_PerformanceSectionTitlePresent() {
        clickOnElementUsingJS(talentManagement_Performance_PanelItem);
        waitForPresenceOfElement(findElement(talentManagement_Performance_SectionTitle));
        Reporter.log("Talent Management - Performance Header is present");
        return isElementPresent(talentManagement_Performance_SectionTitle);
    }

    public boolean isTalentManagement_EngagementSectionTitlePresent() {
        clickOnElementUsingJS(talentManagement_Engagement_PanelItem);
        waitForPresenceOfElement(findElement(talentManagement_Engagement_SectionTitle));
        Reporter.log("Talent Management - Engagement Header is present");
        return isElementPresent(talentManagement_Engagement_SectionTitle);
    }

    public boolean isTalentManagement_LearningSectionTitlePresent() {
        clickOnElementUsingJS(talentManagement_Learning_PanelItem);
        waitForPresenceOfElement(findElement(talentManagement_Learning_SectionTitle));
        Reporter.log("Talent Management - Learning Header is present");
        return isElementPresent(talentManagement_Learning_SectionTitle);
    }

    public boolean isPeoplePlanningSectionTitlePresent() {
        clickOnElementUsingJS(peoplePlanningPanelItem);
        waitForPresenceOfElement(findElement(peoplePlanningSectionTitle));
        Reporter.log("People Planning Header is present");
        return isElementPresent(peoplePlanningSectionTitle);
    }

    public boolean isRecruitmentSectionTitlePresent() {
        clickOnElementUsingJS(recruitmentPanelItem);
        waitForPresenceOfElement(findElement(recruitmentSectionTitle));
        Reporter.log("HR Management Header is present");
        return isElementPresent(recruitmentSectionTitle);
    }


    public void clickReadMoreAboutCityOfPort() {
        Reporter.log("clicking 'Read more' in Customer Success Stories 'City of Port' block");
        clickOnElement(cityOfPortReadMore);
    }

    public void clickSeeMoreCustomersStories() {
        Reporter.log("clicking 'See more customer success stories' in 'Trusted by public sector organizations worldwide' section");
        clickOnElement(seeMoreCustomersStories);
    }

    public void clickDownloadTheReportBtn() {
        Reporter.log("clicking 'Download the report' in 'Employee Engagement Trends' section");
        clickOnElement(downloadReportButton);
    }


    public void clickDownloadProductBrochureBtn() {
        Reporter.log("clicking 'Download product brochure' button");
        clickOnElement(downloadBrochure);
    }



    //Looking for one of our other Unit4 solutions?
    public void clickERPLink() {
        Reporter.log("clicking 'ERP' link in 'Looking for one of our other Unit4 solutions?' section");
        clickOnElement(erpLink);
    }

    public void clickHCMLink() {
        Reporter.log("clicking 'HCM' link in 'Looking for one of our other Unit4 solutions?' section");
        clickOnElement(humanCapitalManagementLink);
    }

    public void clickFPALink() {
        Reporter.log("clicking 'FP&A' link in 'Looking for one of our other Unit4 solutions?' section");
        clickOnElement(financialPlanningLink);
    }

    public void clickFinancialsLink() {
        Reporter.log("clicking 'Financials' link in 'Looking for one of our other Unit4 solutions?' section");
        clickOnElement(financialsLink);
    }


}
