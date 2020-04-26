package customers;

import base.*;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;

public class CustomersHomePageTest extends BaseTest {
    private CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());

    @Test(groups = {"Sanity"})
    public void checkAllTitles() {
        BasePage.openURL(URLs.CUSTOMERS.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(customersHomePage.isScrewFixTitlePresent());
        Assert.assertTrue(customersHomePage.isWarChildTitlePresent());
        Assert.assertTrue(customersHomePage.isCityOfPortTitlePresent());
        Assert.assertTrue(customersHomePage.isStanleySecurityTitlePresent());
        Assert.assertTrue(customersHomePage.isAustrianUniversityTitlePresent());
        Assert.assertTrue(customersHomePage.isManchesterUniversityTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkCustomersHomePageBreadCrumb() {
        BasePage.openURL(URLs.CUSTOMERS.URL());
        cookiesPanelPage.acceptCookies();
        breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
        breadCrumbsBasePage.isCustomersCrumbVisible();
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaHeader() {
        BasePage.openURL(URLs.CUSTOMERS.URL());
        cookiesPanelPage.acceptCookies();
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.CUSTOMERS.URL());
        cookiesPanelPage.acceptCookies();
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }
}
