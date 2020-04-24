package pageObjects.products;

import base.BasePage;
import base.BreadCrumbsBasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductsHomePage extends BasePage {
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());

    private By productsHomePageMainTitle = By.xpath("//h1[contains(text(), 'Unit4 Products')]");
    private By productsHomePageMainIntro = By.xpath("//div[contains(@class, ' intro')]");

    public ProductsHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isProductsHomePageMainTitlePresent() {
        waitForElement(productsHomePageMainIntro);
        Reporter.log("Products Home Page Header is present");
        return isElementPresent(productsHomePageMainTitle);
    }

    public boolean isProductsHomePageIntroPresent() {
        waitForElement(productsHomePageMainIntro);
        Reporter.log("Products Home Page Intro is present");
        return isElementPresent(productsHomePageMainIntro);
    }

    public void compareProductsNamesWithPages() {
        //todo item can be opened in inner or external page
//        int productsQuantity = getDriver().findElements(By.xpath("//div[contains(@class, 'tile-group-tile-wrap')]//div[contains(@class, 'tile')]//h3")).size();
//
//        String locationElement = "//div[contains(@class, 'tile-group-tile-wrap')]//div[%s]//h3";
//
//        for (int i = 1; i <= productsQuantity; i++) {
//            By item = By.xpath(String.format(locationElement, i));
//            Reporter.log("Comparing product name #" + i + " with title of opened page");
//            String postTitle = getElementText(item);
//            System.out.println(postTitle);
//            clickOnElement(item);
//            Assert.assertEquals(postTitle, breadCrumbsBasePage.getCurrentBreadCrumb());
//            getDriver().navigate().back();
//        }
    }
}
