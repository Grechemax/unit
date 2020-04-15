package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LetsTalkSectionPage extends BasePage {
    private By requestDemoBtnInSection = By.xpath("//section//*[contains(text(), 'Request a demo')]");
    private By letsTalkText = By.xpath("//*[contains(text(), 'Let’s talk about what People Experience means 4U')]");

    public LetsTalkSectionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public boolean isLetsTalkTextPresent() {
        return isElementPresent(letsTalkText);
    }

    public void clickRequestDemoInSection() {
        clickOnElement(requestDemoBtnInSection);
    }
}
