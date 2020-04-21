package customersTests.customers;

import base.BasePage;
import base.BaseTest;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.customers.customers.WarChildPage;

public class WarChildTest extends BaseTest {
    WarChildPage warChildPage = new WarChildPage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());

    @Test
    public void checkAllTitles() {
        BasePage.openURL(URLs.CUSTOMERS_WAR_CHILD.URL());
        Assert.assertTrue(warChildPage.isWarChildMainTitlePresent());
        Assert.assertTrue(warChildPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(warChildPage.isChallengeTitlePresented());
        Assert.assertTrue(warChildPage.isERPTitlePresent());
        Assert.assertTrue(warChildPage.isImpactsTitlePresent());
    }

    @Test
    public void checkWarChildPageBreadCrumb() {
        BasePage.openURL(URLs.CUSTOMERS_WAR_CHILD.URL());
        Assert.assertTrue(breadCrumbsBasePage.isWarChildCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensERPPage() {
        BasePage.openURL(URLs.CUSTOMERS_WAR_CHILD.URL());
        warChildPage.clickReadMoreButton();
        Assert.assertTrue(breadCrumbsBasePage.isProductsERPCrumbCrumbVisible());
    }
}
