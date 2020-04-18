package customersTests.customers;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.customers.ScrewfixPage;

public class ScrewfixTest extends BaseTest {
    ScrewfixPage screwfixPage;
    CustomersHomePage customersHomePage;
    BreadCrumbsBasePage breadCrumbsBasePage;


    @Test
    public void checkAllTitles() {
        BasePage.openURL(URLs.CUSTOMERS_SCREWFIX.URL());
        screwfixPage = new ScrewfixPage(getDriver());
        customersHomePage = new CustomersHomePage(getDriver());
        Assert.assertTrue(screwfixPage.isScrewfixPageMainTitlePresent());
        Assert.assertTrue(screwfixPage.isChallengeTitlePresented());
        Assert.assertTrue(screwfixPage.isImpactsTitlePresent());
        Assert.assertTrue(screwfixPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(screwfixPage.isUnit4FinancialsBlockTitlePresent());

    }

    @Test
    public void checkScrewfixPageBreadCrumb() {
        Assert.assertTrue(breadCrumbsBasePage.isScrewfixCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensRightPage() {
        breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
        screwfixPage.clickReadMoreButton();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialsCrumbVisible());
    }

}
