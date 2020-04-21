package library;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import base.LetsTalkSectionPage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.library.LibraryHomePage;

public class LibraryHomeTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    LibraryHomePage libraryHomePage = new LibraryHomePage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());

    @Test
    public void checkLibraryHomePageCrumb() {
        BasePage.openURL(URLs.LIBRARY.URL());
        homePage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isLibraryCrumbVisible());
    }

    @Test
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.LIBRARY.URL());
        homePage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test
    public void downloadPDFOpensPDF() {
        BasePage.openURL(URLs.LIBRARY.URL());
        homePage.acceptCookies();
        libraryHomePage.clickDownloadPDF();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }
}
