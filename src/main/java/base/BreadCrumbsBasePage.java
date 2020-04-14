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
    private By productsERPCrumb = By.xpath("//ol/li[last() and contains(text(), 'Enterprise Resource Planning')]");
    private By peopleExperienceSuiteCrumb = By.xpath("//ol/li[last() and contains(text(), 'The People Experience Suite')]");

    private By industriesCrumb = By.xpath("//ol/li[last() and contains(text(), 'Industries')]");
    private By higherEducationCrumb = By.xpath("//ol/li[last() and contains(text(), 'Higher Education')]");
    private By nonProfitCrumb = By.xpath("//ol/li[last() and contains(text(), 'Nonprofit')]");
    private By professionalServicesCrumb = By.xpath("//ol/li[last() and contains(text(), 'Professional Services')]");
    private By publicSectorCrumb = By.xpath("//ol/li[last() and contains(text(), 'Public Sector')]");

    private By customersCrumb = By.xpath("//ol/li[last() and contains(text(), 'Customers')]");

    private By blogCrumb = By.xpath("//ol/li[last() and contains(text(), 'Blog')]");
    private By eventsCrumb = By.xpath("//ol/li[last() and contains(text(), 'Events')]");
    private By libraryCrumb = By.xpath("//ol/li[last() and contains(text(), 'Library')]");

    private By whyUnit4Crumb = By.xpath("//ol/li[last() and contains(text(), 'Why Unit4')]");

    private By deliver360Crumb = By.xpath("//ol/li[last() and contains(text(), 'Deliver a 360')]");


    public BreadCrumbsBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isProductCrumbVisible() {
        waitForElement(productsCrumb);
        return isElementPresent(productsCrumb);
    }

    public boolean isProductsERPCrumbCrumbVisible() {
        waitForElement(productsERPCrumb);
        return isElementPresent(productsERPCrumb);
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

    public boolean isCustomersCrumbVisible() {
        waitForElement(customersCrumb);
        return isElementPresent(customersCrumb);
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
}
