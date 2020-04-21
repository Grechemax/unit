package base;

import org.openqa.selenium.By;

public class SearchFilterBasePage extends BasePage {
    public By aboutUnit4FooterSection = By.xpath("//h3[contains(text(), 'About Unit4')]");
    public By filterDropdown = By.xpath("//*[contains(text(), 'Filter by ')]");

    //Type
    public By blogCheckbox = By.xpath("//form//*[contains(text(), 'Blog')]");
    public By newsCheckbox = By.xpath("//form//*[contains(text(), 'News')]");
    public By researchReportCheckbox = By.xpath("//form//*[contains(text(), 'Research Report')]");
    public By eventCheckbox = By.xpath("//form//*[contains(text(), 'Event')]");
    public By productCheckbox = By.xpath("//form//*[contains(text(), 'Product')]");
    // Types in found items
    private By resultsBlogItem = By.xpath("//div[contains(@class, 'views-infinite-scroll-content-wrapper')]//div[contains(text(), 'Blog')]");
    private By resultsNewsItem = By.xpath("//div[contains(@class, 'views-infinite-scroll-content-wrapper')]//div[contains(text(), 'News')]");
    private By resultsNonprofit = By.xpath("//div[contains(@class, 'tile-tags  small')]//*[contains(text(), 'Nonprofit')]");
    private By resultsPublicSector = By.xpath("//div[contains(@class, 'tile-tags  small')]//*[contains(text(), 'Public Sector')]");

    //Industry
    public By publicSectorCheckbox = By.xpath("//form//*[contains(text(), 'Public Sector')]");
    public By nonprofitCheckbox = By.xpath("//form//*[contains(text(), 'Nonprofit')]");
    public By accountancyCheckbox = By.xpath("//form//*[contains(text(), 'Accountancy')]");
    public By itServicesCheckbox = By.xpath("//form//*[contains(text(), 'IT Services')]");
    public By higherEducationCheckbox = By.xpath("//form//*[contains(text(), 'Higher Education')]");
    public By professionalServicesCheckbox = By.xpath("//form//*[contains(text(), 'Professional Services')]");

    //Region
    public By globalCheckbox = By.xpath("//input[@id='region-341']");
    public By swedenCheckbox = By.xpath("//input[@id='type-451']");
    public By northAmericaCheckbox = By.xpath("//input[@id='type-451']");
    public By latinAmericaCheckbox = By.xpath("//input[@id='type-451']");
    public By europeCheckbox = By.xpath("//input[@id='type-451']");
    public By africaCheckbox = By.xpath("//input[@id='type-451']");



    public void selectNewsCheckbox() {
        Reporter.log("select 'News' checkbox");
        clickOnElementUsingJS(newsCheckbox);
    }

    public void selectBlogCheckbox() {
        Reporter.log("select 'BLog' checkbox");
        clickOnElementUsingJS(blogCheckbox);
    }

    public void selectResearchReportCheckbox() {
        Reporter.log("select 'Research Report' checkbox");
        clickOnElementUsingJS(researchReportCheckbox);
    }

    public void selectEventCheckbox() {
        Reporter.log("select 'Event' checkbox");
        clickOnElementUsingJS(eventCheckbox);
    }

    public void selectProductCheckbox() {
        Reporter.log("select 'Product' checkbox");
        clickOnElementUsingJS(productCheckbox);
    }

    public void clickFilterDropdown() {
        Reporter.log("click on filter dropdown");
        clickOnElementUsingJS(filterDropdown);
    }

    //Industry
    public void clickPublicSectorCheckbox() {
        Reporter.log("select 'Public Sector' checkbox");
        waitForElement(publicSectorCheckbox);
        clickOnElement(publicSectorCheckbox);
    }

    public void clickAccountancyCheckbox() {
        Reporter.log("select 'Accountancy' checkbox");
        clickOnElement(accountancyCheckbox);
    }

    public void clickItServicesCheckbox() {
        Reporter.log("select 'It Services' checkbox");
        clickOnElement(itServicesCheckbox);
    }

    public void clickNonprofitCheckbox() {
        Reporter.log("select 'Nonprofit' checkbox");
        waitForElement(nonprofitCheckbox);
        clickOnElementUsingJS(nonprofitCheckbox);
    }

    public void clickHigherEducationCheckbox() {
        Reporter.log("select 'Higher Education' checkbox");
        clickOnElement(higherEducationCheckbox);
    }

    public void clickProfessionalServicesCheckbox() {
        Reporter.log("select 'Professional Services Checkbox' checkbox");
        clickOnElement(professionalServicesCheckbox);
    }

    public boolean newsResultsShown() {
        sleepTightInMiliSeconds(2222);
        return isElementPresent(resultsNewsItem);
    }

    public boolean blogResultsShown() {
        sleepTightInMiliSeconds(2222);
        return isElementPresent(resultsBlogItem);
    }

    public boolean nonprofitResultsShown() {
        sleepTightInMiliSeconds(2222);
        return isElementPresent(resultsNonprofit);
    }

    public boolean publicSectorResultsShown() {
        sleepTightInMiliSeconds(2222);
        return isElementPresent(resultsPublicSector);
    }
}
