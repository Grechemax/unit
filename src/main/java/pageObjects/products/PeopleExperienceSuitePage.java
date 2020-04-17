package pageObjects.products;

import base.BasePage;
import base.BreadCrumbsBasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PeopleExperienceSuitePage extends BasePage {
    BreadCrumbsBasePage breadCrumbsBasePage;


    private By mainPeopleExperienceSuiteHeader = By.xpath("//*[contains(text(), 'Improve your people')]");
    private By whyUnit4Button = By.xpath("//section[1]//a[contains(text(), 'Why Unit4')]");
    // why unit 4 button // button leads to whyPage
    private By peopleExperienceTitle = By.xpath("//*[contains(text(), 'The Unit4 People Experience Suite will humanize')]");
    private By builtOnUnit4Title = By.xpath("//*[contains(text(), 'Built on the Unit4 People Platform')]");
    private By backedByUnit4Title = By.xpath("//*[contains(text(), 'Backed by the full Unit4 People Experience Suite')]");

    private By enterpriseResourcePlanningBlock = By.xpath("//h3[contains(text(), 'Enterprise Resource Planning')]");
    private By financialPlanningBlock = By.xpath("//h3[contains(text(), 'Financial Planning & Analysis')]");
    private By humanCapitalManagementBlock = By.xpath("//h3[contains(text(), 'Human Capital Management')]");
    private By studentManagementBlock = By.xpath("//h3[contains(text(), 'Student Management')]");

    public PeopleExperienceSuitePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public boolean isMainTitlePresent() {
        waitForElement(mainPeopleExperienceSuiteHeader);
        Reporter.log("'Improve your people’s lives, and the people they serve will feel it' - main title is present");
        return isElementPresent(mainPeopleExperienceSuiteHeader);
    }

    public boolean isWhyUnit4ButtonPresent() {
        waitForElement(whyUnit4Button);
        Reporter.log("'Why Unit 4' button is present");
        return isElementPresent(whyUnit4Button);
    }

    public boolean isPeopleExperienceTitlePresent() {
        Reporter.log("'The Unit4 People Experience Suite will humanize...' Title is present");
        return isElementPresent(peopleExperienceTitle);
    }

    public boolean isBuiltOnUnit4TitleTitlePresent() {
        Reporter.log("'Built on the Unit4 People Platform Title is present");
        return isElementPresent(builtOnUnit4Title);
    }

    public boolean isBackedByUnit4TitlePresent() {
        Reporter.log("'Backed by the full Unit4 People Experience Suite' Title is present");
        return isElementPresent(backedByUnit4Title);
    }

    public void goToEnterpriseResourcePlanningPage() {
        Reporter.log("opening 'Enterprise Resource Planning' page");
        waitForElement(enterpriseResourcePlanningBlock);
        clickOnElement(enterpriseResourcePlanningBlock);
    }

    public void goToFinancialPlanningPage() {
        Reporter.log("opening 'Financial Planning & Analysis' page");
        waitForElement(financialPlanningBlock);
        clickOnElement(financialPlanningBlock);
    }

    public void goToHumanCapitalManagementPage() {
        Reporter.log("opening 'Human Capital Management' page");
        waitForElement(humanCapitalManagementBlock);
        clickOnElement(humanCapitalManagementBlock);
    }

    public void goToStudentManagementPage() {
        Reporter.log("opening 'Student Management' page");
        waitForElement(studentManagementBlock);
        clickOnElementUsingJS(studentManagementBlock);
    }

}






