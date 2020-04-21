package pageObjects.footer;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LocationsPage extends BasePage {
    private By locationsPageMainHeader = By.xpath("//h1[contains(text(), 'Unit4 Locations')]");


    public LocationsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isLocationsMainHeaderPresent() {
        waitForElement(locationsPageMainHeader);
        Reporter.log("'Locations' main title is present");
        return isElementPresent(locationsPageMainHeader);
    }
}
