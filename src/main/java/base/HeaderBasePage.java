package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HeaderBasePage extends BasePage {
    private By productsHeaderItem = By.xpath("//*[@id='sitenav']//a[contains(text(), 'Products')]");
    private By industriesHeaderItem = By.xpath("//*[@id='sitenav']//a[contains(text(), 'Industries')]");
    private By customersHeaderItem = By.xpath("//*[@id='sitenav']//a[contains(text(), 'Customers')]");
    private By resourcesHeaderItem = By.xpath("//*[@id='sitenav']//a[contains(text(), 'Resources')]");
    private By whyUnit4HeaderItem = By.xpath("//*[@id='sitenav']//a[contains(text(), 'Why Unit4')]");
    private By requestDemoCTA = By.xpath("//*[contains(@class, 'sitenav')]//*[contains(text(), 'Request a demo')]");

    private By enterpriseResourcePlanningDrpdwnItem = By.xpath("//li/a[contains(text(), 'Enterprise Resource Planning')]");
    private By financialPlanningDrpdwnItem = By.xpath("//a[contains(text(), 'Financial Planning & Analysis')]");
    private By humanCapitalManagementDrpdwnItem = By.xpath("//a[contains(text(), 'Human Capital Management')]");
    private By studentManagementDrpdwnItem = By.xpath("//a[contains(text(), 'Student Management')]");
    private By thePeopleExperienceSuiteDrpdwnItem = By.xpath("//ul//*[contains(text(), 'The People Experience Suite')]");
    private By viewAllProductsDrpdwnItem = By.xpath("//a[contains(text(), 'View all products')]");

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

    //header
    public void checkProductsItems() {
        hoverOverElement(productsHeaderItem);
        Assert.assertTrue(isElementPresent(enterpriseResourcePlanningDrpdwnItem));
        Assert.assertTrue(isElementPresent(financialPlanningDrpdwnItem));
        Assert.assertTrue(isElementPresent(humanCapitalManagementDrpdwnItem));
        Assert.assertTrue(isElementPresent(studentManagementDrpdwnItem));
    }

    //header
    public void checkResourcesItems() {
        hoverOverElement(resourcesHeaderItem);
        Assert.assertTrue(isElementPresent(blog));
        Assert.assertTrue(isElementPresent(events));
        Assert.assertTrue(isElementPresent(library));
        System.out.println(backgroundColorElement(findElement(blog))); // ????????????????????????????????????????
        System.out.println(backgroundColorElement(findElement(library)));  // ????????????????????????????????????????
    }

    //header
    public void checkIndustriesItems() {
        hoverOverElement(industriesHeaderItem);
        Assert.assertTrue(isElementPresent(higherEducation));
        Assert.assertTrue(isElementPresent(nonProfit));
        Assert.assertTrue(isElementPresent(professionalServices));
        Assert.assertTrue(isElementPresent(publicSector));
    }

    //Products
    public void goToEnterpriseResourcePlaning() {
        hoverOverElement(productsHeaderItem);
        clickOnElement(enterpriseResourcePlanningDrpdwnItem);
    }

    //Products
    public void goToFinancialPlaning() {
        hoverOverElement(productsHeaderItem);
        clickOnElement(financialPlanningDrpdwnItem);
    }

    //Products
    public void goToHumanCapitalManagement() {
        hoverOverElement(productsHeaderItem);
        clickOnElement(humanCapitalManagementDrpdwnItem);
    }

    //Products
    public void goToStudentManagement() {
        hoverOverElement(productsHeaderItem);
        clickOnElement(studentManagementDrpdwnItem);
    }

    //Products
    public void goToThePeopleExperienceSuite() {
        hoverOverElement(productsHeaderItem);
        clickOnElement(thePeopleExperienceSuiteDrpdwnItem);
    }


    //Industries
    public void goToHigherEducation() {
        hoverOverElement(industriesHeaderItem);
        clickOnElement(higherEducation);
    }

    //Industries
    public void goToNonProfit() {
        hoverOverElement(industriesHeaderItem);
        clickOnElement(nonProfit);
    }

    //Industries
    public void goToProfessionalServices() {
        hoverOverElement(industriesHeaderItem);
        clickOnElement(professionalServices);
    }

    //Industries
    public void goToPublicSector() {
        hoverOverElement(industriesHeaderItem);
        clickOnElement(publicSector);
    }

    //Industries
    public void goToIndustriesHome() {
        hoverOverElement(productsHeaderItem);
        clickOnElement(viewAllProductsDrpdwnItem);
    }


    public void goToCustomersHome() {
        clickOnElement(customersHeaderItem);
    }


    //Resources
    public void goToBlog() {
        hoverOverElement(resourcesHeaderItem);
        clickOnElement(blog);
    }

    //Resources
    public void goToEvents() {
        hoverOverElement(resourcesHeaderItem);
        clickOnElement(events);
    }

    //Resources
    public void goToLibrary() {
        hoverOverElement(resourcesHeaderItem);
        clickOnElement(library);
    }


    public void goToWhyUnit4() {
        clickOnElement(whyUnit4HeaderItem);
    }

    public void clickRequestDemoForm() {
        clickOnElement(requestDemoCTA);
    }
}
