package products;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.cookies.CookiesHomePage;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.products.ProductsHomePage;


public class ProductsHomePageTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    ProductsHomePage productsHomePage = new ProductsHomePage(getDriver());
    CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());


    @Test
    public void checkProductsHomeTitles() {
        BasePage.openURL(URLs.PRODUCTS.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(productsHomePage.isProductsHomePageMainTitlePresent());
        Assert.assertTrue(productsHomePage.isProductsHomePageIntroPresent());
    }

    @Test
    public void checkProductsHomeCrumbs() {
        BasePage.openURL(URLs.PRODUCTS.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isProductsHomeCrumbVisible());
        breadCrumbsBasePage.goToHomePageViaBreadCrumb();
        Assert.assertTrue(homePage.isMainHeaderPresent());
        Assert.assertTrue(homePage.isMainLogoPresent());
    }

    @Test
    public void productsItemOpensRightPage() {
        BasePage.openURL(URLs.PRODUCTS.URL());
        cookiesPanelPage.acceptCookies();
        productsHomePage.compareProductsNamesWithPages();
    }
}


