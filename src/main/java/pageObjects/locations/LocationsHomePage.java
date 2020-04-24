package pageObjects.locations;

import base.BasePage;
import base.BreadCrumbsBasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LocationsHomePage extends BasePage {
    BreadCrumbsBasePage breadCrumbsBasePage = new BreadCrumbsBasePage(getDriver());
    private By locationsPageMainHeader = By.xpath("//h1[contains(text(), 'Unit4 Locations')]");



    public LocationsHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isLocationsMainHeaderPresent() {
        waitForElement(locationsPageMainHeader);
        Reporter.log("'Locations' main title is present");
        return isElementPresent(locationsPageMainHeader);
    }

    public void clickShowMoreToLoadMoreLocationItems() {
        Reporter.log("clicking 'Show more' on Locations Page to show more locations");
        clickShowMoreUntilVisible();
    }

    public void compareLocationsNamesWithPages() {
        int locationsQuantity = getDriver().findElements(By.xpath("//div[contains(@class, 'tile-group-tile-wrap')]//div[contains(@class, 'tile tile--location clickable')]")).size();

        String locationElement = "//div[contains(@class, 'tile-group-tile-wrap')]//div[contains(@class, 'tile tile--location clickable')][%s]//span";

        for (int i = 1; i <= locationsQuantity; i++) {
            By item = By.xpath(String.format(locationElement, i));
            Reporter.log("Comparing location name #" + i + " with title of opened page");
            String postTitle = getElementText(item);
            System.out.println(postTitle);
            clickOnElement(item);
            Assert.assertEquals(postTitle, breadCrumbsBasePage.getCurrentBreadCrumb());
            getDriver().navigate().back();
        }
    }

}
