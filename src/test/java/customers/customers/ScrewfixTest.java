package customers.customers;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.ScrewfixPage;

public class ScrewfixTest extends BaseTest {
    ScrewfixPage screwfixPage = new ScrewfixPage(getDriver());
    CustomersHomePage customersHomePage = new CustomersHomePage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());


    @Test(groups = {"Sanity"})
    public void checkAllTitles() {
        BasePage.openURL(URLs.CUSTOMERS_SCREWFIX.URL());
        Assert.assertTrue(screwfixPage.isScrewfixPageMainTitlePresent());
        Assert.assertTrue(screwfixPage.isChallengeTitlePresented());
        Assert.assertTrue(screwfixPage.isImpactsTitlePresent());
        Assert.assertTrue(screwfixPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(screwfixPage.isUnit4FinancialsBlockTitlePresent());

    }

    @Test(groups = {"Sanity"})
    public void checkScrewfixPageBreadCrumb() {
        BasePage.openURL(URLs.CUSTOMERS_SCREWFIX.URL());
        Assert.assertTrue(breadCrumbsBasePage.isScrewfixCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void checkReadMoreOpensRightPage() {
        BasePage.openURL(URLs.CUSTOMERS_SCREWFIX.URL());
        screwfixPage.clickReadMoreButton();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialsCrumbVisible());
    }

    @Test(groups = {"Sanity"})
    public void downloadCaseStudyOpensPDFPage() {
        BasePage.openURL(URLs.CUSTOMERS_SCREWFIX.URL());
        screwfixPage.clickDownloadCaseStudy();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }
}
