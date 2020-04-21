package pageObjects.products;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class EnterpriseResourcePlanningPage extends BasePage {
    private By erpMainTitle = By.xpath("//h1[contains(text(), 'Unit4 Enterprise Resource Planning')]");
    private By downloadBrochure = By.xpath("//a[contains(text(), 'Download product brochure')]");
    private By elevateYourBusinessTitle = By.xpath("//section[2]/div[1]/div/h2");
    private By experienceSuiteTitle = By.xpath("//section[3]/div/div[1]/h2");
    private By createBetterWayTitle = By.xpath("//section[4]/div/div/div[1]/h2");
    private By warChildTitle = By.xpath("//*[contains(text(), 'War Child')]");

    private By financialManagementPanelItem = By.xpath("//a[@id='tab-link-1716']");
    private By projectManagementPanelItem = By.xpath("//a[@id='tab-link-4436']");
    private By procurementManagementPanelItem = By.xpath("//a[@id='tab-link-1736']");
    private By operationalReportingPanelItem = By.xpath("//a[@id='tab-link-1756']");
    private By hrPanelItem = By.xpath("//a[@id='tab-link-1726']");
    private By fieldServiceManagementPanelItem = By.xpath("//a[@id='tab-link-1746']");
    private By financialManagementSectionTitle = By.xpath("//div[@id='tab-content-1716']/div[1]/div/h3");
    private By projectManagementSectionTitle = By.xpath("//div[@id='tab-content-4436']/div[1]/div/h3");
    private By procurementManagementSectionTitle = By.xpath("//div[@id='tab-content-1736']/div[1]/div/h3");
    private By operationalReportingSectionTitle = By.xpath("//div[@id='tab-content-1756']/div[1]/div/h3");
    private By hrSectionTitle = By.xpath("//div[@id='tab-content-1726']/div[1]/div/h3");
    private By fieldServiceManagementSectionTitle = By.xpath("//div[@id='tab-content-1746']/div[1]/div/h3");
    private By readMoreWarChild = By.xpath("//section[5]//a[contains(text(), 'Read more')]");
    //Looking for one of our other Unit4 solutions?
    private By financialsLink = By.xpath("//strong[contains(text(), 'Unit4 Financials')]");
    private By erpLink = By.xpath("//strong[contains(text(), 'Unit4 Enterprise Resource Planning')]");
    private By humanCapitalManagementLink = By.xpath("//strong[contains(text(), 'Unit4 Human Capital Management')]");
    private By financialPlanningLink = By.xpath("//strong[contains(text(), 'Unit4 Financial Planning & Analysis')]");

    private By readMoreCustomersStories = By.xpath("//a[contains(text(), 'Read our customer stories')]");


    public EnterpriseResourcePlanningPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public boolean isERPMainTitlePresent() {
        waitForElement(erpMainTitle);
        Reporter.log("Main title is present");
        return isElementPresent(erpMainTitle);
    }

    public boolean isElevateYourBusinessTitlePresent() {
        Reporter.log("ElevateYourBusinessTitle present");
        return isElementPresent(elevateYourBusinessTitle);
    }

    public boolean isExperienceSuiteTitlePresent() {
        Reporter.log("Experience Suite Title is present");
        return isElementPresent(experienceSuiteTitle);
    }

    public boolean isCreateBetterWayTitlePresent() {
        Reporter.log("'Create Better Way' title is present");
        return isElementPresent(createBetterWayTitle);
    }

    public boolean isWarChildPresent() {
        Reporter.log("'War Child' title is present");
        return isElementPresent(warChildTitle);
    }

    public String getMainTitleText() {
        return getElementText(erpMainTitle);
    }

    public String getElevateYourBusinessTitleText() {
        return getElementText(elevateYourBusinessTitle);
    }

    public String getCreateBetterWayTitleText() {
        return getElementText(createBetterWayTitle);
    }

    public String getExperienceSuiteTitleText() {
        return getElementText(experienceSuiteTitle);
    }

    public String getWarChildTitleText() {
        return getElementText(warChildTitle);
    }

    public boolean isFinancialManagementHeaderPresent() {
        clickOnElementUsingJS(financialManagementPanelItem);
        waitForPresenceOfElement(findElement(financialManagementSectionTitle));
        Reporter.log("Financial Management Header is present");
        return isElementPresent(financialManagementSectionTitle);
    }

    public boolean isProjectManagementSectionTitlePresent() {
        clickOnElementUsingJS(projectManagementPanelItem);
        waitForPresenceOfElement(findElement(projectManagementSectionTitle));
        Reporter.log("Project Management Header is present");
        return isElementPresent(projectManagementSectionTitle);
    }

    public boolean isProcurementManagementSectionTitlePresent() {
        clickOnElementUsingJS(procurementManagementPanelItem);
        waitForPresenceOfElement(findElement(procurementManagementSectionTitle));
        Reporter.log("Procurement Management Header is present");
        return isElementPresent(procurementManagementSectionTitle);
    }

    public boolean isOperationalReportingSectionTitlePresent() {
        clickOnElementUsingJS(operationalReportingPanelItem);
        waitForPresenceOfElement(findElement(operationalReportingSectionTitle));
        Reporter.log("Operational Reporting Header is present");
        return isElementPresent(operationalReportingSectionTitle);
    }

    public boolean isHRSectionTitlePresent() {
        clickOnElementUsingJS(hrPanelItem);
        waitForPresenceOfElement(findElement(hrSectionTitle));
        Reporter.log("HR & Payroll Header is present");
        return isElementPresent(hrSectionTitle);
    }

    public boolean isFieldServiceManagementSectionTitlePresent() {
        clickOnElementUsingJS(fieldServiceManagementPanelItem);
        waitForPresenceOfElement(findElement(fieldServiceManagementSectionTitle));
        Reporter.log("Field Service Management Header is present");
        return isElementPresent(fieldServiceManagementSectionTitle);
    }

    public void clickDownloadBrochure() {
        Reporter.log("clicking 'Download product brochure' button");
        clickOnElement(downloadBrochure);
    }

    public void clickReadMoreAboutWarChild() {
        Reporter.log("clicking read more in 'Customer Overview: War Child' block");
        clickOnElement(readMoreWarChild);
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

    public void clickReadCustomersStories() {
        Reporter.log("clicking 'See more customer success stories in 'Trusted by public sector organizations worldwide' section");
        clickOnElement(readMoreCustomersStories);
    }
}
