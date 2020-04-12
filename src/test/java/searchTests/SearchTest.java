package searchTests;

import base.BasePage;
import base.BaseTest;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class SearchTest extends BaseTest {
    private HomePage homePage;
    private SearchPage searchPage;

    @Test
    public void specialCharactersSearch() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage = new HomePage(getDriver());
        searchPage = new SearchPage(getDriver());
        String invalidQuerySearch = "!@#$%^&*()";
        homePage.doSearch(invalidQuerySearch);
        searchPage.checkIfNoResultsFoundDisplayed();

        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
    }


    @Test
    public void tooShortQuery() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage = new HomePage(getDriver());
        searchPage = new SearchPage(getDriver());
        String toShortQuery = "ts";
        homePage.doSearch(toShortQuery);
        searchPage.checkIfNoResultsFoundDisplayed();

        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
    }


    @Test
    public void positiveSearch() throws InterruptedException {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage = new HomePage(getDriver());
        searchPage = new SearchPage(getDriver());
        homePage.acceptCookies();
        String validQuerySearch = "experience";
        homePage.doSearch(validQuerySearch);
        searchPage.compareResultsCount();

        Assert.assertEquals(searchPage.getSearchPageHeader(), "Search Unit4");
    }

}
