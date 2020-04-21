package pageObjects.footer;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PartnersPage extends BasePage {

    private By partnersPageMainHeader = By.xpath("//h1[contains(text(), 'Unit4 Partner Ecosystem')]");


    public PartnersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isPartnersPageMainHeaderPresent() {
        waitForElement(partnersPageMainHeader);
        Reporter.log("'Partners' main title is present");
        return isElementPresent(partnersPageMainHeader);
    }
}
