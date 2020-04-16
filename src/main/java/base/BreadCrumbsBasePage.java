package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BreadCrumbsBasePage extends BasePage {

    private By productsCrumb = By.xpath("//ol/li[last() and contains(text(), 'Products')]");
    private By financialsCrumb = By.xpath("//ol/li[last() and contains(text(), 'Financials')]");
    private By financialPlanningCrumb = By.xpath("//ol/li[last() and contains(text(), 'Financial Planning')]");
    private By humanCapitalManagementCrumb = By.xpath("//ol/li[last() and contains(text(), 'Human Capital')]");
    private By studentManagementCrumb = By.xpath("//ol/li[last() and contains(text(), 'Student Management')]");
    private By enterpriseResourcePlanningCrumb = By.xpath("//ol/li[last() and contains(text(), 'Enterprise Resource Planning')]");
    private By peopleExperienceSuiteCrumb = By.xpath("//ol/li[last() and contains(text(), 'The People Experience Suite')]");
    private By industriesCrumb = By.xpath("//ol/li[last() and contains(text(), 'Industries')]");
    private By higherEducationCrumb = By.xpath("//ol/li[last() and contains(text(), 'Higher Education')]");
    private By nonProfitCrumb = By.xpath("//ol/li[last() and contains(text(), 'Nonprofit')]");
    private By professionalServicesCrumb = By.xpath("//ol/li[last() and contains(text(), 'Professional Services')]");
    private By publicSectorCrumb = By.xpath("//ol/li[last() and contains(text(), 'Public Sector')]");
    private By customersCrumb = By.xpath("//ol/li[last() and contains(text(), 'Customers')]");
    private By cityOfPortCrumb = By.xpath("//ol/li[last() and contains(text(), 'Customer Overview: City of Port Coquitlam')]");
    private By fh_st_PoltenCrumb = By.xpath("//ol/li[last() and contains(text(), 'Customer Overview: FH St Pölten')]");
    private By manchesterCrumb = By.xpath("//ol/li[last() and contains(text(), 'Customer Overview: Manchester Metropolitan University')]");
    private By screwfixCrumb = By.xpath("//ol/li[last() and contains(text(), 'Customer Overview: Screwfix')]");
    private By stanleySecurityCrumb = By.xpath("//ol/li[last() and contains(text(), 'Customer Overview: Stanley Security')]");
    private By warChildCrumb = By.xpath("//ol/li[last() and contains(text(), 'Customer Overview: War Child')]");
    private By blogCrumb = By.xpath("//ol/li[last() and contains(text(), 'Blog')]");
    private By eventsCrumb = By.xpath("//ol/li[last() and contains(text(), 'Events')]");
    private By libraryCrumb = By.xpath("//ol/li[last() and contains(text(), 'Library')]");
    private By whyUnit4Crumb = By.xpath("//ol/li[last() and contains(text(), 'Why Unit4')]");
    private By deliver360Crumb = By.xpath("//ol/li[last() and contains(text(), 'Deliver a 360')]");
    private By newsHomePageCrumb = By.xpath("//ol/li[last() and contains(text(), 'News')]");



    public BreadCrumbsBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isProductCrumbVisible() {
        waitForElement(productsCrumb);
        return isElementPresent(productsCrumb);
    }

    public boolean isProductsERPCrumbCrumbVisible() {
        waitForElement(enterpriseResourcePlanningCrumb);
        return isElementPresent(enterpriseResourcePlanningCrumb);
    }

    public boolean isFinancialPlanningCrumbVisible() {
        waitForElement(financialPlanningCrumb);
        return isElementPresent(financialPlanningCrumb);
    }

    public boolean isFinancialsCrumbVisible() {
        waitForElement(financialsCrumb);
        return isElementPresent(financialsCrumb);
    }

    public boolean isHumanCapitalManagementCrumbVisible() {
        waitForElement(humanCapitalManagementCrumb);
        return isElementPresent(humanCapitalManagementCrumb);
    }

    public boolean isStudentManagementCrumbVisible() {
        waitForElement(studentManagementCrumb);
        return isElementPresent(studentManagementCrumb);
    }

    public boolean isPeopleExperienceSuiteCrumbVisible() {
        waitForElement(peopleExperienceSuiteCrumb);
        return isElementPresent(peopleExperienceSuiteCrumb);
    }

    public boolean isIndustriesCrumbVisible() {
        waitForElement(industriesCrumb);
        return isElementPresent(industriesCrumb);
    }

    public boolean isHigherEducationCrumbVisible() {
        waitForElement(higherEducationCrumb);
        return isElementPresent(higherEducationCrumb);
    }

    public boolean isNonProfitCrumbVisible() {
        waitForElement(nonProfitCrumb);
        return isElementPresent(nonProfitCrumb);
    }

    public boolean isProfessionalServicesCrumbVisible() {
        waitForElement(professionalServicesCrumb);
        return isElementPresent(professionalServicesCrumb);
    }

    public boolean isPublicSectorCrumbVisible() {
        waitForElement(publicSectorCrumb);
        return isElementPresent(publicSectorCrumb);
    }

    //Customers
    public boolean isCustomersCrumbVisible() {
        waitForElement(customersCrumb);
        Reporter.log("Checking breadcrumbs on 'Customers Home' Page");
        return isElementPresent(customersCrumb);
    }

    public boolean isCityOfPortCrumbVisible() {
        waitForElement(cityOfPortCrumb);
        Reporter.log("Checking breadcrumbs on 'City of Port' Page");
        return isElementPresent(cityOfPortCrumb);
    }

    public boolean isFHstPoltenCrumbVisible() {
        waitForElement(fh_st_PoltenCrumb);
        Reporter.log("Checking breadcrumbs on 'FH St Pölten' Page");
        return isElementPresent(fh_st_PoltenCrumb);
    }

    public boolean isManchesterCrumbVisible() {
        waitForElement(manchesterCrumb);
        Reporter.log("Checking breadcrumbs on 'Manchester' Page");
        return isElementPresent(manchesterCrumb);
    }

    public boolean isScrewfixCrumbVisible() {
        waitForElement(screwfixCrumb);
        Reporter.log("Checking breadcrumbs on 'Screwfix' Page");
        return isElementPresent(screwfixCrumb);
    }

    public boolean isStanleySecurityCrumbVisible() {
        waitForElement(stanleySecurityCrumb);
        Reporter.log("Checking breadcrumbs on 'Stanley Security' Page");
        return isElementPresent(stanleySecurityCrumb);
    }

    public boolean isWarChildCrumbVisible() {
        waitForElement(warChildCrumb);
        Reporter.log("Checking breadcrumbs on 'WarChild' Page");
        return isElementPresent(warChildCrumb);
    }


    public boolean isNewsHomePageCrumbVisible() {
        waitForElement(newsHomePageCrumb);
        Reporter.log("Checking breadcrumbs on 'News' Page");
        return isElementPresent(newsHomePageCrumb);
    }

    public boolean isBlogCrumbVisible() {
        waitForElement(blogCrumb);
        return isElementPresent(blogCrumb);
    }

    public boolean isEventsCrumbVisible() {
        waitForElement(eventsCrumb);
        return isElementPresent(eventsCrumb);
    }

    public boolean isLibraryCrumbVisible() {
        waitForElement(libraryCrumb);
        return isElementPresent(libraryCrumb);
    }

    public boolean isWhyUnit4CrumbVisible() {
        waitForElement(whyUnit4Crumb);
        return isElementPresent(whyUnit4Crumb);
    }

    public boolean isDeliver360CrumbVisible() {
        waitForElement(deliver360Crumb);
        return isElementPresent(deliver360Crumb);
    }

    public void goToProductsViaBreadCrumb() {
        waitForElementClickable(productsCrumb);
        clickOnElement(productsCrumb);
    }

    public void goToPeopleExperienceSuiteViaBreadCrumb() {
        waitForElementClickable(peopleExperienceSuiteCrumb);
        clickOnElement(peopleExperienceSuiteCrumb);
    }

}
