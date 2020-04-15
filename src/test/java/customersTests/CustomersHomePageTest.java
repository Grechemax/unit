package customersTests;

import base.*;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.customers.CustomersHomePage;

public class CustomersHomePageTest extends BaseTest {
    private HomePage homePage = new HomePage(getDriver());
    private HeaderBasePage headerBasePage = new HeaderBasePage(getDriver());
    private CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    private BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    private RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());

    @Test
    public void checkAllTitles() {
        BasePage.openURL(Urls.CUSTOMERS.URL());
        homePage.acceptCookies();
        Assert.assertTrue(customersHomePage.isCustomersMainTitlePresent());
        Assert.assertTrue(customersHomePage.isScrewFixTitlePresent());
        Assert.assertTrue(customersHomePage.isWarChildTitlePresent());
        Assert.assertTrue(customersHomePage.isCityOfPortTitlePresent());
        Assert.assertTrue(customersHomePage.isStanleySecurityTitlePresent());
        Assert.assertTrue(customersHomePage.isAustrianUniversityTitlePresent());
        Assert.assertTrue(customersHomePage.isManchesterUniversityTitlePresent());
    }

    @Test
    public void checkCustomersHomePageBreadCrumb() {
        breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
        breadCrumbsBasePage.isCustomersCrumbVisible();
    }

    @Test()
    public void openRequestDemoViaHeader() {
        headerBasePage.clickRequestDemoForm();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test()
    public void openRequestDemoViaSection() {
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }
}
