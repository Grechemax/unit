package pageObjects.footer.aboutUs;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LeadershipTeamPage extends BasePage {
    private By leadershipTeamPageMainHeader = By.xpath("//h1[contains(text(), 'Meet our Global Leadership Team')]");


    public LeadershipTeamPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isLeadershipTeamMainHeaderPresent() {
        waitForElement(leadershipTeamPageMainHeader);
        Reporter.log("'Leadership team' main title is present");
        return isElementPresent(leadershipTeamPageMainHeader);
    }
}
