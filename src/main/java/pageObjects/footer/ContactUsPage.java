package pageObjects.footer;

import base.BasePage;
import base.BreadCrumbsBasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.HomePage;

public class ContactUsPage extends BasePage {
    HomePage homePage = new HomePage(getDriver());
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private By contactUsPageMainHeader = By.xpath("//h1[contains(text(), 'How can we help?')]");


    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isContactUsMainTitlePresent() {
        waitForElement(contactUsPageMainHeader);
        Reporter.log("'How can we help?' - main title on 'Contact Us' is present");
        return isElementPresent(contactUsPageMainHeader);
    }


    public void compareLocationsNamesWithPages() {
        int locationsQuantity = getDriver().findElements(By.xpath("//ul[contains(@class, 'plain equally-spaced-items')]/li/a")).size();

        String locationElement = "//ul[contains(@class, 'plain equally-spaced-items')]/li[%s]/a";

        for (int i = 1; i <= locationsQuantity; i++) {
            By item = By.xpath(String.format(locationElement, i));
            Reporter.log("Comparing location name #" + i + " with title of opened page");
            String postTitle = getElementText(item);
            System.out.println(postTitle);
            clickOnElement(item);
            String currentBreadCrumb = breadCrumbsBasePage.getCurrentBreadCrumb();
            Assert.assertEquals(postTitle, currentBreadCrumb);
            getDriver().navigate().back();
            Assert.assertTrue(homePage.isMainHeaderPresent());
        }
    }
}
