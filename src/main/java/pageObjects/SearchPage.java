package pageObjects;


import base.Reporter;
import base.SearchFilterBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import java.util.List;


public class SearchPage extends SearchFilterBasePage {
    private By noResultsFound = By.xpath("//div[contains(@class, 'tile-group-container--search')]/div[contains(@class, 'view-filters')]");
    private By searchPageMainHeader = By.xpath("//h1[contains(text(), 'Search Unit4')]");
    private By resultsCount = By.xpath("//strong[contains(@class, 'section-search-results-count')]");
    private By resultsItem = By.xpath("//li[contains(@class, 'tile')]");
    private By firstResultsItem = By.xpath("//li[contains(@class, 'tile')]//span[1]");


    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isNoResultsFoundPresent() {
        Reporter.log("'No results' message is shown");
        waitForElement(noResultsFound);
        return isElementPresent(noResultsFound);
    }

    public String getSearchPageHeader() {
        waitForElement(searchPageMainHeader);
        return getElementText(searchPageMainHeader);
    }

    public boolean isSearchPageMainHeaderPresent() {
        Reporter.log("'Search Page' main header is present");
        waitForElement(searchPageMainHeader);
        return isElementPresentWithTimer(searchPageMainHeader, 10);
    }


    public boolean areResultsCountAndFoundResultEqual() {
        Reporter.log("'comparing results");
        clickShowMoreUntilVisible();
        List foundItemsList = findElements(resultsItem);
        int countFoundItems = foundItemsList.size();
        int countNumber = Integer.parseInt(findElement(resultsCount).getText());
        System.out.println("countNumber :" + countNumber);
        System.out.println("found :" + countFoundItems);
        return countFoundItems == countNumber;
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
