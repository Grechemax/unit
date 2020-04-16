package searchTests;

import base.BasePage;
import base.BaseTest;
import base.HeaderBasePage;
import data.Urls;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class SearchUsingFiltersTest extends BaseTest {

    HeaderBasePage headerBasePage;
    SearchPage searchPage;

    @Test
    public void searchBlogOnly() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        headerBasePage = new HeaderBasePage(getDriver());
        searchPage = new SearchPage(getDriver());
        String validQuerySearch = "skills";
        headerBasePage.doSearch(validQuerySearch);
        searchPage.clickFilterDropdown();
        searchPage.selectBlogCheckbox();
        searchPage.clickFilterDropdown();
        searchPage.checkIfOnlyBlogShown();
    }


    @Test
    public void searchNewsOnly() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        headerBasePage = new HeaderBasePage(getDriver());
        searchPage = new SearchPage(getDriver());
        String validQuerySearch = "news";
        headerBasePage.doSearch(validQuerySearch);
        searchPage.clickFilterDropdown();
        searchPage.selectNewsCheckbox();
        searchPage.checkIfOnlyNewsShown();
    }
}
