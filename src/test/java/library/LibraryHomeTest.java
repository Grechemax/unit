package library;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import base.LetsTalkSectionPage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.RequestDemoPopupPage;
import pageObjects.library.LibraryHomePage;

public class LibraryHomeTest extends BaseTest {
    LibraryHomePage libraryHomePage = new LibraryHomePage(getDriver());
    CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    LetsTalkSectionPage letsTalkSectionPage = new LetsTalkSectionPage(getDriver());
    RequestDemoPopupPage requestDemoPopupPage = new RequestDemoPopupPage(getDriver());

    @Test(groups = {"Sanity"})
    public void checkLibraryHomePageCrumb() {
        BasePage.openURL(URLs.LIBRARY.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isLibraryCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void openRequestDemoViaSection() {
        BasePage.openURL(URLs.LIBRARY.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(letsTalkSectionPage.isLetsTalkTextPresent());
        letsTalkSectionPage.clickRequestDemoInSection();
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormMainHeaderPresent());
        Assert.assertTrue(requestDemoPopupPage.isRequestDemoFormHeaderPresent());
        requestDemoPopupPage.closeRequestDemoForm();
    }

    @Test(groups = {"Sanity"})
    public void downloadPDFOpensPDF() {
        BasePage.openURL(URLs.LIBRARY.URL());
        cookiesPanelPage.acceptCookies();
        libraryHomePage.clickDownloadPDF();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }
}
