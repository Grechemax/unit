package pageObjects;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WhyUnit4Page extends BasePage {
    private By whyUni4MainTitle = By.xpath("//h1[contains(text(), 'Why Unit4')]");

    public WhyUnit4Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isWhyUni4MainTitlePresent() {
        Reporter.log("verify that 'Why Unit 4' main title is present");
        waitForElement(whyUni4MainTitle);
        return isElementPresent(whyUni4MainTitle);
    }
}
