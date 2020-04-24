package pageObjects.cookies;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CookiesHomePage extends BasePage {
    By cookiesMainTitle = By.xpath("//h1[contains(text(), 'Manage Your Data')]");


    public CookiesHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public boolean isCookiesHomePageMainHeaderPresent() {
        waitForElement(cookiesMainTitle);
        Reporter.log("request form main header is present");
        return isElementPresent(cookiesMainTitle);
    }

}
