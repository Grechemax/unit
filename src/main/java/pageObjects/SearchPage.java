package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class SearchPage extends BasePage {
    private By noResultsFound = By.xpath("//main//div[contains(@class, 'tile-group-container--search')]/div[contains(@class, 'view-filters')]");
    private By searchHeader = By.xpath("//h1[contains(text(), 'Search Unit4')]");
    private By resultsCount = By.xpath("//strong[contains(@class, 'section-search-results-count')]");
    private By resultsItem = By.xpath("//li[contains(@class, 'tile')]");
    private By resultsBlogItem = By.xpath("//div[contains(text(), 'Blog')]");
    private By resultsNewsItem = By.xpath("//div[contains(text(), 'News')]");

    private By showMoreButton = By.xpath("//*[contains(text(), 'Show more')]");
    private By aboutUnit4FooterSection = By.xpath("//h3[contains(text(), 'About Unit4')]");
    private By filterDropdown = By.xpath("//*[contains(text(), 'Filter by Product, Industry and Region')]");
    private By blogCheckbox = By.xpath("//input[@id='type-361']");
    private By newsCheckbox = By.xpath("//input[@id='type-451']");


    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkIfNoResultsFoundDisplayed() {
        isElementPresent(noResultsFound);
    }

    public String getSearchPageHeader() {
        waitForElement(searchHeader);
        return getElementText(searchHeader);
    }

    public void compareResultsCount() throws InterruptedException {

        while (isElementPresent(showMoreButton)){
            scrollToElement(aboutUnit4FooterSection);
            clickOnElementUsingJS(showMoreButton);
            Thread.sleep(1111);
        }

        List foundItemsList = findElements(resultsItem);
        int countFoundItems = foundItemsList.size();
        int countNumber = Integer.parseInt(findElement(resultsCount).getText());

        Assert.assertEquals(countNumber, countFoundItems);
    }

    public void clickFilterDropdown() {
        clickOnElement(filterDropdown);
    }

    public void selectBlogCheckbox() { ;
        clickOnElementUsingJS(blogCheckbox);
    }

    public void selectNewsCheckbox() {
        clickOnElementUsingJS(newsCheckbox);
    }

    public void checkIfOnlyNewsShown() {
        goSleep(2);
        Assert.assertTrue(isElementPresent(resultsNewsItem), "Only News results are visible");
        Assert.assertFalse(isElementPresent(resultsBlogItem));
    }

    public void checkIfOnlyBlogShown() {
       goSleep(2);
        Assert.assertTrue(isElementPresent(resultsBlogItem), "Only Blog results are visible");
        Assert.assertFalse(isElementPresent(resultsNewsItem));
    }

}
