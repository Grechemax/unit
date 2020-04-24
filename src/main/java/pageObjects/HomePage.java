package pageObjects;

import base.BasePage;

import base.BreadCrumbsBasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePage extends BasePage {
    BreadCrumbsBasePage breadCrumbsBasePage;
    private By siteLogo = By.xpath("//a[contains(@class, 'site-logo')]");
    private By whyUnit4Button = By.xpath("//p/a[contains(text(), 'Why Unit4')]");
    private By seeAllNews = By.xpath("//a[contains(text(), 'See all news')]");
    private By mainUpperHeader = By.xpath("//h1[contains(@class, 'section-title h1')]");
    private By erpReadMore = By.xpath("//section[2]//*[contains(text(), 'Read more')]");
    private By readMoreWarChild = By.xpath("//section[8]//a[contains(text(), 'Read more')]");
    private By centerHeader = By.xpath("//h2[contains(@class, 'section-title text-center')]");
    private By humanCapitalReadMore = By.xpath("//section[4]//*[contains(text(), 'Read more')]");
    private By studentManagementReadMore = By.xpath("//section[5]//*[contains(text(), 'Read more')]");
    private By financialPlanningReadMore = By.xpath("//section[3]//*[contains(text(), 'Read more')]");
    private By readMoreCustomersStories = By.xpath("//a[contains(text(), 'Read our customer stories')]");
    private By downloadReportBtn = By.xpath("//a[contains(text(), 'Download report')]");

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public boolean isMainLogoPresent() {
        Reporter.log("site logo is present");
        return isElementPresent(siteLogo);
    }

    public boolean isMainHeaderPresent() {
        waitForElement(mainUpperHeader);
        Reporter.log("Main header is present");
        return isElementPresent(mainUpperHeader);
    }

    public String getMainUpperHeaderText() {
        Reporter.log("getting Main HeaderText");
        return getElementText(mainUpperHeader);
    }

    public String getCenterHeaderText() {
        return getElementText(centerHeader);
    }


    public void clickReadMoreAboutERP() {
        Reporter.log("clicking read more about 'Enterprise Resource Planning'");
        clickOnElement(erpReadMore);
    }

    public void clickReadMoreAboutFinancialPlanning() {
        Reporter.log("clicking read more about 'Financial Planning'");
        clickOnElement(financialPlanningReadMore);
    }

    public void clickReadMoreAboutHumanCapital() {
        Reporter.log("clicking read more about 'Human Capital'");
        clickOnElement(humanCapitalReadMore);
    }

    public void clickReadMoreAboutStudentManagement() {
        Reporter.log("clicking read more about 'Students Management'");
        clickOnElement(studentManagementReadMore);
    }

    public void clickReadCustomersStories() {
        Reporter.log("clicking 'See more customer success stories in 'Trusted by public sector organizations worldwide' section");
        clickOnElement(readMoreCustomersStories);
    }

    public void clickReadMoreAboutWarChild() {
        Reporter.log("clicking read more in 'Customer Overview: War Child' block");
        clickOnElement(readMoreWarChild);
    }

    public void clickWhyUnit4Button() {
        Reporter.log("clicking 'Why Unit4' button");
        clickOnElement(whyUnit4Button);
    }

    public void clickSeeAllNews() {
        Reporter.log("clicking 'See all news'");
        clickOnElement(seeAllNews);
    }


    public void clickDownloadReport() {
        Reporter.log("clicking on 'Download Report' button");
        clickOnElement(downloadReportBtn);
    }

    public void compareNewsArticleNamesWithPages() {
        String newsElement = "//div[contains(@class, 'swiper-container')]/ul/li[%s]//h3/span";
        for (int i = 1; i <= 3; i++) {
            breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
            By item = By.xpath(String.format(newsElement, i));
            Reporter.log("Comparing name of News Block #" + i + " with title of opened page");
            String postTitle = getElementText(item);
            System.out.println(postTitle);
            clickOnElement(item);
            // old breadcrumb
            String currentBreadCrumb = breadCrumbsBasePage.getCurrentBreadCrumb();
            Assert.assertEquals(postTitle, currentBreadCrumb);
            getDriver().navigate().back();
//            Assert.assertTrue(isMainHeaderPresent());
        }
    }
}
