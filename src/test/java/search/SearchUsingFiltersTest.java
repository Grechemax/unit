package search;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class SearchUsingFiltersTest extends BaseTest {

    HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    SearchPage searchPage = new SearchPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    String validQuerySearch = "news";

    @Test
    public void searchBlogOnly() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(validQuerySearch);
        headerBasePage.submitSearchViaReturn();
        Assert.assertTrue(searchPage.isSearchPageMainHeaderPresent());
        searchPage.clickFilterDropdown();
        searchPage.selectBlogCheckbox();
        searchPage.clickFilterDropdown();
        Assert.assertTrue(searchPage.blogResultsShown());
        Assert.assertFalse(searchPage.newsResultsShown());
    }

    @Test
    public void searchNewsOnly() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        homePage.acceptCookies();
        headerBasePage.inputDataToSearchInput(validQuerySearch);
        headerBasePage.submitSearchViaReturn();
        Assert.assertTrue(searchPage.isSearchPageMainHeaderPresent());
        searchPage.clickFilterDropdown();
        searchPage.selectNewsCheckbox();
        searchPage.clickFilterDropdown();
        Assert.assertTrue(searchPage.newsResultsShown());
        Assert.assertFalse(searchPage.blogResultsShown());
    }
}
