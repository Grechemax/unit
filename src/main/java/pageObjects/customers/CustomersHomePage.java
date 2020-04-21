package pageObjects.customers;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.products.EnterpriseResourcePlanningPage;

public class CustomersHomePage extends BasePage {
    CustomersHomePage customersHomePage;

    public CustomersHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private By customersMainTitle = By.xpath("//*[contains(text(), 'People-centric work solutions')]");

    private By cityOfPortTitle = By.xpath("//*[contains(text(), 'City of Port Coquitlam')]");
    private By austrianUniversityTitle = By.xpath("//*[contains(text(), 'FH St Pölten')]");
    private By manchesterUniversityTitle = By.xpath("//*[contains(text(), 'Manchester Metropolitan University')]");
    private By screwFixTitle = By.xpath("//*[contains(text(), 'Screwfix')]");
    private By stanleySecurityTitle = By.xpath("//*[contains(text(), 'Stanley Security')]");
    private By warChildTitle = By.xpath("//*[contains(text(), 'War Child')]");


    public boolean isCustomersMainTitlePresent() {
        waitForElement(customersMainTitle);
        return isElementPresent(customersMainTitle);
    }

    public boolean isCityOfPortTitlePresent()
    {
        Reporter.log("Verify is city of port title present");
        return isElementPresent(cityOfPortTitle);
    }

    public boolean isAustrianUniversityTitlePresent() {

        Reporter.log("Verify is Australian University title present");
        return isElementPresent(austrianUniversityTitle);
    }

    public boolean isManchesterUniversityTitlePresent() {
        Reporter.log("Verify is Manchester University title present");
        return isElementPresent(manchesterUniversityTitle);
    }

    public boolean isScrewFixTitlePresent() {

        Reporter.log("Verify is screw fix title present");
        return isElementPresent(screwFixTitle);
    }

    public boolean isStanleySecurityTitlePresent(){
        Reporter.log("Verify is stanley security title present");
        return isElementPresent(stanleySecurityTitle);
    }

    public boolean isWarChildTitlePresent() {
        Reporter.log("Verify is war child title present");

        return isElementPresent(warChildTitle);
    }

    public void goToCityOfPortBlock() {
        clickOnElement(cityOfPortTitle);
    }

    public void goToAustrianUniversityBlock() {
        clickOnElement(austrianUniversityTitle);
    }

    public void goToManchesterUniversityBLock() {
        clickOnElement(manchesterUniversityTitle);
    }

    public void goToScrewFixBLock() {
        clickOnElement(screwFixTitle);
    }

    public void goToStanleySecurityBLock() {
        clickOnElement(stanleySecurityTitle);
    }

    public void goToWarChildBLock() {
        clickOnElement(warChildTitle);
    }
}
