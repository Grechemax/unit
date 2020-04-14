package customersTests;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.ManchesterUniversityPage;
import pageObjects.products.StudentManagementPage;

public class ManchesterUniversityTest extends BaseTest {

    HomePage homePage;
    CustomersHomePage customersHomePage;
    BreadCrumbsBasePage breadCrumbsBasePage;
    StudentManagementPage studentManagementPage;
    ManchesterUniversityPage manchesterUniversityPage;

    @Test
    public void checkAllTitles() {
        BasePage.openURL(Urls.CUSTOMERS.URL());
        homePage = new HomePage(getDriver());
        manchesterUniversityPage = new ManchesterUniversityPage(getDriver());
        customersHomePage = new CustomersHomePage(getDriver());

//        homePage.acceptCookies();
        customersHomePage.goToManchesterUniversityBLock();
        Assert.assertTrue(manchesterUniversityPage.isManchesterMainTitlePresent());
        Assert.assertTrue(manchesterUniversityPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(manchesterUniversityPage.isChallengeTitlePresented());
        Assert.assertTrue(manchesterUniversityPage.isChallengeTitlePresented());
        Assert.assertTrue(manchesterUniversityPage.isUnit4StudentManagementBlockTitlePresent());
        Assert.assertTrue(manchesterUniversityPage.isImpactsTitlePresent());
    }

    @Test
    public void checkReadMoreOpensRightPage() {
        manchesterUniversityPage.clickReadMoreButton();
        breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
        studentManagementPage = new StudentManagementPage(getDriver());
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());

    }

}
