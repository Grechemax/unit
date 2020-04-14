package customersTests;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.customers.CityOfPortPage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.ScrewfixPage;
import pageObjects.products.EnterpriseResourcePlanningPage;

public class ScrewfixTest extends BaseTest {
    ScrewfixPage screwfixPage;
    CustomersHomePage customersHomePage;
    BreadCrumbsBasePage breadCrumbsBasePage;


    @Test
    public void checkAllTitles() {
        BasePage.openURL(Urls.CUSTOMERS.URL());
        screwfixPage = new ScrewfixPage(getDriver());
        customersHomePage = new CustomersHomePage(getDriver());
        customersHomePage.goToScrewFixBLock();
        Assert.assertTrue(screwfixPage.isScrewfixPageMainTitlePresent());
        Assert.assertTrue(screwfixPage.isChallengeTitlePresented());
        Assert.assertTrue(screwfixPage.isImpactsTitlePresent());
        Assert.assertTrue(screwfixPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(screwfixPage.isUnit4FinancialsBlockTitlePresent());

    }

    @Test
    public void checkReadMoreOpensRightPage() {
        breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
        screwfixPage.clickReadMoreButton();
        Assert.assertTrue(breadCrumbsBasePage.isFinancialsCrumbVisible());
    }

}
