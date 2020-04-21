package pageObjects.customers.customers;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ScrewfixPage extends BasePage {
    private By screwfixPageMainTitle = By.xpath("//h1[contains(text(), 'Enabling growing retailer')]");
    private By downloadCaseStudyBtn = By.xpath("//a[contains(text(), 'Download')]");
    private By challengeTitle = By.xpath("//h2[contains(text(), 'Challenge')]");
    private By impactsTitle = By.xpath("//h2[contains(text(), 'Impacts')]");
    private By readMoreBtn = By.xpath("//a[contains(text(), 'Read more')]");
    private By unit4FinancialsBlockTitle = By.xpath("//h3[contains(text(), 'Unit4 Financials')]");


    public ScrewfixPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isScrewfixPageMainTitlePresent() {
        Reporter.log("Verify is screw fix page title present");
        waitForElement(screwfixPageMainTitle);
        return isElementPresent(screwfixPageMainTitle);
    }

    public boolean isDownloadCaseStudyBtnPresented() {
        Reporter.log("Verify is download case study button present");
        return isElementPresent(downloadCaseStudyBtn);
    }

    public boolean isChallengeTitlePresented() {
        Reporter.log("Verify is challenge title present");
        return isElementPresent(challengeTitle);
    }

    public boolean isImpactsTitlePresent() {
        Reporter.log("Verify is impacts title present");
        return isElementPresent(impactsTitle);
    }

    public boolean isUnit4FinancialsBlockTitlePresent() {

        Reporter.log("Verify is unit4 financials block title present");
        return isElementPresent(unit4FinancialsBlockTitle);
    }

    public void clickReadMoreButton() {
        waitForElement(readMoreBtn);
        clickOnElement(readMoreBtn);
        Reporter.log("'Financials' Page is opened");
    }

    public void clickDownloadCaseStudy() {
        Reporter.log("clicking 'Download case study' button");
        clickOnElement(downloadCaseStudyBtn);
    }
}
