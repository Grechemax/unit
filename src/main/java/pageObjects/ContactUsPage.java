package pageObjects;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage {
    private By contactUsPageMainHeader = By.xpath("//h1[contains(text(), 'How can we help?')]");

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isContactUsMainTitlePresent() {
        waitForElement(contactUsPageMainHeader);
        Reporter.log("'How can we help?' - main title on 'Contact Us' is present");
        return isElementPresent(contactUsPageMainHeader);
    }


}
