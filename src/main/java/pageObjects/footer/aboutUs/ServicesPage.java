package pageObjects.footer.aboutUs;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage extends BasePage {
    private By servicesPageMainHeader = By.xpath("//h1[contains(text(), 'Our Customer Service')]");


    public ServicesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isServicesPageMainHeaderPresent() {
        waitForElement(servicesPageMainHeader);
        Reporter.log("'Services' main title is present");
        return isElementPresent(servicesPageMainHeader);
    }
}
