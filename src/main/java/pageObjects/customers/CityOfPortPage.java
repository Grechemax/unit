package pageObjects.customers;

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
        waitForElement(cityOfPortMainTitle);
        return isElementPresent(cityOfPortMainTitle);
    }

    public boolean isDownloadCaseStudyBtnPresented() {
        return isElementPresent(downloadCaseStudyBtn);
    }

    public boolean isChallengeTitlePresented() {
        return isElementPresent(challengeTitle);
    }

    public boolean isImpactsTitlePresent() {
        return isElementPresent(impactsTitle);
    }

    public boolean isERPTitlePresent() {
        return isElementPresent(erpBlockTitle);
    }

    public void clickReadMoreButton() {
        waitForElement(readMoreBtn);
        clickOnElement(readMoreBtn);
        Reporter.log("ERP Page is opened");
    }
}
