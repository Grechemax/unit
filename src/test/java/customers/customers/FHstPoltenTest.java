package customers.customers;

import base.BasePage;
import base.BreadCrumbsBasePage;
import data.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.customers.customers.FHstPoltenPage;

public class FHstPoltenTest extends BasePage {
    FHstPoltenPage fHstPoltenPage = new FHstPoltenPage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());

    @Test
    public void checkAllTitles() {
        BasePage.openURL(URLs.CUSTOMERS_FH_ST_POLTEN.URL());
        Assert.assertTrue(fHstPoltenPage.isFHPoltenMainTitlePresent());
        Assert.assertTrue(fHstPoltenPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(fHstPoltenPage.isChallengeTitlePresented());
        Assert.assertTrue(fHstPoltenPage.isFinancialPlanningBlockTitlePresent());
        Assert.assertTrue(fHstPoltenPage.isImpactsTitlePresent());
    }

    @Test
    public void checkFHstPoltenPageBreadCrumb() {
        BasePage.openURL(URLs.CUSTOMERS_FH_ST_POLTEN.URL());
        Assert.assertTrue(breadCrumbsBasePage.isFHstPoltenCrumbVisible());
    }

    @Test
    public void checkReadMoreOpensRightPage() {
        BasePage.openURL(URLs.CUSTOMERS_FH_ST_POLTEN.URL());
        fHstPoltenPage.clickReadMoreAboutFinancialPlanning();
        Assert.assertTrue(breadCrumbsBasePage.isDeliver360CrumbVisible());
    }

    @Test
    public void downloadCaseStudyOpensPDFPage() {
        BasePage.openURL(URLs.CUSTOMERS_FH_ST_POLTEN.URL());
        fHstPoltenPage.clickDownloadCaseStudy();
        BasePage.switchToLastTab();
        Assert.assertTrue(BasePage.isCurrentUrlContains(".pdf"));
    }
}
