package searchTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.Urls;
import org.apache.http.Header;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class SearchTest extends BaseTest {
    private SearchPage searchPage = new SearchPage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    String invalidQuerySearch = "!@#$%^&*()";
    String validQuerySearch = "experience";
    String toShortQuery = "ts";

    @Test
    public void specialCharactersSearch() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        headerBasePage.doSearch(invalidQuerySearch);
        searchPage.checkIfNoResultsFoundDisplayed();

        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
    }


    @Test
    public void tooShortQuery() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        headerBasePage.doSearch(toShortQuery);
        searchPage.checkIfNoResultsFoundDisplayed();

        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
    }


    @Test
    public void positiveSearch() throws InterruptedException {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        searchPage = new SearchPage(getDriver());
//        homePage.acceptCookies();
        headerBasePage.doSearch(validQuerySearch);
        searchPage.compareResultsCount();

        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
    }

}
