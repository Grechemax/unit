package pageObjects.customers.customers;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FHstPoltenPage extends BasePage {
    private By fhPoltenMainTitle = By.xpath("//h1[contains(text(), 'Smarter HR')]");
    private By downloadCaseStudyBtn = By.xpath("//a[contains(text(), 'Download')]");
    private By challengeTitle = By.xpath("//h2[contains(text(), 'Challenge')]");
    private By impactsTitle = By.xpath("//*[contains(text(), 'Impacts')]");
    private By financialPlanningBlockTitle = By.xpath("//*[contains(text(), 'Financial Planning')]");
    private By financialPlanningReadMore = By.xpath("//section[2]//a[contains(text(), 'Read more')]");

    public FHstPoltenPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public boolean isFHPoltenMainTitlePresent() {
        Reporter.log("' Customer Overview: FH St Pölten' page main title is present");
        waitForElement(fhPoltenMainTitle);
        return isElementPresent(fhPoltenMainTitle);
    }

    public boolean isDownloadCaseStudyBtnPresented() {
        Reporter.log("Download case study' button is present");
        return isElementPresent(downloadCaseStudyBtn);
    }

    public boolean isChallengeTitlePresented() {
        Reporter.log("Verify is challenge title present");
        return isElementPresent(challengeTitle);
    }

    public boolean isFinancialPlanningBlockTitlePresent() {
        Reporter.log("Verify is planning block present");
        return isElementPresent(financialPlanningBlockTitle);
    }

    public boolean isImpactsTitlePresent() {
        return isElementPresent(impactsTitle);
    }

    public void clickReadMoreAboutFinancialPlanning() {
        waitForElement(financialPlanningReadMore);
        clickOnElement(financialPlanningReadMore);
        Reporter.log("clicking 'Read more' in 'Unit4 Financial Planning & Analysis' section");
    }

    public void clickDownloadCaseStudy() {
        Reporter.log("clicking 'Download case study' button");
        clickOnElement(downloadCaseStudyBtn);
    }
}
