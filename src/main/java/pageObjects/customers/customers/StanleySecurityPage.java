package pageObjects.customers.customers;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StanleySecurityPage extends BasePage {
    private By stanleySecurityPageMainTitle = By.xpath("//h1[contains(text(), 'Streamlined process')]");
    private By downloadCaseStudyBtn = By.xpath("//a[contains(text(), 'Download')]");
    private By challengeTitle = By.xpath("//h2[contains(text(), 'Challenge')]");
    private By impactsTitle = By.xpath("//h2[contains(text(), 'Impacts')]");
    private By readMoreBtn = By.xpath("//a[contains(text(), 'Read more')]");
    private By erpBlockTitle = By.xpath("//h3[contains(text(), 'Enterprise Resource Planning')]");


    public StanleySecurityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isStanleySecurityPageMainTitlePresent() {
        waitForElement(stanleySecurityPageMainTitle);
        Reporter.log("Stanley Security Page' main title is present");
        return isElementPresent(stanleySecurityPageMainTitle);
    }

    public boolean isDownloadCaseStudyBtnPresented() {
        Reporter.log("Download case study' button is present");
        return isElementPresent(downloadCaseStudyBtn);
    }

    public boolean isChallengeTitlePresented() {
        Reporter.log("The Challenge' title is present");
        return isElementPresent(challengeTitle);
    }

    public boolean isImpactsTitlePresent() {
        Reporter.log("Impacts' title is present");
        return isElementPresent(impactsTitle);
    }

    public boolean isERPBlockTitlePresent() {
        Reporter.log("block with title 'Enterprise Resource Planning' is present");
        return isElementPresent(erpBlockTitle);
    }

    public void clickReadMoreButton() {
        waitForElement(readMoreBtn);
        clickOnElement(readMoreBtn);
        Reporter.log("ERP Page is opened after clicking 'Read More' button");
    }
}
