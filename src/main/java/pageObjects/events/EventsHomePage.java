package pageObjects.events;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EventsHomePage extends BasePage {
    private By eventsHomeMainTitle = By.xpath("//h1[contains(text(), 'Unit4 Events')]");


    public EventsHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isEventsHomeMainTitlePresent() {
        Reporter.log("Verify is events home main title present");
        waitForElement(eventsHomeMainTitle);
        return isElementPresent(eventsHomeMainTitle);
    }

    public void clickShowMoreToLoadMoreEventsItems() {
        Reporter.log("clicking 'Show more' on Events Page to show more events");
        clickShowMoreUntilVisible();
    }
}
