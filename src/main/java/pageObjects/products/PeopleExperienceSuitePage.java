package pageObjects.products;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;

public class PeopleExperienceSuitePage extends BasePage {
    private By mainPeopleExperienceSuiteHeader = By.xpath("//*[contains(text(), 'Improve your people’s lives')]");
    // why unit 4 button // button leads to whyPage
    private By peopleExperienceTitle = By.xpath("//*[contains(text(), 'The Unit4 People Experience Suite will humanize')]");
    private By builtOnUnit4Title = By.xpath("//*[contains(text(), 'Built on the Unit4 People Platform')]");
    private By backedByUnit4Title = By.xpath("//*[contains(text(), 'Backed by the full Unit4 People Experience Suite')]");

    private By enterpriseResourcePlanningBlock = By.xpath("//h3[contains(text(), 'Enterprise Resource Planning')]");
    private By financialPlanningBlock = By.xpath("//h3[contains(text(), 'Financial Planning & Analysis')]");
    private By humanCapitalManagementBlock = By.xpath("//h3[contains(text(), 'Human Capital Management')]");
    private By studentManagementBlock = By.xpath("//h3[contains(text(), 'Student Management')]");


    public boolean isMainTitlePresent() {
        waitForElement(mainPeopleExperienceSuiteHeader);
        Reporter.log("'Improve your people’s lives, and the people they serve will feel it' - main title is present");
        return isElementPresent(mainPeopleExperienceSuiteHeader);
    }

    public boolean isYPeopleExperienceTitle() {
        Reporter.log("'The Unit4 People Experience Suite will humanize...' Title is present");
        return isElementPresent(peopleExperienceTitle);
    }

    public boolean isBuiltOnUnit4TitleTitle() {
        Reporter.log("'Built on the Unit4 People Platform Title is present");
        return isElementPresent(builtOnUnit4Title);
    }

    public boolean isBackedByUnit4Title() {
        Reporter.log("'Backed by the full Unit4 People Experience Suite' Title is present");
        return isElementPresent(backedByUnit4Title);
    }

    public boolean goToEnterpriseResourcePlanningPage() {
        Reporter.log("opening 'Enterprise Resource Planning' page");
        return isElementPresent(enterpriseResourcePlanningBlock);
    }

    public boolean goToFinancialPlanningPage() {
        Reporter.log("opening 'Financial Planning & Analysis' page");
        return isElementPresent(financialPlanningBlock);
    }

    public boolean goToHumanCapitalManagementPage() {
        Reporter.log("opening 'Human Capital Management' page");
        return isElementPresent(humanCapitalManagementBlock);
    }

    public boolean goToStudentManagementPage() {
        Reporter.log("opening 'Student Management' page");
        return isElementPresent(studentManagementBlock);
    }

}






