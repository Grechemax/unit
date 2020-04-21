package pageObjects;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NotFoundPage extends BasePage {
    private By main404Title = By.xpath("//h1[contains(text(), 'It looks like')]");
    private By takeMeHomeBtn = By.xpath("//a[contains(text(), 'Take me home')]");

    public NotFoundPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isNonFoundMainTitlePresent() {
        waitForElement(main404Title);
        Reporter.log("Main title of 404 page is present");
        return isElementPresent(main404Title);
    }


    public void clickTakeMeHomeBtn() {
        clickOnElement(takeMeHomeBtn);
    }
}
