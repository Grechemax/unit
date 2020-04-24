package pageObjects.footer;

import base.BasePage;
import base.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FooterGeneralPage extends BasePage {
    private By companyLink = By.xpath("//footer//a[contains(text(), 'The Company')]");
    private By leadershipLink = By.xpath("//footer//a[contains(text(), 'Leadership')]");
    private By partnersLink = By.xpath("//footer//a[contains(text(), 'Partners')]");
    private By newsLink = By.xpath("//footer//a[contains(text(), 'News')]");

    private By careersLink = By.xpath("//footer//a[contains(text(), 'Careers')]");
    private By servicesLink = By.xpath("//footer//a[contains(text(), 'Services')]");
    private By supportLink = By.xpath("//footer//a[contains(text(), 'Support')]");
    private By privacyLink = By.xpath("//footer//a[contains(text(), 'Privacy & Trust')]");

    private By contactSalesLink = By.xpath("//footer//a[contains(text(), 'Contact Sales')]");
    private By communityPortalLink = By.xpath("//footer//a[contains(text(), 'Community Portal')]");
    private By locationsLink = By.xpath("//footer//a[contains(text(), 'Locations')]");

    //Social media
    private By fbIcon = By.xpath("//img[@alt = 'facebook']");
    private By linkedInIcon = By.xpath("//img[@alt = 'linkedin']");
    private By twitterIcon = By.xpath("//img[@alt = 'twitter']");
    private By instagramIcon = By.xpath("//img[@alt = 'instagram']");

    //Very bottom
    private By termsAndConditionsLink = By.xpath("//footer//a[contains(text(), 'Terms & Conditions')]");
    private By disclaimerLink = By.xpath("//footer//a[contains(text(), 'Disclaimer')]");
    private By cookiesLink = By.xpath("//footer//a[contains(text(), 'Cookies')]");
    private By modernSlaveryLink = By.xpath("//footer//a[contains(text(), 'Modern Slavery')]");
    private By trademarksLink = By.xpath("//footer//a[contains(text(), 'Trademarks')]");
    private By sitemapLink = By.xpath("//footer//a[contains(text(), 'Sitemap')]");

    public FooterGeneralPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //About Unit4
    public void clickCompanyLink() {
        Reporter.log("clicking 'The Company' link in the footer");
        clickOnElement(companyLink);
    }

    public void clickLeadershipLink() {
        Reporter.log("clicking 'Leadership' link in the footer");
        clickOnElement(leadershipLink);
    }

    public void clickPartnersLink() {
        Reporter.log("clicking 'Partners' link in the footer");
        clickOnElement(partnersLink);
    }

    public void clickNewsLink() {
        Reporter.log("clicking 'News' link in the footer");
        clickOnElement(newsLink);
    }

    public void clickCareersLink() {
        Reporter.log("clicking 'Careers' link in the footer");
        clickOnElement(careersLink);
    }

    public void clickServicesLink() {
        Reporter.log("clicking 'Services' link in the footer");
        clickOnElement(servicesLink);
    }

    public void clickSupportLink() {
        Reporter.log("clicking 'Support' link in the footer");
        clickOnElement(supportLink);
    }

    public void clickPrivacyLink() {
        Reporter.log("clicking 'Privacy & Trust' link in the footer");
        clickOnElement(privacyLink);
    }


    //Contact Us section
    public void clickContactSalesLink() {
        Reporter.log("clicking 'Contact Sales' link in the footer");
        clickOnElement(contactSalesLink);
    }

    public void clickCommunityPortalLink() {
        Reporter.log("clicking 'Community Portal' link in the footer");
        clickOnElement(communityPortalLink);
    }

    public void clickLocationsLink() {
        Reporter.log("clicking 'Locations' link in the footer");
        clickOnElement(locationsLink);
    }

    //Social media
    public void clickFacebookIcon() {
        Reporter.log("clicking 'Facebook' link in the footer");
        clickOnElement(fbIcon);
    }

    public void clickLinkedInIcon() {
        Reporter.log("clicking 'LinkedIn' link in the footer");
        clickOnElement(linkedInIcon);
    }

    public void clickTwitterIcon() {
        Reporter.log("clicking 'TwitterIcon' link in the footer");
        clickOnElement(twitterIcon);
    }

    public void clickInstagramIcon() {
        Reporter.log("clicking 'InstagramIcon' link in the footer");
        clickOnElement(instagramIcon);
    }

    public void clickTermsAndConditions() {
        Reporter.log("clicking 'Terms & Conditions' link in the footer");
        clickOnElement(termsAndConditionsLink);
    }

    public void clickDisclaimer() {
        Reporter.log("clicking 'Disclaimer' link in the footer");
        clickOnElement(disclaimerLink);
    }

    public void clickCookies() {
        Reporter.log("clicking 'Cookies' link in the footer");
        clickOnElement(cookiesLink);
    }

    public void clickModernSlavery() {
        Reporter.log("clicking 'Modern Slavery' link in the footer");
        clickOnElement(modernSlaveryLink);
    }

    public void clickTrademarks() {
        Reporter.log("clicking 'Trademerks' link in the footer");
        clickOnElement(trademarksLink);
    }

    public void clickSitemap() {
        Reporter.log("clicking 'Sitemap' link in the footer");
        clickOnElement(sitemapLink);
    }

}
