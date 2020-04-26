package customers.customers;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.cookies.CookiesPanelPage;
import pageObjects.customers.customers.ManchesterUniversityPage;
import pageObjects.products.StudentManagementPage;

public class ManchesterUniversityTest extends BaseTest {
    CookiesPanelPage cookiesPanelPage = new CookiesPanelPage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    StudentManagementPage studentManagementPage = new StudentManagementPage(getDriver());
    ManchesterUniversityPage manchesterUniversityPage = new ManchesterUniversityPage(getDriver());

    @Test(groups = {"Sanity"})
    public void checkAllTitles() {
        BasePage.openURL(URLs.CUSTOMERS_MANCHESTER.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(manchesterUniversityPage.isManchesterMainTitlePresent());
        Assert.assertTrue(manchesterUniversityPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(manchesterUniversityPage.isChallengeTitlePresented());
        Assert.assertTrue(manchesterUniversityPage.isUnit4StudentManagementBlockTitlePresent());
        Assert.assertTrue(manchesterUniversityPage.isImpactsTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkManchesterPageBreadCrumb() {
        BasePage.openURL(URLs.CUSTOMERS_MANCHESTER.URL());
        cookiesPanelPage.acceptCookies();
        Assert.assertTrue(breadCrumbsBasePage.isManchesterCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensRightPage() {
        BasePage.openURL(URLs.CUSTOMERS_MANCHESTER.URL());
        cookiesPanelPage.acceptCookies();
        manchesterUniversityPage.clickReadMoreButton();
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void downloadCaseStudyOpensPDFPage() {
        BasePage.openURL(URLs.CUSTOMERS_MANCHESTER.URL());
        cookiesPanelPage.acceptCookies();
        manchesterUniversityPage.clickDownloadCaseStudy();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }
}
