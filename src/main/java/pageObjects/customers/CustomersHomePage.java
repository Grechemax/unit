package pageObjects.customers;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.products.EnterpriseResourcePlanningPage;

public class CustomersHomePage extends BasePage {
    CustomersHomePage customersHomePage;

    public CustomersHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private By customersMainTitle = By.xpath("//*contains[(text(), 'People-centric work solutions for people who serve people')]");

    private By cityOfPortTitle = By.xpath("//*[contains(text(), 'City of Port Coquitlam')]");
    private By austrianUniversityTitle = By.xpath("//*[contains(text(), 'FH St Pölten')]");
    private By manchesterUniversityTitle = By.xpath("//*[contains(text(), 'Manchester Metropolitan University')]");
    private By screwFixTitle = By.xpath("//*[contains(text(), 'Screwfix')]");
    private By stanleySecurityTitle = By.xpath("//*[contains(text(), 'Stanley Security)]");
    private By warChildTitle = By.xpath("//*[contains(text(), 'War)]");


    public void isCustomersMainTitlePresent() {
        isElementPresent(customersMainTitle);
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
