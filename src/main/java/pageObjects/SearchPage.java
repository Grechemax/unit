package pageObjects;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class SearchPage extends BasePage {
    private By noResultsFound = By.xpath("//div[contains(@class, 'tile-group-container--search')]/div[contains(@class, 'view-filters')]");
    private By searchPageMainHeader = By.xpath("//h1[contains(text(), 'Search Unit4')]");
    private By resultsCount = By.xpath("//strong[contains(@class, 'section-search-results-count')]");
    private By resultsItem = By.xpath("//li[contains(@class, 'tile')]");
    private By firstResultsItem = By.xpath("//li[contains(@class, 'tile')]//span[1]");
    private By resultsBlogItem = By.xpath("//div[contains(text(), 'Blog')]");
    private By resultsNewsItem = By.xpath("//div[contains(text(), 'News')]");


//    private By aboutUnit4FooterSection = By.xpath("//h3[contains(text(), 'About Unit4')]");
    private By filterDropdown = By.xpath("//*[contains(text(), 'Filter by Product, Industry and Region')]");
    private By blogCheckbox = By.xpath("//input[@id='type-361']");
    private By newsCheckbox = By.xpath("//input[@id='type-451']");


    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isNoResultsFoundPresent() {
        waitForElement(noResultsFound);
        return isElementPresent(noResultsFound);
    }

    public String getSearchPageHeader() {
        waitForElement(searchPageMainHeader);
        return getElementText(searchPageMainHeader);
    }

    public boolean isSearchPageMainHeaderPresent() {
        return isElementPresentWithTimer(searchPageMainHeader, 10);
    }


    public boolean areResultsCountAndFoundResultEqual() {
        clickShowMoreUntilVisible();
        List foundItemsList = findElements(resultsItem);
        int countFoundItems = foundItemsList.size();
        int countNumber = Integer.parseInt(findElement(resultsCount).getText());
        System.out.println("countNumber" + countNumber);
        System.out.println("found" + countFoundItems);
        return countFoundItems == countNumber;
    }

    public void clickFilterDropdown() {
        clickOnElement(filterDropdown);
    }

    public void selectBlogCheckbox() {
        ;
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
        waitForElement(resultsBlogItem);
        Assert.assertTrue(isElementPresent(resultsBlogItem), "Only Blog results are visible");
        Assert.assertFalse(isElementPresent(resultsNewsItem));
    }

    public void openItemFromSearchResults() {
        waitForElement(firstResultsItem);
        clickOnElement(firstResultsItem);
        Reporter.log("opening page from search result");
    }

    public String getItemsHeaderFromSearchResults() {
        Reporter.log("getting item's header from search result");
        return getElementText(firstResultsItem);
    }
}
