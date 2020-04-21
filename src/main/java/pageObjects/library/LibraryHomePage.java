package pageObjects.library;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LibraryHomePage extends BasePage {
    private By libraryHomeMainTitle = By.xpath("//h2[contains(text(), 'Vast improvements')]");
    private By downloadPDF = By.xpath("//a[contains(text(), 'Download PDF')]");


    public LibraryHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isLibraryHomeMainTitlePresent() {
        Reporter.log("verify that 'Library' home page main title is present");
        waitForElement(libraryHomeMainTitle);
        return isElementPresent(libraryHomeMainTitle);
    }
    public void clickDownloadPDF(){
        Reporter.log("clicking 'Download PDF' button");
        clickOnElement(downloadPDF);
    }

}
