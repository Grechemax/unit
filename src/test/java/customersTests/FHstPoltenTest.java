package customersTests;

import base.BasePage;
import base.BreadCrumbsBasePage;
import data.Urls;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.customers.CustomersHomePage;
import pageObjects.customers.FHstPoltenPage;

public class FHstPoltenTest extends BasePage {
    HomePage homePage;
    FHstPoltenPage fHstPoltenPage;
    CustomersHomePage customersHomePage;
    BreadCrumbsBasePage breadCrumbsBasePage;

    @Test
    public void checkAllTitles() {
        BasePage.openURL(Urls.CUSTOMERS.URL());
        homePage = new HomePage(getDriver());
        fHstPoltenPage = new FHstPoltenPage(getDriver());
        customersHomePage = new CustomersHomePage(getDriver());

        homePage.acceptCookies();
        customersHomePage.goToAustrianUniversityBlock();
        Assert.assertTrue(fHstPoltenPage.isFHPoltenMainTitlePresent());
        Assert.assertTrue(fHstPoltenPage.isDownloadCaseStudyBtnPresented());
        Assert.assertTrue(fHstPoltenPage.isChallengeTitlePresented());
        Assert.assertTrue(fHstPoltenPage.isFinancialPlanningBlockTitlePresent());
        Assert.assertTrue(fHstPoltenPage.isImpactsTitlePresent());
    }

    @Test
    public void checkReadMoreOpensRightPage() {
        fHstPoltenPage.clickReadMoreButton();
        breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
        Assert.assertTrue(breadCrumbsBasePage.isDeliver360CrumbVisible());
    }

}
