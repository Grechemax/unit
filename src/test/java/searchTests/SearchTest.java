package searchTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class SearchTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private SearchPage searchPage = new SearchPage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    String doubleValidQuerySearch = "people experience";
    String invalidQuerySearch = "!@#$%^&*()";
    String validQuerySearch = "experience";
    String digitQuerySearch = "2020";
    String toShortQuery = "ts";

    @Test
    public void specialCharactersSearch() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(invalidQuerySearch);
        headerBasePage.submitSearchViaReturn();
        Assert.assertTrue(searchPage.isNoResultsFoundPresent());
        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
    }


    @Test
    public void tooShortQuery() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(toShortQuery);
        headerBasePage.submitSearchViaReturn();
        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
        Assert.assertTrue(searchPage.isNoResultsFoundPresent());
    }

    @Test
    public void positiveOneWordSearch() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(validQuerySearch);
        headerBasePage.submitSearchViaReturn();
        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
        Assert.assertTrue(searchPage.isResultsCountAndFoundResultEqual());
    }

    @Test
    public void positiveTwoWordSearch() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(doubleValidQuerySearch);
        headerBasePage.submitSearchViaSearchIcon();
        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
        Assert.assertTrue(searchPage.isResultsCountAndFoundResultEqual());
    }

    @Test
    public void digitCharactersSearch() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(digitQuerySearch);
        headerBasePage.submitSearchViaReturn();
        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
        Assert.assertTrue(searchPage.isResultsCountAndFoundResultEqual(), "'x'results found doesn't match 'y' found items");
    }

    @Test
    public void collapseSearchInput() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(doubleValidQuerySearch);
        headerBasePage.collapseSearchInput();
        Assert.assertTrue(headerBasePage.isMagnifierIconToSubmitPresent());
    }

    // todo Verify that User can open the pages from the search results
    @Test
    public void openPageFromSearchResult() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(doubleValidQuerySearch);
        headerBasePage.submitSearchViaSearchIcon();
        searchPage.isSearchPageMainHeaderPresent();
        searchPage.openItemFromSearchResults();
    }
}
