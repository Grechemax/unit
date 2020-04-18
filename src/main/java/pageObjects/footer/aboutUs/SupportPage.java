package pageObjects.footer.aboutUs;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SupportPage extends BasePage {

    private By supportPageMainHeader = By.xpath("//h1[contains(text(), 'Support from Unit4')]");


    public SupportPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isSupportPageMainHeaderPresent() {
        waitForElement(supportPageMainHeader);
        Reporter.log("'Support' main title is present");
        return isElementPresent(supportPageMainHeader);
    }
}
