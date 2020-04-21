package searchTests;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
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
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
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
        Assert.assertTrue(searchPage.areResultsCountAndFoundResultEqual(), "'x'results found doesn't match 'y' found items");
    }

    @Test
    public void positiveTwoWordSearch() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(doubleValidQuerySearch);
        headerBasePage.submitSearchViaSearchIcon();
        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
        Assert.assertTrue(searchPage.areResultsCountAndFoundResultEqual(), "'x'results found doesn't match 'y' found items");
    }

    @Test
    public void digitCharactersSearch() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(digitQuerySearch);
        headerBasePage.submitSearchViaReturn();
        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
        Assert.assertTrue(searchPage.areResultsCountAndFoundResultEqual(), "'x'results found doesn't match 'y' found items");
    }

    @Test
    public void collapseSearchInput() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(doubleValidQuerySearch);
        headerBasePage.collapseSearchInput();
        Assert.assertTrue(headerBasePage.isMagnifierIconToSubmitPresent());
    }


    // todo iterate through all pages
    @Test
    public void openPageFromSearchResult() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(doubleValidQuerySearch);
        headerBasePage.submitSearchViaSearchIcon();
        searchPage.isSearchPageMainHeaderPresent();
        String searchItemHeader = searchPage.getItemsHeaderFromSearchResults();
        searchPage.openItemFromSearchResults();
        String openedPageBredCrumb = breadCrumbsBasePage.getCurrentBreadCrumb();
        Assert.assertEquals(searchItemHeader, openedPageBredCrumb);
    }
}
