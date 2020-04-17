package pageObjects.industries;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class IndustriesHomePage extends BasePage {
    private By industriesHomeMainTitle = By.xpath("//h1[contains(text(), 'Our Industry Focus')]");

    public IndustriesHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isIndustriesHomeMainTitlePresent() {
        Reporter.log("verify that 'Industries' main title is present");
        waitForElement(industriesHomeMainTitle);
        return isElementPresent(industriesHomeMainTitle);
    }
}
