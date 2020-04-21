package pageObjects.products;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FinancialPlanningPage extends BasePage {


    private By mainTitle = By.xpath("//h1[contains(@class, 'section-title')]");
    private By mainLogo = By.xpath("//a[contains(@class, 'site-logo')]");
    private By downloadBrochure = By.xpath("//a[contains(text(), 'Download product brochure')]");
    private By gainMeaningfulInsightsTitle = By.xpath("//h2[contains(text(), 'Gain Meaningful Insights')]");
    private By financialPlanningTitle = By.xpath("//h2[contains(text(), 'Unit4 Financial Planning & Analysis Delivers')]");
    private By createBetterWayTitle = By.xpath("//h3[contains(text(), 'Create a Better Way to Work')]");
    private By austrianUniversityTitle = By.xpath("//h3[contains(text(), 'FH St Pölten')]");
    private By trustedOrganizationsTitle = By.xpath("//h2[contains(text(), 'Trusted worldwide by organizations that serve people')]");

    private By financialPlanningPanelItem = By.xpath("//span[contains(text(), 'Financial Planning, Budgeting & Forecasting')]");
    private By salesPlanningPanelItem = By.xpath("//span[contains(text(), 'Sales & Operations Planning')]");
    private By analyticsReportingPanelItem = By.xpath("//span[contains(text(), 'Analytics & Reporting')]");
    private By corporatePerformancePanelItem = By.xpath("//span[contains(text(), 'Corporate Performance Management')]");
    private By peoplePlanningPanelItem = By.xpath("//span[contains(text(), 'People Planning & Analytics')]");
    private By finalConsolidationPanelItem = By.xpath("//span[contains(text(), 'Financial Consolidation')]");
    private By ifrs16PanelItem = By.xpath("//span[contains(text(), 'IFRS 16')]");

    private By financialPlanningSectionTitle = By.xpath("//h3[contains(text(), 'Financial Planning, Budgeting & Forecasting')]");
    private By salesPlanningSectionTitle = By.xpath("//h3[contains(text(), 'Sales & Operations Planning')]");
    private By analyticsReportingSectionTitle = By.xpath("//h3[contains(text(), 'Analytics & Reporting')]");
    private By corporatePerformanceSectionTitle = By.xpath("//h3[contains(text(), 'Corporate Performance Management')]");
    private By peoplePlanningSectionTitle = By.xpath("//h3[contains(text(), 'People Planning & Analytics')]");
    private By finalConsolidationSectionTitle = By.xpath("//h3[contains(text(), 'Financial Consolidation')]");
    private By ifrs16SectionTitle = By.xpath("//h3[contains(text(), 'IFRS 16')]");
    private By readMoreFHstPolten = By.xpath("//section[5]//a[contains(text(), 'Read more')]");

    private By seeMoreCustomersStories = By.xpath("//a[contains(@class, 'cta-more logoblock_fpa')]");
    private By downloadResearchBundle = By.xpath("//a[contains(text(), 'Download our research bundle')]");
    //Looking for one of our other Unit4 solutions?
    private By financialsLink = By.xpath("//strong[contains(text(), 'Unit4 Financials')]");
    private By erpLink = By.xpath("//strong[contains(text(), 'Unit4 Enterprise Resource Planning')]");
    private By humanCapitalManagementLink = By.xpath("//strong[contains(text(), 'Unit4 Human Capital Management')]");
    private By financialPlanningLink = By.xpath("//strong[contains(text(), 'Unit4 Financial Planning & Analysis')]");


    public FinancialPlanningPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isMainTitlePresent() {
        waitForElement(mainTitle);
        Reporter.log("Main title is present");
        return isElementPresent(mainTitle);
    }

    public boolean isGainMeaningfulInsightsTitlePresent() {
        Reporter.log("Gain Meaningful Insights title is present");
        waitForElement(gainMeaningfulInsightsTitle);
        return isElementPresent(gainMeaningfulInsightsTitle);
    }

    public boolean isFinancialPlanningTitlePresent() {
        Reporter.log("Financial Planning title is present");
        return isElementPresent(financialPlanningTitle);
    }

    public boolean isCreateBetterWayTitleTitlePresent() {
        Reporter.log("Create a Better Way title is present");
        return isElementPresent(createBetterWayTitle);
    }

    public boolean isAustrianUniversityPresent() {
        Reporter.log("FH St Pölten title is present");
        return isElementPresent(austrianUniversityTitle);
    }

    public boolean isTrustedOrganizationsTitlePresent() {
        Reporter.log("Trusted Organizations title is present");
        return isElementPresent(trustedOrganizationsTitle);
    }

    public String getMainTitleText() {
        return getElementText(mainTitle);
    }

    public String getMeaningfulInsightsTitleText() {
        return getElementText(gainMeaningfulInsightsTitle);
    }

    public String getFinancialPlanningTitleText() {
        return getElementText(financialPlanningTitle);
    }

    public String getCreateBetterWayTitleText() {
        return getElementText(createBetterWayTitle);
    }

    public String getAustrianUniversityTitleText() {
        return getElementText(austrianUniversityTitle);
    }

    public String getTrustedOrganizationsTitleText() {
        return getElementText(trustedOrganizationsTitle);
    }


    public boolean isFinancialPlanningSideHeaderPresent() {
        clickOnElementUsingJS(financialPlanningPanelItem);
        waitForPresenceOfElement(findElement(financialPlanningSectionTitle));
        Reporter.log("Financial Planning Header is present");
        return isElementPresent(findElement(financialPlanningSectionTitle));
    }

    public boolean isSalesPlanningSideHeaderPresent() {
        clickOnElementUsingJS(salesPlanningPanelItem);
        waitForPresenceOfElement(findElement(salesPlanningSectionTitle));
        Reporter.log("Sales Planning Header is present");
        return isElementPresent(findElement(salesPlanningSectionTitle));
    }

    public boolean isAnalyticsReportingSectionHeaderPresent() {
        clickOnElementUsingJS(analyticsReportingPanelItem);
        waitForPresenceOfElement(findElement(analyticsReportingSectionTitle));
        Reporter.log("Analytics Header is present");
        return isElementPresent(findElement(analyticsReportingSectionTitle));
    }

    public boolean isCorporatePerformanceSectionHeaderPresent() {
        clickOnElementUsingJS(corporatePerformancePanelItem);
        waitForPresenceOfElement(findElement(corporatePerformanceSectionTitle));
        Reporter.log("Corporate Performance PanelItem Header is present");
        return isElementPresent(findElement(corporatePerformanceSectionTitle));
    }

    public boolean isPeoplePlanningSectionHeaderPresent() {
        clickOnElementUsingJS(peoplePlanningPanelItem);
        waitForPresenceOfElement(findElement(peoplePlanningSectionTitle));
        Reporter.log("Corporate Performance Header is present");
        return isElementPresent(findElement(peoplePlanningSectionTitle));
    }

    public boolean isFinalConsolidationSectionHeaderPresent() {
        clickOnElementUsingJS(finalConsolidationPanelItem);
        waitForPresenceOfElement(findElement(finalConsolidationSectionTitle));
        Reporter.log("Final Consolidation Header is present");
        return isElementPresent(findElement(finalConsolidationSectionTitle));
    }

    public boolean isIfrs16SectionHeaderPresent() {
        clickOnElementUsingJS(ifrs16PanelItem);
        waitForPresenceOfElement(findElement(ifrs16SectionTitle));
        Reporter.log("ifrs16 Section Header is present");
        return isElementPresent(findElement(ifrs16SectionTitle));
    }

    public void clickReadMoreAboutFHstPolten() {
        Reporter.log("clicking 'Read more' in 'Customer Overview: FH St Pölten' block");
        clickOnElement(readMoreFHstPolten);
    }

    public void clickSeeMoreCustomersStories() {
        Reporter.log("clicking 'See more customer success stories in 'Trusted by public sector organizations worldwide' section");
        clickOnElement(seeMoreCustomersStories);
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

    public void clickDownloadBrochure() {
        Reporter.log("clicking 'Download product brochure' button");
        clickOnElement(downloadBrochure);
    }

    public void clickDownloadResearchBundle() {
        Reporter.log("clicking 'Download our research bundle' button");
        clickOnElement(downloadResearchBundle);
    }

    public void clickMainLogo() {
        Reporter.log("clicking on main logo");
        clickOnElement(mainLogo);
    }
}







