package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FooterBasePage extends BasePage {
    private By contactSalesLink = By.xpath("//a[contains(text(), 'Contact Sales')]");
    private By communityPortal = By.xpath("//a[contains(text(), 'Community Portal')]");
    private By locations = By.xpath("//a[contains(text(), 'Locations')]");

    public FooterBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Contact Us section
    public void clickContactSalesLink() {
        Reporter.log("clicking 'Contact Sales' link in the footer");
        clickOnElement(contactSalesLink);
    }

    public void clickCommunityPortalLink() {
        Reporter.log("clicking 'Community Portal' link in the footer");
        clickOnElement(communityPortal);
    }

    public void clickLocationsLink() {
        Reporter.log("clicking 'Locations' link in the footer");
        clickOnElement(locations);
    }
}
