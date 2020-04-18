package pageObjects.footer.aboutUs;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AboutUsHomePage extends BasePage {
    private By aboutUsPageMainHeader = By.xpath("//h1[contains(text(), 'Unit4 is in business for people')]");


    public AboutUsHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isAboutUsPageMainHeaderPresent() {
        waitForElement(aboutUsPageMainHeader);
        Reporter.log("'About Us' main title is present");
        return isElementPresent(aboutUsPageMainHeader);
    }
}
