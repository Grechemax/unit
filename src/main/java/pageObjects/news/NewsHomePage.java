package pageObjects.news;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class NewsHomePage extends BasePage {
    private By newsHomePageMainHeader = By.xpath("//h1[contains(text(), 'Unit4 News')]");


    public NewsHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isNewsHomePageMainHeaderPresent() {
        waitForElement(newsHomePageMainHeader);
        Reporter.log("Main title is present on 'News' home page");
        return isElementPresent(newsHomePageMainHeader);
    }
}