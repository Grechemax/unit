package pageObjects.customers.customers;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CityOfPortPage extends BasePage {

    private By cityOfPortMainTitle = By.xpath("//h1[contains(text(), 'Cost savings')]");
    private By challengeTitle = By.xpath("//h2[contains(text(), 'Challenge')]");
    private By downloadCaseStudyBtn = By.xpath("//a[contains(text(), 'Download')]");
    private By readMoreBtn = By.xpath("//a[contains(text(), 'Read more')]");
    private By erpBlockTitle = By.xpath("//*[contains(text(), 'Enterprise Resource Planning')]");
    private By impactsTitle = By.xpath("//*[contains(text(), 'Impacts')]");

    public CityOfPortPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isCityOfPortMainTitlePresent() {
        Reporter.log("verify that 'City Of Port' title is present");
        waitForElement(cityOfPortMainTitle);
        return isElementPresent(cityOfPortMainTitle);
    }

    public boolean isDownloadCaseStudyBtnPresented() {
        Reporter.log("verify that 'Download Case Study' button is present");
        return isElementPresent(downloadCaseStudyBtn);
    }

    public boolean isChallengeTitlePresented() {
        Reporter.log("verify that 'Challenge' title is present");
        return isElementPresent(challengeTitle);
    }

    public boolean isImpactsTitlePresent() {
        Reporter.log("verify that 'Impacts' title is present");
        return isElementPresent(impactsTitle);
    }

    public boolean isERPTitlePresent() {
        Reporter.log("verify that 'Enter Enterprise Planning' title is present");
        return isElementPresent(erpBlockTitle);
    }

    public void clickReadMoreButton() {
        Reporter.log("ERP Page is opened after clicking 'Read More' button");
        waitForElement(readMoreBtn);
        clickOnElement(readMoreBtn);
    }

    public void clickDownloadCaseStudy() {
        Reporter.log("clicking 'Download case study' button");
        clickOnElement(downloadCaseStudyBtn);
    }
}
