package pageObjects.products;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StudentManagementPage extends BasePage {


    private By studentManagementMainTitle = By.xpath("//h1[contains(text(), 'Unit4 Student Management')]");
    private By downloadBrochure = By.xpath("//a[contains(text(), 'Download product brochure')]");
    private By supportGrowthInLearningTitle = By.xpath("//section[2]/div[1]/div/section/div/div/h3");
    private By studentsManagementDeliversTitle = By.xpath("//section[3]/div/div[1]/h2");
    private By createBetterWayTitle = By.xpath("//section[4]/div/div/div[1]/h3");
    private By manchesterUniversityTitle = By.xpath("//*[contains(text(), 'Manchester Metropolitan University')]");
    private By trustedOrganizationsTitle = By.xpath("//section[6]/div/div/h2");


    private By admissionsPanelItem = By.xpath("//a[@id='tab-link-3936']");
    private By academicsPanelItem = By.xpath("//a[@id='tab-link-3946']");
    private By billingPanelItem = By.xpath("//a[@id='tab-link-3956']");
    private By communicationPanelItem = By.xpath("//a[@id='tab-link-3966']");
    private By reportingPanelItem = By.xpath("//a[@id='tab-link-3976']");


    private By admissionsSectionTitle = By.xpath("//div[@id='tab-content-3936']/div[1]/div/h3");
    private By academicsSectionTitle = By.xpath("//div[@id='tab-content-3946']/div[1]/div/h3");
    private By billingSectionTitle = By.xpath("//div[@id='tab-content-3956']/div[1]/div/h3");
    private By reportingSectionTitle = By.xpath("//div[@id='tab-content-3976']/div[1]/div/h3");
    private By seeMoreCustomersStories = By.xpath("//a[contains(text(), 'customer stories')]");
    private By communicationSectionTitle = By.xpath("//div[@id='tab-content-3966']/div[1]/div/h3");
    private By manchesterUniversityReadMore = By.xpath("//section[5]//a[contains(text(), 'Read more')]");

    //Looking for one of our other Unit4 solutions?
    private By financialsLink = By.xpath("//strong[contains(text(), 'Unit4 Financials')]");
    private By erpLink = By.xpath("//strong[contains(text(), 'Unit4 Enterprise Resource Planning')]");
    private By humanCapitalManagementLink = By.xpath("//strong[contains(text(), 'Unit4 Human Capital Management')]");
    private By financialPlanningLink = By.xpath("//strong[contains(text(), 'Unit4 Financial Planning & Analysis')]");

    public StudentManagementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isMainTitlePresent() {
        waitForElement(studentManagementMainTitle);
        Reporter.log("Main title is present");
        return isElementPresent(studentManagementMainTitle);
    }

    public boolean isSupportGrowthTitlePresent() {
        Reporter.log("supportGrowth title is present");
        return isElementPresent(supportGrowthInLearningTitle);
    }

    public boolean isStudentsManagementTitlePresent() {
        Reporter.log("Students Management Delivers  title is present");
        return isElementPresent(studentsManagementDeliversTitle);
    }

    public boolean isCreateBetterWayTitlePresent() {
        Reporter.log("Create better way title is present");
        return isElementPresent(createBetterWayTitle);
    }

    public boolean isManchesterUniversityTitlePresent() {
        Reporter.log("Manchester University title is present");
        return isElementPresent(manchesterUniversityTitle);
    }

    public boolean isTrustedOrganizationsTitlePresent() {
        Reporter.log("Trusted organisations title is present");
        return isElementPresent(trustedOrganizationsTitle);
    }

    public String getMainTitleText() {
        return getElementText(studentManagementMainTitle);
    }

    public String getSupportGrowthInLearningTitleText() {
        return getElementText(supportGrowthInLearningTitle);
    }

    public String getStudentsManagementDeliversTitleText() {
        return getElementText(studentsManagementDeliversTitle);
    }

    public String getCreateBetterWayTitleText() {
        return getElementText(createBetterWayTitle);
    }

    public String getManchesterUniversityTitleText() {
        return getElementText(manchesterUniversityTitle);
    }

    public String getTrustedOrganisationsTitleText() {
        return getElementText(trustedOrganizationsTitle);
    }

    public boolean isAdmissionsSectionTitlePresent() {
        clickOnElementUsingJS(admissionsPanelItem);
        waitForPresenceOfElement(findElement(admissionsSectionTitle));
        Reporter.log("Admissions Header is present");
        return isElementPresent(admissionsSectionTitle);
    }

    public boolean isAcademicsSectionTitlePresent() {
        clickOnElementUsingJS(academicsPanelItem);
        waitForPresenceOfElement(findElement(academicsSectionTitle));
        Reporter.log("Academics Header is present");
        return isElementPresent(academicsSectionTitle);
    }

    public boolean isBillingSectionTitlePresent() {
        clickOnElementUsingJS(billingPanelItem);
        waitForPresenceOfElement(findElement(billingSectionTitle));
        Reporter.log("billing Header is present");
        return isElementPresent(billingSectionTitle);
    }

    public boolean isCommunicationSectionTitlePresent() {
        clickOnElementUsingJS(communicationPanelItem);
        waitForPresenceOfElement(findElement(communicationSectionTitle));
        Reporter.log("billing Header is present");
        return isElementPresent(communicationSectionTitle);
    }

    public boolean isReportingSectionTitlePresent() {
        clickOnElementUsingJS(reportingPanelItem);
        waitForPresenceOfElement(findElement(reportingSectionTitle));
        Reporter.log("billing Header is present");
        return isElementPresent(reportingSectionTitle);
    }

    public void clickSeeMoreCustomersStories() {
        Reporter.log("clicking 'See more customer success stories' in 'Trusted by public sector organizations worldwide' section");
        clickOnElement(seeMoreCustomersStories);
    }

    public void clickReadMoreAboutManchesterUniversity() {
        Reporter.log("clicking 'Read more' in 'Customer Overview: Manchester Metropolitan University' section");
        clickOnElement(manchesterUniversityReadMore);
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
}
