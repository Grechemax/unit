package customers.customers;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.customers.customers.StanleySecurityPage;
import pageObjects.products.StudentManagementPage;

public class StanleySecurityTest extends BaseTest {
    StanleySecurityPage stanleySecurityPage = new StanleySecurityPage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    StudentManagementPage studentManagementPage = new StudentManagementPage(getDriver());

    @Test(groups = {"Sanity"})
    public void checkAllTitles() {
        BasePage.openURL(URLs.CUSTOMERS_STANLEY.URL());
        Assert.assertTrue(stanleySecurityPage.isStanleySecurityPageMainTitlePresent());
        Assert.assertTrue(stanleySecurityPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(stanleySecurityPage.isChallengeTitlePresented());
        Assert.assertTrue(stanleySecurityPage.isERPBlockTitlePresent());
        Assert.assertTrue(stanleySecurityPage.isImpactsTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void checkStanleyPageBreadCrumb() {
        BasePage.openURL(URLs.CUSTOMERS_STANLEY.URL());
        Assert.assertTrue(breadCrumbsBasePage.isStanleySecurityCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensRightPage() {
        BasePage.openURL(URLs.CUSTOMERS_STANLEY.URL());
        stanleySecurityPage.clickReadMoreButton();
        Assert.assertTrue(breadCrumbsBasePage.isStudentManagementCrumbVisible());
        Assert.assertTrue(studentManagementPage.isMainTitlePresent());
    }

    @Test(groups = {"Sanity"})
    public void downloadCaseStudyOpensPDFPage() {
        BasePage.openURL(URLs.CUSTOMERS_STANLEY.URL());
        stanleySecurityPage.clickDownloadCaseStudy();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }
}
