package searchTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SearchPage;

public class SearchUsingFiltersTest extends BaseTest {

    HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    SearchPage searchPage = new SearchPage(getDriver());

    @Test
    public void searchBlogOnly() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        String validQuerySearch = "skills";
        headerBasePage.inputDataToSearchInput(validQuerySearch);
        headerBasePage.submitSearchViaReturn();
        Assert.assertTrue(searchPage.isSearchPageMainHeaderPresent());
        searchPage.clickFilterDropdown();
        searchPage.selectBlogCheckbox();
        searchPage.clickFilterDropdown();
        searchPage.checkIfOnlyBlogShown();
    }

    @Test
    public void searchNewsOnly() {
        BasePage.openURL(URLs.HOME_PAGE.URL());
        String validQuerySearch = "news";
        headerBasePage.inputDataToSearchInput(validQuerySearch);
        headerBasePage.submitSearchViaSearchIcon();
        Assert.assertTrue(searchPage.isSearchPageMainHeaderPresent());
        searchPage.clickFilterDropdown();
        searchPage.selectNewsCheckbox();
        searchPage.checkIfOnlyNewsShown();
    }
}
