package pageObjects.products;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FinancialsPage extends BasePage {
    private By financialsPageMainTitle = By.xpath("//h1[contains(text(), 'Unit4 Financials')]");

    public FinancialsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isFinancialsPageMainTitlePresent() {
        waitForPresenceOfElement(findElement(financialsPageMainTitle));
        Reporter.log("main Financials Page Header is present");
        return isElementPresent(findElement(financialsPageMainTitle));
    }
}
