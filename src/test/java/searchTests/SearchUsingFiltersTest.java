package searchTests;

import base.BasePage;
import base.BaseTest;
import data.Urls;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class SearchUsingFiltersTest extends BaseTest {

    HomePage homePage;
    SearchPage searchPage;

    @Test
    public void searchBlogOnly() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage = new HomePage(getDriver());
        searchPage = new SearchPage(getDriver());
        String validQuerySearch = "skills";
        homePage.doSearch(validQuerySearch);
        searchPage.clickFilterDropdown();
        searchPage.selectBlogCheckbox();
        searchPage.clickFilterDropdown();
        searchPage.checkIfOnlyBlogShown();
    }


    @Test
    public void searchNewsOnly() {
        BasePage.openURL(Urls.HOME_PAGE.URL());
        homePage = new HomePage(getDriver());
        searchPage = new SearchPage(getDriver());
        String validQuerySearch = "news";
        homePage.doSearch(validQuerySearch);
        searchPage.clickFilterDropdown();
        searchPage.selectNewsCheckbox();
        searchPage.checkIfOnlyNewsShown();
    }
}
