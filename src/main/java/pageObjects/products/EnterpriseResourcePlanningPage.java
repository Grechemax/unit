package pageObjects.products;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class EnterpriseResourcePlanningPage extends BasePage {
    private By mainTitle = By.xpath("//h1[contains(@class, 'section-title')]");
    private By elevateYourBusinessTitle = By.xpath("//section[2]/div[1]/div/h2");
    private By experienceSuiteTitle = By.xpath("//section[3]/div/div[1]/h2");
    private By createBetterWayTitle = By.xpath("//section[4]/div/div/div[1]/h2");
    private By warChildTitle = By.xpath("//section[5]/div/div/div[2]/div[1]/h3");

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

    public EnterpriseResourcePlanningPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public boolean isMainTitlePresent() {
        waitForElement(mainTitle);
        Reporter.log("Main title is present");
        return isElementPresent(mainTitle);
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
        return getElementText(mainTitle);
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
}
