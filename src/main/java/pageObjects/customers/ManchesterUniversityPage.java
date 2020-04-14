package pageObjects.customers;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManchesterUniversityPage extends BasePage {
    private By manchesterMainTitle = By.xpath("//h1[contains(text(), 'Making education more personal')]");
    private By downloadCaseStudyBtn = By.xpath("//a[contains(text(), 'Download')]");
    private By challengeTitle = By.xpath("//h2[contains(text(), 'Challenge')]");
    private By impactsTitle = By.xpath("//h2[contains(text(), 'Impacts')]");
    private By unit4StudentManagementBlockTitle = By.xpath("//h3[contains(text(), 'Unit4 Student Management')]");
    private By readMoreBtn = By.xpath("//a[contains(text(), 'Read more')]");

    public ManchesterUniversityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public boolean isManchesterMainTitlePresent() {
        waitForElement(manchesterMainTitle);
        return isElementPresent(manchesterMainTitle);
    }

    public boolean isDownloadCaseStudyBtnPresented() {
        return isElementPresent(downloadCaseStudyBtn);
    }

    public boolean isChallengeTitlePresented() {
        return isElementPresent(challengeTitle);
    }

    public boolean isUnit4StudentManagementBlockTitlePresent() {
        return isElementPresent(unit4StudentManagementBlockTitle);
    }

    public boolean isImpactsTitlePresent() {
        return isElementPresent(impactsTitle);
    }

    public void clickReadMoreButton() {
        waitForElement(readMoreBtn);
        clickOnElement(readMoreBtn);
        Reporter.log("'Student Management' Page is opened");
    }
}
