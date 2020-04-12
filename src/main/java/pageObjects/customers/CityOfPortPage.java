package pageObjects.customers;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.products.EnterpriseResourcePlanningPage;

public class CityOfPortPage extends BasePage {
    EnterpriseResourcePlanningPage enterpriseResourcePlanningPage;

    public CityOfPortPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private By mainTitle = By.xpath("//section[1]/div/div/div[1]/h1");
    private By downloadCaseStudyBtn = By.xpath("//section[1]/div/div/div[1]/div[2]/p/a");
    private By readMoreBtn = By.xpath("//a[contains(text(), 'Read more')]");
    private By challengeTitle = By.xpath("//section[2]/div/div[1]/h2");
    private By erpTitle = By.xpath("//*[contains(text(), 'Enterprise Resource Planning')]");

    public void clickReadMoreButton() {
        waitForElement(readMoreBtn);
        clickOnElement(readMoreBtn);
        Reporter.log("ERP Page is opened");
    }



}
