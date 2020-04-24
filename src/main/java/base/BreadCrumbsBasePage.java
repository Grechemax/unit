package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BreadCrumbsBasePage extends BasePage {

    private By homeCrumb = By.xpath("//*[@class='u4-breadcrumb']//*[contains(text(), 'Home')]");
    private By cookiesCrumb = By.xpath("//*[@class='u4-breadcrumb']//*[contains(text(), 'Cookies')]");
    private By productsHomeCrumb = By.xpath("//ol/li[last() and contains(text(), 'Products')]");
    private By financialsCrumb = By.xpath("//ol/li[last() and contains(text(), 'Financials')]");
    private By financialPlanningCrumb = By.xpath("//ol/li[last() and contains(text(), 'Financial Planning')]");
    private By humanCapitalManagementCrumb = By.xpath("//ol/li[last() and contains(text(), 'Human Capital')]");
    private By studentManagementCrumb = By.xpath("//ol/li[last() and contains(text(), 'Student Management')]");
    private By enterpriseResourcePlanningCrumb = By.xpath("//ol/li[last() and contains(text(), 'Enterprise Resource Planning')]");
    private By peopleExperienceSuiteCrumb = By.xpath("//ol/li[last() and contains(text(), 'The People Experience Suite')]");
    private By industriesHomeCrumb = By.xpath("//ol/li[last() and contains(text(), 'Industries')]");
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
    private By contactUsCrumb = By.xpath("//li[contains(text(), 'Contact Us')]"); // right breadcrumb
    private By locationCrumb = By.xpath("//li[contains(text(), 'Locations')]");
    private By currentBredCrumb = By.xpath("//ol/li[last()]");


    public BreadCrumbsBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isProductsHomeCrumbVisible() {
        waitForElement(productsHomeCrumb);
        Reporter.log("Checking breadcrumbs on 'Products Home' Page");
        return isElementPresent(productsHomeCrumb);
    }

    public boolean isIndustriesHomeCrumbVisible() {
        waitForElement(industriesHomeCrumb);
        Reporter.log("Checking breadcrumbs on 'Industries' Home Page");
        return isElementPresent(industriesHomeCrumb);
    }

    public boolean isProductsERPCrumbCrumbVisible() {
        waitForElement(enterpriseResourcePlanningCrumb);
        Reporter.log("Checking breadcrumbs on 'ERP' Page");
        return isElementPresentWithTimer(enterpriseResourcePlanningCrumb, 5);
    }

    public boolean isFinancialPlanningCrumbVisible() {
        waitForElement(financialPlanningCrumb);
        Reporter.log("Checking breadcrumbs on 'Financial Planning' Page");
        return isElementPresentWithTimer(financialPlanningCrumb, 5);
    }

    public boolean isFinancialsCrumbVisible() {
        waitForElement(financialsCrumb);
        Reporter.log("Checking breadcrumbs on 'Financials' Page");
        return isElementPresentWithTimer(financialsCrumb, 5);
    }

    public boolean isHumanCapitalManagementCrumbVisible() {
        waitForElement(humanCapitalManagementCrumb);
        Reporter.log("Checking breadcrumbs on 'Human Capital Management' Page");
        return isElementPresentWithTimer(humanCapitalManagementCrumb, 5);
    }

    public boolean isStudentManagementCrumbVisible() {
        waitForElement(studentManagementCrumb);
        Reporter.log("Checking breadcrumbs on 'Student Management' Page");
        return isElementPresent(studentManagementCrumb);
    }

    public boolean isPeopleExperienceSuiteCrumbVisible() {
        waitForElement(peopleExperienceSuiteCrumb);
        Reporter.log("Checking breadcrumbs on 'People experience suite' Page");
        return isElementPresent(peopleExperienceSuiteCrumb);
    }

    public boolean isHigherEducationCrumbVisible() {
        waitForElement(higherEducationCrumb);
        Reporter.log("Checking breadcrumbs on 'Higher education' Page");
        return isElementPresent(higherEducationCrumb);
    }

    public boolean isNonProfitCrumbVisible() {
        waitForElement(nonProfitCrumb);
        Reporter.log("Checking breadcrumbs on 'Nonprofit' Page");
        return isElementPresent(nonProfitCrumb);
    }

    public boolean isProfessionalServicesCrumbVisible() {
        waitForElement(professionalServicesCrumb);
        Reporter.log("Checking breadcrumbs on 'Professional Services' Page");
        return isElementPresent(professionalServicesCrumb);
    }

    public boolean isPublicSectorCrumbVisible() {
        waitForElement(publicSectorCrumb);
        Reporter.log("Checking breadcrumbs on 'Public Sector' Page");
        return isElementPresent(publicSectorCrumb);
    }

    //Customers
    public boolean isCustomersCrumbVisible() {
        waitForElement(customersCrumb);
        Reporter.log("Checking breadcrumbs on 'Customers Home' Page");
        return isElementPresentWithTimer(customersCrumb,5);
    }

    public boolean isCityOfPortCrumbVisible() {
        waitForElement(cityOfPortCrumb);
        Reporter.log("Checking breadcrumbs on 'City of Port' Page");
        return isElementPresentWithTimer(cityOfPortCrumb, 5);
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
        Reporter.log("Checking breadcrumbs on 'News' Home Page");
        return isElementPresent(newsHomePageCrumb);
    }

    public boolean isBlogHomePageCrumbVisible() {
        waitForElement(blogCrumb);
        Reporter.log("Checking breadcrumbs on 'Blog' Page");
        return isElementPresent(blogCrumb);
    }

    public boolean isEventsCrumbVisible() {
        waitForElement(eventsCrumb);
        Reporter.log("Checking breadcrumbs on 'Events' Page");
        return isElementPresent(eventsCrumb);
    }

    public boolean isLibraryCrumbVisible() {
        waitForElement(libraryCrumb);
        Reporter.log("Checking breadcrumbs on 'Library' Page");
        return isElementPresent(libraryCrumb);
    }

    public boolean isWhyUnit4CrumbVisible() {
        waitForElement(whyUnit4Crumb);
        Reporter.log("Checking breadcrumbs on 'Why Unit4' Page");
        return isElementPresent(whyUnit4Crumb);
    }

    public boolean isDeliver360CrumbVisible() {
        waitForElement(deliver360Crumb);
        Reporter.log("Checking breadcrumbs on 'Deliver 360' Page");
        return isElementPresent(deliver360Crumb);
    }

    public boolean isLocationsCrumbVisible() {
        waitForElement(locationCrumb);
        Reporter.log("Checking breadcrumbs on 'Locations' Page");
        return isElementPresent(locationCrumb);
    }

    public boolean isContactUsCrumbVisible() {
        waitForElementClickable(contactUsCrumb);
        Reporter.log("Checking breadcrumbs on 'Contact us' Page");
        return isElementPresent(contactUsCrumb);
    }

    public void goToHomeViaBreadCrumb() {
        waitForElementClickable(productsHomeCrumb);
        Reporter.log("Checking if it's possible open 'Home' Page via breadcrumbs");
        clickOnElement(productsHomeCrumb);
    }

    public void goToPeopleExperienceSuiteViaBreadCrumb() {
        waitForElementClickable(peopleExperienceSuiteCrumb);
        Reporter.log("Checking if it's possible open 'People Experience Suite' Page via breadcrumbs");
        clickOnElement(peopleExperienceSuiteCrumb);
    }

    public void goToHomePageViaBreadCrumb() {
        waitForElementClickable(homeCrumb);
        Reporter.log("Checking if it's possible open 'People Experience Suite' Page via breadcrumbs");
        clickOnElement(homeCrumb);
    }

    public String getCurrentBreadCrumb() {
        waitForElement(currentBredCrumb);
        Reporter.log("retrieving current breadcrumbs");
        return getElementText(currentBredCrumb);
    }

}
