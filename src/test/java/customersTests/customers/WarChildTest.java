package customersTests.customers;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.customers.customers.FHstPoltenPage;
import pageObjects.customers.customers.WarChildPage;

public class WarChildTest extends BaseTest {
    WarChildPage warChildPage = new WarChildPage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());

    @Test(priority = 1)
    public void checkAllTitles() {
        BasePage.openURL(Urls.CUSTOMERS_WAR_CHILD.URL());
        Assert.assertTrue(warChildPage.isWarChildMainTitlePresent());
        Assert.assertTrue(warChildPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(warChildPage.isChallengeTitlePresented());
        Assert.assertTrue(warChildPage.isERPTitlePresent());
        Assert.assertTrue(warChildPage.isImpactsTitlePresent());
    }

    @Test(priority = 2)
    public void checkWarChildPageBreadCrumb() {
        Assert.assertTrue(breadCrumbsBasePage.isWarChildCrumbVisible());
    }

    @Test(priority = 3)
    public void checkReadMoreOpensERPPage() {
        warChildPage.clickReadMoreButton();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }
}
