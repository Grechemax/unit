package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {
    private By searchResultHeader = By.xpath("//h1[contains(text(), 'Search Unit4')]");

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
