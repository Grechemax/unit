package pageObjects;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WhyUnit4Page extends BasePage {
    private By whyUni4MainTitle = By.xpath("//h1[contains(text(), 'Why Unit4')]");
    private By readMoreWhatSoftware = By.xpath("//*[contains(text(), 'Explore what our software can do')]");
    private By readMoreSeeHowWeServe = By.xpath("//*[contains(text(), 'See how we serve your industry')]");
    private By downloadReportBtn = By.xpath("//a[contains(text(), 'Download report')]");
    private By downloadPDF1 = By.xpath("//div[contains(@class, 'swiper-container')]//div[contains(@role, 'article')][1]//*[contains(text(), 'Download the PDF')]");
    private By downloadPDF2 = By.xpath("//div[contains(@class, 'swiper-container')]//div[contains(@role, 'article')][2]//*[contains(text(), 'Download the PDF')]");
    private By downloadPDF3 = By.xpath("//div[contains(@class, 'swiper-container')]//div[contains(@role, 'article')][3]//*[contains(text(), 'Download the PDF')]");

    public WhyUnit4Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isWhyUni4MainTitlePresent() {
        Reporter.log("verify that 'Why Unit 4' main title is present");
        waitForElement(whyUni4MainTitle);
        return isElementPresent(whyUni4MainTitle);
    }

    public void clickReadMoreWhatSoftware() {
        clickOnElement(readMoreWhatSoftware);
    }

    public void clickReadSeeHowWeServe() {
        clickOnElement(readMoreSeeHowWeServe);
    }

    public void clickDownloadReport() {
        Reporter.log("clicking on 'Download Report' button");
        clickOnElement(downloadReportBtn);
    }

    public void clickDownloadPDF1() {
        Reporter.log("clicking on 'Download PDF' button in 'CPM Technology Value Matrix 2020' block");
        clickOnElement(downloadPDF1);
    }

    public void clickDownloadPDF2() {
        Reporter.log("clicking on 'Download PDF' button in 'Unit4 Pushes ERP Platform to the Next Level' block");
        clickOnElement(downloadPDF2);
    }

    public void clickDownloadPDF3() {
        Reporter.log("clicking on'Download PDF' in 'Hot Companies to Watch in 2020' block");
        clickOnElement(downloadPDF3);
    }
}
