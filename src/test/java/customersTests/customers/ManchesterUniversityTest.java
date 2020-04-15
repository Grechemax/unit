package customersTests.customers;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.customers.customers.ManchesterUniversityPage;
import pageObjects.products.StudentManagementPage;

public class ManchesterUniversityTest extends BaseTest {
    HomePage homePage = new HomePage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    StudentManagementPage studentManagementPage = new StudentManagementPage(getDriver());
    ManchesterUniversityPage manchesterUniversityPage = new ManchesterUniversityPage(getDriver());

    @Test
    public void checkAllTitles() {
        BasePage.openURL(Urls.CUSTOMERS_MANCHESTER.URL());
        homePage.acceptCookies();
        Assert.assertTrue(manchesterUniversityPage.isManchesterMainTitlePresent());
        Assert.assertTrue(manchesterUniversityPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(manchesterUniversityPage.isChallengeTitlePresented());
        Assert.assertTrue(manchesterUniversityPage.isUnit4StudentManagementBlockTitlePresent());
        Assert.assertTrue(manchesterUniversityPage.isImpactsTitlePresent());
    }

    @Test
    public void checkManchesterPageBreadCrumb() {
        Assert.assertTrue(breadCrumbsBasePage.isManchesterCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensRightPage() {
        manchesterUniversityPage.clickReadMoreButton();
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
    }
}
