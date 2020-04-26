package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HeaderBasePage extends BasePage {
    private By productsHeaderItem = By.xpath("//*[@id='sitenav']//a[contains(text(), 'Products')]");
    private By industriesHeaderItem = By.xpath("//*[@id='sitenav']//a[contains(text(), 'Industries')]");
    private By customersHeaderItem = By.xpath("//*[@id='sitenav']//a[contains(text(), 'Customers')]");
    private By resourcesHeaderItem = By.xpath("//*[@id='sitenav']//a[contains(text(), 'Resources')]");
    private By whyUnit4HeaderItem = By.xpath("//*[@id='sitenav']//a[contains(text(), 'Why Unit4')]");
    private By communityHeaderItem = By.xpath("//*[@id='sitenav']//a[contains(text(), 'Community')]");

    private By requestDemoCTA = By.xpath("//*[contains(@class, 'sitenav')]//*[contains(text(), 'Request a demo')]");
    private By magnifierIconToOpenSearch = By.xpath("//button[contains(@class, 'search-button-open')]");
    private By collapseSearchInputButton = By.xpath("//*[@id='site-search-close']");
    private By magnifierIconToSubmit = By.xpath("//*[@id='site-search-button-desktop']");
    private By searchInput = By.xpath("//input[contains(@placeholder, 'Enter search')]");

    private By enterpriseResourcePlanningDrpdwnItem = By.xpath("//a[contains(text(), 'Enterprise Resource Planning')]");
    private By financialPlanningDrpdwnItem = By.xpath("//a[contains(text(), 'Financial Planning & Analysis')]");
    private By humanCapitalManagementDrpdwnItem = By.xpath("//a[contains(text(), 'Human Capital Management')]");
    private By studentManagementDrpdwnItem = By.xpath("//a[contains(text(), 'Student Management')]");
    private By thePeopleExperienceSuiteDrpdwnItem = By.xpath("//ul//*[contains(text(), 'The People Experience Suite')]");
    private By viewAllIndustriesDrpdwnItem = By.xpath("//a[contains(text(), 'View all industries')]");

    private By higherEducation = By.xpath("//*[contains(text(), 'Higher Education')]");
    private By nonProfit = By.xpath("//*[contains(text(), 'Nonprofit')]");
    private By professionalServices = By.xpath("//*[contains(text(), 'Professional Services')]");
    private By publicSector = By.xpath("//*[contains(text(), 'Public Sector')]");

    private By blog = By.xpath("//*[@id='sitenav']/nav/ul/li[4]/div/ul/li[1]");
    private By events = By.xpath("//*[@id='sitenav']/nav/ul/li[4]/div/ul/li[2]");
    private By library = By.xpath("//*[@id='sitenav']/nav/ul/li[4]/div/ul/li[3]");

    public HeaderBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void goToERP() {
        Reporter.log("hovering and clicking ERP");
        hoverOverElement(productsHeaderItem);
        clickOnElement(enterpriseResourcePlanningDrpdwnItem);
    }

    public void goToFinancialPlanning() {
        Reporter.log("hovering and clicking FinPlanning");
        hoverOverElement(productsHeaderItem);
        clickOnElement(financialPlanningDrpdwnItem);
    }

    public void goToHumanCapital() {
        Reporter.log("hovering and clicking Human Capital");
        hoverOverElement(productsHeaderItem);
        clickOnElement(humanCapitalManagementDrpdwnItem);
    }

    public void goToStudentsManagement() {
        Reporter.log("hovering and clicking Students Management");
        hoverOverElement(productsHeaderItem);
        clickOnElement(studentManagementDrpdwnItem);
    }

    public void goToPeopleExperience() {
        Reporter.log("hovering and clicking 'The People Experience Suite'");
        hoverOverElement(productsHeaderItem);
        clickOnElement(thePeopleExperienceSuiteDrpdwnItem);
    }


    //Industries
    public void goToHigherEducation() {
        Reporter.log("hovering and clicking 'Higher Education'");
        hoverOverElement(industriesHeaderItem);
        clickOnElement(higherEducation);
    }

    public void goToNonprofit() {
        Reporter.log("hovering and clicking 'Nonprofit'");
        hoverOverElement(industriesHeaderItem);
        clickOnElement(nonProfit);
    }

    public void goToProfessionalServices() {
        Reporter.log("hovering and clicking 'Professional Services'");
        hoverOverElement(industriesHeaderItem);
        clickOnElement(professionalServices);
    }

    public void goToPublicSector() {
        Reporter.log("hovering and clicking 'Public Sector'");
        hoverOverElement(industriesHeaderItem);
        clickOnElement(publicSector);
    }

    public void goToIndustriesHome() {
        Reporter.log("hovering and clicking 'View all industries'");
        hoverOverElement(industriesHeaderItem);
        clickOnElement(viewAllIndustriesDrpdwnItem);
    }

    public void goToCustomersHome() {
        Reporter.log("clicking 'Customers'");
        clickOnElement(customersHeaderItem);
    }


    //Resources
    public void goToBlog() {
        Reporter.log("hovering and clicking 'Blog'");
        hoverOverElement(resourcesHeaderItem);
        clickOnElement(blog);
    }

    public void goToEvents() {
        Reporter.log("hovering and clicking 'Events'");
        hoverOverElement(resourcesHeaderItem);
        clickOnElement(events);
    }

    public void goToLibrary() {
        Reporter.log("hovering and clicking 'Library'");
        hoverOverElement(resourcesHeaderItem);
        clickOnElement(library);
    }

    public void goToWhyUnit4() {
        Reporter.log("hovering and clicking 'Why Unit4'");
        clickOnElement(whyUnit4HeaderItem);
    }


    public void clickRequestDemoForm() {
        Reporter.log("opening Request Demo Form");
        clickOnElement(requestDemoCTA);
    }

    public void clickCommunityHeaderItem() {
        Reporter.log("opening Community");
        clickOnElement(communityHeaderItem);
    }

    public void inputDataToSearchInput(String query) {
        Reporter.log("inputting query");
        clickOnElement(magnifierIconToOpenSearch);
        getDriver().findElement(searchInput).sendKeys(query);
    }

    public void submitSearchViaSearchIcon() {
        waitForElement(magnifierIconToSubmit);
        Reporter.log("submitting search with search icon");
        clickOnElement(magnifierIconToSubmit);
        clickElementIfPresent(By.id("icon-search"),35);
    }

    public void submitSearchViaReturn() {
        Reporter.log("submitting search with pressing 'Enter'");
        getDriver().findElement(searchInput).sendKeys(Keys.RETURN);
    }

    public void collapseSearchInput() {
        Reporter.log("submitting search with pressing 'Enter'");
        clickOnElement(collapseSearchInputButton);
    }

    public boolean isMagnifierIconToSubmitPresent() {
        return isElementPresent(magnifierIconToSubmit);
    }

}
